package bilibili.bilibili.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import bilibili.bilibili.view.BaseViewHolder;

/**
 * Created by XUERU on 2017/3/22.
 */

public abstract class ListViewBaseAdapter<T> extends BaseAdapter {

    private List<T> data = new ArrayList<>();

    public ListViewBaseAdapter(List<T> data) {

        if (data != null && data.size() > 0) {
            this.data.clear();
            this.data.addAll(data);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = getHolder();
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }

        T t = data.get(position);

        viewHolder.setData(t);

        return viewHolder.getView();
    }

    protected abstract BaseViewHolder getHolder();
}
