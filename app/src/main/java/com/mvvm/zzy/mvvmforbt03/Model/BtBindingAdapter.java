package com.mvvm.zzy.mvvmforbt03.Model;

import android.databinding.BindingAdapter;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/6/10 0010.
 */

public class BtBindingAdapter {

    @BindingAdapter("btLinearLayoutHandover")
    public static void setLinearLayoutHandover(LinearLayout view, boolean found) {
        RelativeLayout.LayoutParams paramsr = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if (found) {
            adjustLinearLayout(view, paramsr);
        } else {
            recoverLinearLayout(view, paramsr);
        }
        view.setLayoutParams(paramsr);
        paramsr = null;
    }

    private static void adjustLinearLayout(LinearLayout view, RelativeLayout.LayoutParams paramsr) {
        paramsr.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        final int paddingTop = view.getWidth()/3;
        paramsr.setMargins(0, paddingTop, 0, 0);
        view.setLayoutParams(paramsr);
        view.setOrientation(LinearLayout.HORIZONTAL);		//设置为水平排列
        view.setGravity(Gravity.CENTER_VERTICAL);
    }

    private static void recoverLinearLayout(LinearLayout view, RelativeLayout.LayoutParams paramsr) {
        paramsr.addRule(RelativeLayout.CENTER_IN_PARENT);
        view.setLayoutParams(paramsr);
        view.setOrientation(LinearLayout.VERTICAL);
        view.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}
