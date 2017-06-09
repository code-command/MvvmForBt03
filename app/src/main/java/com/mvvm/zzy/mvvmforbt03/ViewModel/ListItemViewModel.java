package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.mvvm.zzy.mvvmforbt03.Model.BlueTooth_Auto_Pair;
import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.View.DataTransmissionActivity;

import java.util.List;

/**
 * Created by zhangziyu on 2017/6/7.
 */

public class ListItemViewModel implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    private Context context;
    private BluetoothAdapter btAdapter;
    private List<BtDeviceItem> deviceList;
    private DeviceAdapter deviceAdapter;

    private ListItemViewUpdata listItemViewUpdata;

    public ListItemViewModel(Context context, BluetoothAdapter btAdapter, DeviceAdapter deviceAdapter) {
        this.context = context;
        this.btAdapter = btAdapter;
        this.deviceAdapter = deviceAdapter;
        deviceList = deviceAdapter.getList();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(btAdapter !=null && btAdapter.isDiscovering())
            btAdapter.cancelDiscovery();
        processBondState(deviceList.get(position).getBtDevice());
    }

    private void processBondState(BluetoothDevice btDevice) {
        switch (btDevice.getBondState()) {
            case BluetoothDevice.BOND_NONE:
                processDeviceBondNone(btDevice);
                break;

            case BluetoothDevice.BOND_BONDED:
                processDeviceBondBonded(btDevice);
                break;

            default:
                break;
        }
    }

    private void processDeviceBondNone(BluetoothDevice btDevice) {
        try {
            BlueTooth_Auto_Pair.creatBond(btDevice.getClass(), btDevice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processDeviceBondBonded(BluetoothDevice btDevice) {
        Intent intent = new Intent(context.getApplicationContext(), DataTransmissionActivity.class);
        intent.putExtra("device",btDevice.getAddress());
        context.startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if(btAdapter !=null && btAdapter.isDiscovering())
            btAdapter.cancelDiscovery();
        BluetoothDevice device = deviceList.get(position).getBtDevice();
        if (device.getBondState()==BluetoothDevice.BOND_BONDED) {
            listItemViewUpdata.showDialog(deviceList.get(position));
        } else {
            processDeviceBondNone(device);
        }
        return true;
    }

    public void setListItemViewUpdata(ListItemViewUpdata listItemViewUpdata) {
        this.listItemViewUpdata = listItemViewUpdata;
    }

}
