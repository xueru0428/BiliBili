package bilibili.bilibili.adapter;

import android.content.Context;

import java.util.List;

import bilibili.bilibili.bean.CatchBean;
import bilibili.bilibili.view.BaseViewHolder;
import bilibili.bilibili.view.PreviousHolder;

/**
 * Created by XUERU on 2017/3/24.
 */

public class SerializingAdapter extends ListViewBaseAdapter<CatchBean.ResultBean.PreviousBean.ListBean> {


    public SerializingAdapter(Context mContext, List<CatchBean.ResultBean.PreviousBean.ListBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder getHolder() {
        return new PreviousHolder();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
