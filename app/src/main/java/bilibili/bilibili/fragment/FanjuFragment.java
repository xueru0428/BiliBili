package bilibili.bilibili.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import bilibili.bilibili.base.BaseFragment;

/**
 * Created by XUERU on 2017/3/27.
 */

public class FanjuFragment extends BaseFragment {
    TextView textView;

    @Override
    protected View initView() {
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void intData() {
        textView.setText("111");
    }

    @Override
    protected void intListener() {

    }
}
