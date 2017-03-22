package bilibili.bilibili.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import bilibili.bilibili.R;
import bilibili.bilibili.bean.TopicCenterBean;
import bilibili.bilibili.utils.MyApplication;
import butterknife.Bind;

/**
 * Created by XUERU on 2017/3/22.
 */

public class TopicCenterHolder extends BaseViewHolder<TopicCenterBean.ListBean> {
    @Bind(R.id.iv_topic_item)
    ImageView ivTopicItem;
    @Bind(R.id.tv_topic_item)
    TextView tvTopicItem;

    @Override
    public View intView() {
        return View.inflate(MyApplication.getmContext(), R.layout.adapter_topic_center, null);
    }

    @Override
    protected void setChildData() {

        TopicCenterBean.ListBean bean = getT();

        tvTopicItem.setText(bean.getTitle());

        Glide.with(MyApplication.getmContext())
                .load(bean.getCover())
                .placeholder(R.drawable.bili_default_image_tv)
                .into(ivTopicItem);
    }
}
