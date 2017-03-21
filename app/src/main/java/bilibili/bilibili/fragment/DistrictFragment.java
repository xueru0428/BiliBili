package bilibili.bilibili.fragment;

import android.view.View;
import android.widget.TextView;

import bilibili.bilibili.base.BaseFragment;

/**
 * Created by XUERU on 2017/3/21.
 */

public class DistrictFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected void intListener() {

    }

    @Override
    protected void intData() {
        textView = new TextView(getActivity());
        textView.setText("分区");

    }

    @Override
    public View getLayoutId() {
        return textView;
    }
}
