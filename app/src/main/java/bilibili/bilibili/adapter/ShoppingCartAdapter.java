package bilibili.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shoppingmall.R;
import com.shoppingmall.home.bean.GoodsBean;
import com.shoppingmall.shoppingcart.utils.CartStorage;
import com.shoppingmall.shoppingcart.view.AddSubView;
import com.shoppingmall.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XUERU on 2017/2/28.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<GoodsBean> datas;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxAll;
    private final CheckBox checkboxDeleteAll;


    public ShoppingCartAdapter(Context mContext, List<GoodsBean> list, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox checkboxDeleteAll) {
        Log.e("TAG", "1111111111111111" +list);
        this.mContext = mContext;
        this.datas = list;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.checkboxDeleteAll = checkboxDeleteAll;

        //得到总价
        showTotalPrice();
    }

    public void showTotalPrice() {
        //显示总价
        tvShopcartTotal.setText("合计："+getTotalPrice());

    }

    //得到总价
    public double getTotalPrice() {
        double totalPrice = 0;
        if(datas != null && datas.size() >0) {
            for (int i = 0; i < datas.size(); i++) {
                GoodsBean goodsBean = datas.get(i);
                if(goodsBean.isCheck()) {
                    totalPrice += Double.parseDouble(goodsBean.getCover_price() )*goodsBean.getNumber();
                }
            }
        }
        return totalPrice;
    }


    /**
     * 创建viewHoler---创建视图
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(mContext, R.layout.item_shopping_cart, null));
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //1.先得到数据
        final GoodsBean goodsBean = datas.get(position);

        //2.绑定数据
        //设置名称
        holder.tvDescGov.setText(goodsBean.getName());
        //设置价格
        holder.tvPriceGov.setText(goodsBean.getCover_price());

        //设置数量
        holder.addSubView.setValue(goodsBean.getNumber());
        //设置最小数量为1
        holder.addSubView.setMinValue(1);
        //设置最大数量为100------设置库存-来自服务器
        holder.addSubView.setMaxValue(100);

        //设置图片
        Glide.with(mContext)
                .load(Constants.BASE_URL_IMAGE+goodsBean.getFigure())
                .into(holder.ivGov);

        //checkBox是否为选中状态
        holder.cbGov.setChecked(goodsBean.isCheck());

        holder.addSubView.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
            @Override
            public void numberChange(int value) {
                //回调数量
                goodsBean.setNumber(value);
                CartStorage.getInstance(mContext).updateData(goodsBean);

                showTotalPrice();
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * 校验是否为全选
     */
    public void checkAll() {
        if(datas != null && datas.size() >0) {
            int number = 0;

            for (int i = 0; i < datas.size(); i++) {
                GoodsBean goodsBean = datas.get(i);
                if(!goodsBean.isCheck()) {
                    //只要有一个不勾选
                    checkboxAll.setChecked(false);
                    checkboxDeleteAll.setChecked(false);
                }else {
                    //勾选
                    number ++;
                }

            }

            if(datas.size() == number) {
                checkboxAll.setChecked(true);

                checkboxDeleteAll.setChecked(true);
            }



        }else {
            //没有数据
            checkboxAll.setChecked(false);
            checkboxDeleteAll.setChecked(false);
        }
    }

    public void check_None(boolean isChecked) {
        if(datas != null && datas.size()>0) {
            for (int i = 0; i < datas.size(); i++) {
                GoodsBean goodsBean = datas.get(i);
                //设置是否勾选状态
                goodsBean.setCheck(isChecked);
                checkboxAll.setChecked(isChecked);
                checkboxDeleteAll.setChecked(isChecked);

              //更新视图
                notifyItemChanged(i);
            }
        }
    }

    /**
     * 删除数据
     */
    public void deleteData() {

        if(datas != null && datas.size()>0) {
            for (int i = 0; i < datas.size(); i++) {
                GoodsBean goodsBean = datas.get(i);

                if(goodsBean.isCheck()) {
                    //1.内存中删除
                    datas.remove(goodsBean);
                    //本地保存
                    CartStorage.getInstance(mContext).deleteData(goodsBean);
                    //刷新数据
                    notifyItemRemoved(i);

                    i--;
                }
            }
        }

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_seller)
        TextView tvSeller;
        @BindView(R.id.cb_gov)
        CheckBox cbGov;
        @BindView(R.id.iv_gov)
        ImageView ivGov;
        @BindView(R.id.tv_desc_gov)
        TextView tvDescGov;
        @BindView(R.id.tv_price_gov)
        TextView tvPriceGov;
        @BindView(R.id.addSubView)
        AddSubView addSubView;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        listener.onItemClickListener(v,getLayoutPosition());
                    }
                }
            });

        }
    }

    /**
     * 点击item的监听
     */
    public interface OnItemClickListener{
        public void onItemClickListener(View v, int position);
    }

    //回调点击事件的监听
    private OnItemClickListener listener;

    //设置item的监听
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
