package bilibili.bilibili.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;

import java.util.List;

import bilibili.bilibili.R;
import bilibili.bilibili.adapter.TopicCenterAdapter;
import bilibili.bilibili.base.BaseActivity;
import bilibili.bilibili.bean.TopicCenterBean;
import bilibili.bilibili.utils.AppNetConfig;
import bilibili.bilibili.utils.LoadFromNet;
import bilibili.bilibili.utils.LoadNet;
import butterknife.Bind;

public class TopicCenterActivity extends BaseActivity {


    @Bind(R.id.topic_center_back)
    ImageView topicCenterBack;
    @Bind(R.id.tv_topic_center)
    ListView tvTopicCenter;
    @Bind(R.id.activity_topic_center)
    LinearLayout activityTopicCenter;
    private List<TopicCenterBean.ListBean> listBeen;

    @Override
    public int getLayoutId() {
        return R.layout.activity_topic_center;
    }

    @Override
    protected void initData() {
        getDataFromNet();
    }

    private void getDataFromNet() {
        LoadNet.getDataPost(AppNetConfig.COMMUNITY_TOPIC_URL, new LoadFromNet() {
            @Override
            public void success(String content) {
                processData(content);
            }

            @Override
            public void failure(String error) {

            }
        });
    }

    private void processData(String json) {
        TopicCenterBean topicCenterBean = JSON.parseObject(json, TopicCenterBean.class);
        listBeen = topicCenterBean.getList();

        if(listBeen != null && listBeen.size()>0) {
            //设置适配器
            TopicCenterAdapter adapter = new TopicCenterAdapter(listBeen);
            tvTopicCenter.setAdapter(adapter);

            //设置item的点击事件
            tvTopicCenter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        }
    }

    @Override
    protected void initListener() {

        topicCenterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
