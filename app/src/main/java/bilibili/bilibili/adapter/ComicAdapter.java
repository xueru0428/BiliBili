package bilibili.bilibili.adapter;

import java.util.List;

import bilibili.bilibili.bean.DistrictRecycleBean;
import bilibili.bilibili.view.BaseViewHolder;
import bilibili.bilibili.view.RegionGVHolder;

/**
 * Created by XUERU on 2017/3/24.
 */

public class ComicAdapter extends ListViewBaseAdapter<DistrictRecycleBean.DataBean.BodyBean> {
    public ComicAdapter(List<DistrictRecycleBean.DataBean.BodyBean> body) {
        super(body);
    }

    @Override
    protected BaseViewHolder getHolder() {
        return new RegionGVHolder();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
