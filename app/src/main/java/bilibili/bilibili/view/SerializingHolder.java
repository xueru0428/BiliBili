package bilibili.bilibili.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import bilibili.bilibili.R;
import bilibili.bilibili.bean.CatchBean;
import bilibili.bilibili.utils.MyApplication;
import butterknife.Bind;

/**
 * Created by XUERU on 2017/3/24.
 */

public class SerializingHolder extends BaseViewHolder<CatchBean.ResultBean.PreviousBean.ListBean> {
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.catch_num)
    TextView catchNum;

    @Override
    public View intView() {
        return View.inflate(MyApplication.getmContext(), R.layout.adapter_previous, null);
    }

    @Override
    protected void setChildData() {
        CatchBean.ResultBean.PreviousBean.ListBean bean = getT();
        tvTitle.setText(bean.getTitle());
        tvName.setText("更新至第" + bean.getNewest_ep_index() + "话");
        catchNum.setText(bean.getFavourites()+"人追番");

        Glide.with(MyApplication.getmContext())
                .load(bean.getCover())
                .into(ivIcon);

    }
}
