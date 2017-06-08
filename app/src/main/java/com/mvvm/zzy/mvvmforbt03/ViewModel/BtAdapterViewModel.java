package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class BtAdapterViewModel {
    private BluetoothAdapter btAdapter;
    private SystemInfo systemInfo;
    private List<BtDeviceItem> list;

    public BtAdapterViewModel(BluetoothAdapter btAdapter, SystemInfo systemInfo, List<BtDeviceItem> list) {
        this.btAdapter = btAdapter;
        this.systemInfo = systemInfo;
        this.list = list;
    }

    public boolean processIntentChanged(Intent intent) {
        boolean result = false;
        if (processIntChanged(intent))
            result = true;
        if (processActionChanged(intent))
            result = true;
        return true;
    }

    private boolean processIntChanged(Intent intent) {
        int temp = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
        switch (temp) {
            case BluetoothAdapter.STATE_ON:
            case BluetoothAdapter.STATE_TURNING_ON:
                btAdapterStateOn();
                return true;

            case BluetoothAdapter.STATE_OFF:
            case BluetoothAdapter.STATE_TURNING_OFF:
                btAdapterOff();
                return true;

            default:
                break;
        }
        return false;
    }

    private void btAdapterStateOn() {
        systemInfo.setOpen(true);
    }

    private void btAdapterOff() {
        systemInfo.setOpen(false);
        systemInfo.setFound(false);
        if (btAdapter.isDiscovering()) {
            btAdapter.cancelDiscovery();
        }
    }

    private boolean processActionChanged(Intent intent) {
        switch (intent.getAction()) {
            case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                btAdapter_DISCOVERY_STARTED();
                return true;

            case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                btAdapter_DISCOVERY_FINISHED();
                return true;

            default:
                break;
        }
        return false;
    }

    private void btAdapter_DISCOVERY_STARTED() {
        systemInfo.setSearch(true);
    }

    private void btAdapter_DISCOVERY_FINISHED() {
        systemInfo.setSearch(false);
    }
}
