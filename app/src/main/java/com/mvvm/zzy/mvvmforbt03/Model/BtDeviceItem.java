package com.mvvm.zzy.mvvmforbt03.Model;

import android.bluetooth.BluetoothDevice;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mvvm.zzy.mvvmforbt03.BR;

/**
 * Created by zhangziyu on 2017/6/7.
 */

public class BtDeviceItem extends BaseObservable {
    private String deviceName;
    private String deviceAddr;
    private boolean bond;
    private BluetoothDevice btDevice;

    public BtDeviceItem(String deviceName, String deviceAddr, boolean bond, BluetoothDevice btDevice) {
        this.deviceName = deviceName;
        this.deviceAddr = deviceAddr;
        this.bond = bond;
        this.btDevice = btDevice;
    }

    @Bindable
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        notifyPropertyChanged(BR.deviceItem);
    }

    @Bindable
    public String getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(String deviceAddr) {
        this.deviceAddr = deviceAddr;
        notifyPropertyChanged(BR.deviceItem);
    }

    @Bindable
    public boolean isBond() {
        return bond;
    }

    public void setBond(boolean bond) {
        this.bond = bond;
        notifyPropertyChanged(BR.deviceItem);
    }

    @Bindable
    public BluetoothDevice getBtDevice() {
        return btDevice;
    }

    public void setBtDevice(BluetoothDevice btDevice) {
        this.btDevice = btDevice;
        notifyPropertyChanged(BR.deviceItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BtDeviceItem that = (BtDeviceItem) o;

        return deviceAddr.equals(that.deviceAddr);

    }
}
