package bilibili.bilibili.view;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by XUERU on 2017/3/14.
 */

public abstract class BaseViewHolder<T> {

    private View view;
    private T t;


    public BaseViewHolder() {
        view = intView();
        ButterKnife.bind(this,view);
        view.setTag(this);

    }

    public View getView() {
        return view;
    }



    public void setData(T t) {
        this.t = t;
        setChildData();
    }



    public T getT() {
        return t;
    }

    public abstract View intView() ;

    protected abstract void setChildData();
}
