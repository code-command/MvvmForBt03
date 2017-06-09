package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;

import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class BtDeviceViewModel {
    private DeviceAdapter deviceAdapter;
    private SystemInfo systemInfo;

    public BtDeviceViewModel(DeviceAdapter deviceAdapter, SystemInfo systemInfo) {
        this.deviceAdapter = deviceAdapter;
        this.systemInfo = systemInfo;
    }

    public boolean processIntentChanged(Intent intent) {
        boolean result = false;
        if (processActionChanged(intent))
            result = true;
        return result;
    }

    private boolean processActionChanged(Intent intent) {
        switch (intent.getAction()) {
            case BluetoothDevice.ACTION_FOUND:
                btDeviceFound(intent);
                return true;

            case BluetoothDevice.ACTION_BOND_STATE_CHANGED:
                btDeviceBondChanged(intent);
                return true;

            default:
                break;
        }
        return false;
    }

    private void btDeviceFound(Intent intent) {
        systemInfo.setFound(true);
        btDeviceBondChanged(intent);
    }

    private void btDeviceBondChanged(Intent intent) {
        BluetoothDevice btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        BtDeviceItem btDeviceItem = new BtDeviceItem(btDevice.getName(), btDevice.getAddress(),
                btDevice.getBondState()==BluetoothDevice.BOND_BONDED, btDevice);
        deviceAdapter.updataListItem(btDeviceItem);
    }

}
