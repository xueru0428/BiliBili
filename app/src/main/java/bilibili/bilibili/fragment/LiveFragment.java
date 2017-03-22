package bilibili.bilibili.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import bilibili.bilibili.R;
import bilibili.bilibili.adapter.LiveAdapter;
import bilibili.bilibili.base.BaseFragment;
import bilibili.bilibili.bean.LiveBean;
import bilibili.bilibili.utils.AppNetConfig;
import bilibili.bilibili.utils.LoadFromNet;
import bilibili.bilibili.utils.LoadNet;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XUERU on 2017/3/21.
 */

public class LiveFragment extends BaseFragment {


    @Bind(R.id.rv_live)
    RecyclerView rvLive;
    LiveAdapter adapter;
    @Bind(R.id.live_more)
    Button liveMore;
    @Bind(R.id.fab)
    ImageButton fab;

    @Override
    protected void intListener() {

        liveMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                Toast.makeText(getActivity(), "我要搜索", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_live, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void intData() {
        getDataFromNet();

    }

    private void getDataFromNet() {
        LoadNet.getDataPost(AppNetConfig.LIVE_URL, new LoadFromNet() {
            @Override
            public void success(String content) {

                Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();

                processData(content);
            }

            @Override
            public void failure(String error) {
                Toast.makeText(getActivity(), "failure" + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void processData(String json) {
        LiveBean liveBean = JSON.parseObject(json, LiveBean.class);
        LiveBean.DataBean data = liveBean.getData();

        //给recycleview设置适配器
        adapter = new LiveAdapter(getActivity(), data);
        rvLive.setAdapter(adapter);

        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvLive.setLayoutManager(manager);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
