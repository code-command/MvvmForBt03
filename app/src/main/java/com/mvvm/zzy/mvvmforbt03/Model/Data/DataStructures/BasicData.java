package com.mvvm.zzy.mvvmforbt03.Model.Data.DataStructures;

/**
 * Created by zhangziyu on 2017/6/11.
 */

public abstract class BasicData {

    public abstract String getCheckCode();

    public abstract boolean checkCompleteData(StringBuilder resource);

    public abstract void setCoreData(String resource);

    public abstract void interceptCoreData(StringBuilder resource);

    public abstract int getDataLength();

}
