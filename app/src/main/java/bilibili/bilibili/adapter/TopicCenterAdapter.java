package bilibili.bilibili.adapter;

import java.util.List;

import bilibili.bilibili.base.ListViewBaseAdapter;
import bilibili.bilibili.bean.TopicCenterBean;
import bilibili.bilibili.view.BaseViewHolder;
import bilibili.bilibili.view.TopicCenterHolder;

/**
 * Created by XUERU on 2017/3/22.
 */

public class TopicCenterAdapter extends ListViewBaseAdapter<TopicCenterBean.ListBean> {
    public TopicCenterAdapter(List<TopicCenterBean.ListBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder getHolder() {
        return new TopicCenterHolder();
    }
}
