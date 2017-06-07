package com.mvvm.zzy.mvvmforbt03.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mvvm.zzy.mvvmforbt03.BR;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class SystemInfo extends BaseObservable{

    private boolean isOpen;
    private boolean isSearch;

    private SystemInfo(boolean isOpen, boolean isSearch) {
        this.isOpen = isOpen;
        this.isSearch = isSearch;
    }

    private static volatile SystemInfo systemInfo;

    public static SystemInfo getSystemInfo() {
        if (systemInfo == null) {
            synchronized (SystemInfo.class) {
                if (systemInfo == null) {
                    systemInfo = new SystemInfo(false, false);
                }
            }
        }
        return systemInfo;
    }

    @Bindable
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        notifyPropertyChanged(BR.systemInfo);
    }

    @Bindable
    public boolean isSearch() {
        return isSearch;
    }

    public void setSearch(boolean search) {
        isSearch = search;
        notifyPropertyChanged(BR.systemInfo);
    }

    public void switchOpen() {
        if (isOpen) {
            setOpen(false);
        } else {
            setOpen(true);
        }
    }
}
