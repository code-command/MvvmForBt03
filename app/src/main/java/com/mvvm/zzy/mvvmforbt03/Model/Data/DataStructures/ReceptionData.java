package com.mvvm.zzy.mvvmforbt03.Model.Data.DataStructures;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mvvm.zzy.mvvmforbt03.BR;

import java.io.Serializable;
import java.util.Queue;

/**
 * Created by zhangziyu on 2017/6/11.
 */

public class ReceptionData extends BaseObservable implements Serializable {
    private String checkCode;
    private String endCode;
    @Bindable
    private StringBuilder codeData = new StringBuilder();

    public String getCheckCode() {
        return null;
    }

    public boolean checkCompleteData(Queue<Byte> resource) {
        return true;
    }

    @Bindable
    public String getCodeData() {
        return codeData.toString();
    }

    public void updateCoreData(String resource) {
        codeData.setLength(0);
        codeData.append(resource);
        notifyPropertyChanged(BR.codeData);
    }

    public void interceptCoreData(Queue<Byte> resource) {
        String newCodeData = "Test";
        updateCoreData(newCodeData);
    }

    public int getDataLength() {
        return 0;
    }

    public String toShow() {
        return codeData.toString();
    }
}
