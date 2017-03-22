package bilibili.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import bilibili.bilibili.R;
import bilibili.bilibili.bean.LiveBean;

/**
 * Created by XUERU on 2017/3/21.
 */

public class LiveAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final LiveBean.DataBean data;

    private LayoutInflater inflater;

    public LiveAdapter(Context mContext, LiveBean.DataBean data) {
        this.mContext = mContext;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
    }

    /**
     * 横幅广告
     */
    public static final int BANNER = 0;
    /**
     * 频道
     */
    public static final int ENTRANCEICONS = 1;

    /**
     *
     */
    public static final int PARTITIONS = 2;

    /**
     * 当前类型
     */
    public int currentType = BANNER;

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == ENTRANCEICONS) {
            currentType = ENTRANCEICONS;
        } else if (position == PARTITIONS) {
            currentType = PARTITIONS;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == BANNER) {

            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;

            bannerViewHolder.setData(data.getBanner());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {


        Banner banner;
        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);

        }

        public void setData(List<LiveBean.DataBean.BannerBean> banners) {

            List<String> images = new ArrayList();
            for (int i = 0; i < 5; i++) {
                images.add(banners.get(0).getImg());
            }

            //简单使用
            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context)
                                    .load(path)
                                    .crossFade()
                                    .into(imageView);
                        }
                    })
                    .start();

            //设置banner的样式
            banner.setBannerAnimation(BackgroundToForegroundTransformer.class);
            //设置点击事件
            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    int realPosition = position - 1;
                    Toast.makeText(mContext, "position" +realPosition, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
