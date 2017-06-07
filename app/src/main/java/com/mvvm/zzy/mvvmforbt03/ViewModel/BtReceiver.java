package com.mvvm.zzy.mvvmforbt03.ViewModel;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class BtReceiver extends BroadcastReceiver {
    private BluetoothAdapter btAdapter;
    private BluetoothDevice btDevice;
    private SystemInfo systemInfo;
    private List<BtDeviceItem> deviceList;

    private BtAdapterViewModel btAdapterViewModel;

    BtReceiverUpdataListener updataListener;

    public BtReceiver(BluetoothAdapter btAdapter, SystemInfo systemInfo, List<BtDeviceItem> deviceList) {
        this.btAdapter = btAdapter;
        this.systemInfo = systemInfo;
        this.deviceList = deviceList;

        btAdapterViewModel = new BtAdapterViewModel(btAdapter, systemInfo, deviceList);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        btAdapterViewModel.processIntentChanged(intent);

        updataListener.updataSystemInfo(systemInfo);
    }

    public void setUpdataListener(BtReceiverUpdataListener updataListener) {
        this.updataListener = updataListener;
    }

}
