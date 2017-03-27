package bilibili.bilibili.adapter;

import java.util.List;

import bilibili.bilibili.bean.LiveBean;
import bilibili.bilibili.view.BaseViewHolder;
import bilibili.bilibili.view.PartitionsHolder;

/**
 * Created by XUERU on 2017/3/23.
 */

public class DistrictGridAdapter extends ListViewBaseAdapter<LiveBean.DataBean.PartitionsBean.LivesBean> {
    public DistrictGridAdapter(List<LiveBean.DataBean.PartitionsBean.LivesBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder getHolder() {
        return new PartitionsHolder();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
