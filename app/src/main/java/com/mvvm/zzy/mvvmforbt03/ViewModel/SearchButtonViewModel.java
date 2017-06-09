package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.bluetooth.BluetoothAdapter;
import android.view.View;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class SearchButtonViewModel{

    private BluetoothAdapter btAdapter;

    public SearchButtonViewModel(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
    }

    public void searchButtonChangedListener(View view) {
        if (!btAdapter.isEnabled())
            return;
        if (btAdapter.isDiscovering()) {
            btAdapter.cancelDiscovery();
        } else {
            btAdapter.startDiscovery();
        }
    }
}
