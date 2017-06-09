package com.mvvm.zzy.mvvmforbt03.ViewModel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by zhangziyu on 2017/6/7.
 */

public class DeviceAdapter<T> extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public DeviceAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
    }

    public void clearList() {
        list.clear();
        this.notifyDataSetChanged();
    }

    public void updataListItem(T item) {
        if (list.contains(item)) {
            int postion = list.indexOf(item);
            list.remove(postion);
            list.add(postion, item);
        } else {
            list.add(item);
        }
        this.notifyDataSetChanged();
    }

    public List<T> getList () {
        return  list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setVariable(variableId, list.get(position));
        return binding.getRoot();
    }
}
