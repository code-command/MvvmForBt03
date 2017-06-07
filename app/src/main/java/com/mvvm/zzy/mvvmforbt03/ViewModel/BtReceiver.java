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

    BtReceiverUpdataListener updataListener;

    public BtReceiver(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
        this.systemInfo = SystemInfo.getSystemInfo();

        btAdapterViewModel = new BtAdapterViewModel(btAdapter);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        btAdapterViewModel.processIntentChanged(intent);

        updataListener.updataSystemInfo(SystemInfo.getSystemInfo());
    }

    public void setUpdataListener(BtReceiverUpdataListener updataListener) {
        this.updataListener = updataListener;
    }

}
