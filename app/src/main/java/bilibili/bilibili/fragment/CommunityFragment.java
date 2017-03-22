package bilibili.bilibili.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import bilibili.bilibili.R;
import bilibili.bilibili.activity.TopicCenterActivity;
import bilibili.bilibili.base.BaseFragment;
import bilibili.bilibili.bean.CommunityTagBean;
import bilibili.bilibili.utils.AppNetConfig;
import bilibili.bilibili.utils.LoadFromNet;
import bilibili.bilibili.utils.LoadNet;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XUERU on 2017/3/21.
 */

public class CommunityFragment extends BaseFragment {

    private static final int REQUEST_CODE = 0;

    @Bind(R.id.tv_search)
    TextView tvSearch;
    @Bind(R.id.iv_scan)
    ImageView ivScan;
    @Bind(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    @Bind(R.id.tv_load_more)
    TextView tvLoadMore;
    @Bind(R.id.textView1)
    TextView textView1;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.tv_group)
    TextView tvGroup;
    @Bind(R.id.tv_topic)
    TextView tvTopic;
    @Bind(R.id.tv_activity)
    TextView tvActivity;
    @Bind(R.id.tv_black)
    TextView tvBlack;
    @Bind(R.id.tv_original)
    TextView tvOriginal;
    @Bind(R.id.tv_rank_all)
    TextView tvRankAll;
    @Bind(R.id.tv_game)
    TextView tvGame;
    @Bind(R.id.tv_shop)
    TextView tvShop;
    private Intent intent;
    private ArrayList<String> datas;
    private List<CommunityTagBean.DataBean.ListBean> listBeen;

    @Override
    protected void intListener() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_communnity, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void intData() {
        getDataFromNet();

    }

    private void getDataFromNet() {
        LoadNet.getDataPost(AppNetConfig.COMMUNITY_TAG_URL, new LoadFromNet() {
            @Override
            public void success(String content) {
                Log.i("TAG", "CommunityFragment success()");
                processData(content);
            }

            @Override
            public void failure(String error) {
                Log.i("TAG", "CommunityFragment failure()"+error);

            }
        });
    }

    private void processData(String json) {
        CommunityTagBean communityTagBean = JSON.parseObject(json, CommunityTagBean.class);

        listBeen = communityTagBean.getData().getList();
        datas = new ArrayList<>();

        for (int i = 0; i < listBeen.size(); i++) {
            datas.add(listBeen.get(i).getKeyword());
        }

        //设置适配器
        idFlowlayout.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) View.inflate(getActivity(),R.layout.item_text,null);
                tv.setText(s);
                return tv;
            }

        });
        //点击事件
        idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {

                return false;
            }
        });
    }


    @OnClick({R.id.tv_search, R.id.iv_scan, R.id.tv_load_more, R.id.tv_group, R.id.tv_topic, R.id.tv_activity, R.id.tv_black, R.id.tv_original, R.id.tv_rank_all, R.id.tv_game, R.id.tv_shop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:

                break;
            case R.id.iv_scan:
                //跳转
                intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.tv_load_more:

                break;
            case R.id.tv_group:
                break;
            case R.id.tv_topic:
                startActivity(new Intent(getActivity(),TopicCenterActivity.class));
                break;
            case R.id.tv_activity:
                break;
            case R.id.tv_black:
                break;
            case R.id.tv_original:
                break;
            case R.id.tv_rank_all:
                break;
            case R.id.tv_game:
                break;
            case R.id.tv_shop:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
