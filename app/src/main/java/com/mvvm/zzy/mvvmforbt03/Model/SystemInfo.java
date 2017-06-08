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

    @Bindable
    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
        notifyPropertyChanged(BR.found);
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
        notifyPropertyChanged(BR.open);
    }

    @Bindable
    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
        notifyPropertyChanged(BR.search);
    }

    public void setSystemInfo(SystemInfo info) {
        this.open = info.isOpen();
        this.search = info.isSearch();
        this.found = info.isFound();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemInfo that = (SystemInfo) o;

        if (open != that.open) return false;
//        if (search != that.search) return false;
        return search == that.search;

    }

    @Override
    public int hashCode() {
        int result = (open ? 1 : 0);
        result = 31 * result + (search ? 1 : 0);
        result = 31 * result + (found ? 1 : 0);
        return result;
    }
}
