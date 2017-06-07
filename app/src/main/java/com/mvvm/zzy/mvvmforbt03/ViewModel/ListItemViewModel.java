package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.View.DataTransmissionActivity;

import java.util.List;

/**
 * Created by zhangziyu on 2017/6/7.
 */

public class ListItemViewModel implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private BluetoothAdapter btAdapter;
    private List<BtDeviceItem> deviceList;
    private Context context;


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

    }

    private void processDeviceBondBonded(BluetoothDevice btDevice) {
        Intent intent = new Intent(context.getApplicationContext(), DataTransmissionActivity.class);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
