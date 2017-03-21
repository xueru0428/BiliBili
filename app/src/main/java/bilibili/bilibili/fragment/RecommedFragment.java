package bilibili.bilibili.fragment;

import android.view.View;
import android.widget.TextView;

import bilibili.bilibili.base.BaseFragment;

/**
 * Created by XUERU on 2017/3/21.
 */

public class RecommedFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected void intListener() {

    }

    @Override
    protected void intData() {
        textView = new TextView(getActivity());
        textView.setText("推荐");

    }

    @Override
    public View getLayoutId() {
        return textView;
    }
}
