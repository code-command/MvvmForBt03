package com.mvvm.zzy.mvvmforbt03.ViewModel;

import com.mvvm.zzy.mvvmforbt03.Model.BtDeviceItem;
import com.mvvm.zzy.mvvmforbt03.Model.SystemInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public interface BtReceiverUpdataListener {

    void updataSystemInfo(SystemInfo systemInfo);

    void updataBtDeviceList(SystemInfo systemInfo, List<BtDeviceItem> list);
}
