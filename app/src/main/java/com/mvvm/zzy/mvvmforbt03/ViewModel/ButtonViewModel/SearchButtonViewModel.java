package com.mvvm.zzy.mvvmforbt03.ViewModel.ButtonViewModel;

import android.bluetooth.BluetoothAdapter;
import android.view.View;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class SearchButtonViewModel extends ButtonViewModel {
    private BluetoothAdapter btAdapter;

    public SearchButtonViewModel(BluetoothAdapter btAdapter) {
        this.btAdapter = btAdapter;
    }

    @Override
    public void buttonChangedListener(View view) {
        if (!btAdapter.isEnabled())
            return;
        if (btAdapter.isDiscovering()) {
            btAdapter.cancelDiscovery();
        } else {
            btAdapter.startDiscovery();
        }
    }
}
