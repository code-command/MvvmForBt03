package com.mvvm.zzy.mvvmforbt03.Model.Data.DataStructures;

/**
 * Created by zhangziyu on 2017/6/11.
 */

public class ReceptionData extends BasicData {
    private String checkCode;
    private String endCode;
    private String codeData;

    @Override
    public String getCheckCode() {
        return null;
    }

    @Override
    public boolean checkCompleteData(StringBuilder resource) {
        return true;
    }

    @Override
    public void setCoreData(String resource) {

    }

    @Override
    public void interceptCoreData(StringBuilder resource) {

    }

    @Override
    public int getDataLength() {
        return 0;
    }

    public String toShow() {
        return codeData;
    }
}
