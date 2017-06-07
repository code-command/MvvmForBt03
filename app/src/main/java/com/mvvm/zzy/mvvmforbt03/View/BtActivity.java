package com.mvvm.zzy.mvvmforbt03.View;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;
import com.mvvm.zzy.mvvmforbt03.R;
import com.mvvm.zzy.mvvmforbt03.ViewModel.BtReceiver;
import com.mvvm.zzy.mvvmforbt03.ViewModel.SearchButtonViewModel;
import com.mvvm.zzy.mvvmforbt03.ViewModel.SwitchButtonViewModel;
import com.mvvm.zzy.mvvmforbt03.databinding.ActivityBtBinding;

public class BtActivity extends AppCompatActivity {

    public SystemInfo systemInfo;
    private SwitchButtonViewModel switchButtonViewModel;
    private SearchButtonViewModel searchButtonViewModel;
    private BtReceiver btReceiver;
    private IntentFilter btFilter;
    private BluetoothAdapter btAdapter;
    private BluetoothDevice btDevice;
    private ActivityBtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParameters();
        initBinding();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (btAdapter.isEnabled()) {
            systemInfo.setOpen(true);
        }
    }

    private void initParameters() {
        systemInfo = SystemInfo.getSystemInfo();
        initBtAdapter();
        initBtReceiver();
    }

    private void initBtAdapter() {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            processInvalidBtAdapter();;
        }
    }

    private void processInvalidBtAdapter() {
        Toast.makeText(getApplicationContext(), R.string.invalid_bt, Toast.LENGTH_SHORT).show();
        System.exit(0);
    }

    private void initBtReceiver() {
        btReceiver = new BtReceiver(btAdapter);
        registerIntentFilter();
        registerReceiver(btReceiver, btFilter);

    }

    private void registerIntentFilter() {
        btFilter = new IntentFilter();
        btFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        btFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        btFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        btFilter.addAction(BluetoothDevice.ACTION_FOUND);
        btFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        btFilter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
    }

    private void initBinding() {
        switchButtonViewModel = new SwitchButtonViewModel(btAdapter);
        searchButtonViewModel = new SearchButtonViewModel();

        binding = DataBindingUtil.setContentView(BtActivity.this, R.layout.activity_bt);
        binding.setSystemInfo(SystemInfo.getSystemInfo());
        binding.setSwitchButton(switchButtonViewModel);
        binding.setSearchButton(searchButtonViewModel);
    }
}
