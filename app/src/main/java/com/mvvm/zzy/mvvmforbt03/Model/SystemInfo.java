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
    private boolean found;

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
        notifyPropertyChanged(BR.systemInfo);
    }

    public SystemInfo() {
        this.open = false;
        this.search = false;
        this.found = false;

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
