package com.mvvm.zzy.mvvmforbt03.ViewModel.ButtonViewModel;

import android.view.View;

import com.mvvm.zzy.mvvmforbt03.Model.Data.SystemInfo.SystemInfo;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class ClearButtonViewModel extends ButtonViewModel {
    SystemInfo systemInfo;

    public ClearButtonViewModel(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    @Override
    public void buttonChangedListener(View view) {
        switchoverSystemInfoClear();
    }

    private void switchoverSystemInfoClear() {
            systemInfo.triggerClear();
    }
}
