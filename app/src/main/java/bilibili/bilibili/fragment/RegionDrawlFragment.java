package bilibili.bilibili.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.util.List;

import bilibili.bilibili.R;
import bilibili.bilibili.adapter.OriginalAdapter;
import bilibili.bilibili.base.BaseFragment;
import bilibili.bilibili.bean.OriginalBean;
import bilibili.bilibili.utils.AppNetConfig;
import bilibili.bilibili.utils.LoadFromNet;
import bilibili.bilibili.utils.LoadNet;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XUERU on 2017/3/21.
 */

public class RegionDrawlFragment extends BaseFragment {

    @Bind(R.id.lv_original)
    ListView lvOriginal;

    @Override
    protected View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_original, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void intData() {
        getDataFromNet();

    }

    private void getDataFromNet() {
        LoadNet.getDataPost(AppNetConfig.COMMUNITY_COMIC_URL, new LoadFromNet() {
            @Override
            public void success(String content) {
                Log.i("TAG", "CommunityFragment success()");
                processData(content);
            }

            @Override
            public void failure(String error) {
                Log.i("TAG", "CommunityFragment failure()" + error);

            }
        });
    }

    private void processData(String json) {

        OriginalBean originalBean = JSON.parseObject(json, OriginalBean.class);
        List<OriginalBean.DataBean> dataBeen = originalBean.getData();

        if(dataBeen!= null  && dataBeen.size()>0 ) {
            //设置适配器

            OriginalAdapter adapter = new OriginalAdapter(getActivity(),dataBeen);

            lvOriginal.setAdapter(adapter);

            //刷新
            adapter.notifyDataSetChanged();

            //item的点击事件
            lvOriginal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getActivity(), "position = " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    protected void intListener() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
