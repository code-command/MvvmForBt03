package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.view.View;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class SwitchButtonViewModel {
    private BluetoothAdapter btAdapter;

    public SwitchButtonViewModel(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
    }

    public BluetoothAdapter getBtAdapter() {
        return btAdapter;
    }

    public void setBtAdapter(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
    }

    public void switchButtonChangedListener(View view) {
        if (btAdapter.isEnabled()) {
            btAdapter.disable();
        } else {
            btAdapter.enable();
        }
    }
}
