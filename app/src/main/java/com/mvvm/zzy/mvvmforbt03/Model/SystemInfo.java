package com.mvvm.zzy.mvvmforbt03.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mvvm.zzy.mvvmforbt03.BR;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

public class SystemInfo extends BaseObservable{
    private boolean open;
    private boolean search;

    public SystemInfo(boolean open, boolean search) {
        this.open = open;
        this.search = search;
    }

    @Bindable
    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
        notifyPropertyChanged(BR.systemInfo);
    }

    @Bindable
    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
        notifyPropertyChanged(BR.systemInfo);
    }
}
