package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class BtAdapterViewModel {
    private BluetoothAdapter btAdapter;
    SystemInfo systemInfo;

    public BtAdapterViewModel(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
        systemInfo = SystemInfo.getSystemInfo();
    }

    public void processIntentChanged(Intent intent) {
        processIntChanged(intent);
        processActionChanged(intent);
    }

    private void processIntChanged(Intent intent) {
        int temp = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
        switch (temp) {
            case BluetoothAdapter.STATE_ON:
            case BluetoothAdapter.STATE_TURNING_ON:
                btAdapterStateOn();
                break;

            case BluetoothAdapter.STATE_OFF:
            case BluetoothAdapter.STATE_TURNING_OFF:
                btAdapterOff();
                break;

            default:
                break;
        }
    }

    private void btAdapterStateOn() {
        systemInfo.setOpen(true);
    }

    private void btAdapterOff() {
        systemInfo.setOpen(false);
    }

    private void processActionChanged(Intent intent) {
        switch (intent.getAction()) {
            case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                btAdapter_DISCOVERY_STARTED();
                break;

            case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                btAdapter_DISCOVERY_FINISHED();
                break;

            case BluetoothAdapter.EXTRA_CONNECTION_STATE:
                break;

            default:
                break;
        }
    }

    private void btAdapter_DISCOVERY_STARTED() {
        systemInfo.setSearch(true);
    }

    private void btAdapter_DISCOVERY_FINISHED() {
        systemInfo.setSearch(false);
    }
}
