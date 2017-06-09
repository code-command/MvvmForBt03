package com.mvvm.zzy.mvvmforbt03.ViewModel;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class BtReceiver extends BroadcastReceiver {
    private BluetoothAdapter btAdapter;
    private BluetoothDevice btDevice;
    private SystemInfo systemInfo;

    private BtAdapterViewModel btAdapterViewModel;
    private BtDeviceViewModel btDeviceViewModel;

    public BtReceiver(BluetoothAdapter btAdapter, SystemInfo systemInfo, DeviceAdapter deviceAdapter) {
        this.btAdapter = btAdapter;
        this.systemInfo = systemInfo;

        btAdapterViewModel = new BtAdapterViewModel(btAdapter, systemInfo, deviceAdapter);
        btDeviceViewModel = new BtDeviceViewModel(deviceAdapter, systemInfo);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        btAdapterViewModel.processIntentChanged(intent);

        btDeviceViewModel.processIntentChanged(intent);
    }
}
