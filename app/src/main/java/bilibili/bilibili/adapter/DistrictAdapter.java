package bilibili.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import bilibili.bilibili.R;
import bilibili.bilibili.activity.WebViewActivity;
import bilibili.bilibili.bean.DistrictGridBean;
import bilibili.bilibili.bean.DistrictRecycleBean;
import bilibili.bilibili.bean.WebViewBean;
import bilibili.bilibili.view.MyGridView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XUERU on 2017/3/23.
 */

public class DistrictAdapter extends RecyclerView.Adapter {


    private final Context mContext;
    private final List<DistrictGridBean.DataBean> gridBeanData;
    private final List<DistrictRecycleBean.DataBean> datas;


    private LayoutInflater inflater;

    public DistrictAdapter(Context mContext, List<DistrictGridBean.DataBean> gridBeanData, List<DistrictRecycleBean.DataBean> dataBeen) {

        this.mContext = mContext;

        this.gridBeanData = gridBeanData;

        this.datas = dataBeen;

        inflater = LayoutInflater.from(mContext);


    }

    //类型
    public static final int GRIDVIEW = 0;
    public static final int COMIC = 1;
    public static final int CREATE = 2;
    public static final int MUSIC = 3;
    public static final int TOPIC = 4;
    public static final int DANCE = 5;
    public static final int GANE = 6;
    public static final int GUICHU = 7;
    public static final int TOPIC1 = 8;
    public static final int LIFE = 9;
    public static final int TOPIC2 = 10;
    public static final int TECHNOLOGY = 11;
    public static final int ACTIVITY = 12;
    public static final int TOPIC3 = 13;
    public static final int FASHION = 14;
    public static final int AD = 15;
    public static final int RECREATION = 16;
    public static final int OPER = 17;
    public static final int TOPIC4 = 18;
    public static final int MOVIE = 19;


    private int currentType = GRIDVIEW;


    @Override
    public int getItemViewType(int position) {

        if (position == GRIDVIEW) {
            currentType = GRIDVIEW;
        } else if (position == COMIC) {
            currentType = COMIC;
        } else if (position == CREATE) {
            currentType = CREATE;
        } else if (position == COMIC) {
            currentType = COMIC;
        } else if (position == MUSIC) {
            currentType = MUSIC;
        } else if (position == TOPIC) {
            currentType = TOPIC;
        } else if (position == DANCE) {
            currentType = DANCE;
        } else if (position == GANE) {
            currentType = GANE;
        } else if (position == GUICHU) {
            currentType = GUICHU;
        } else if (position == TOPIC1) {
            currentType = TOPIC1;
        } else if (position == LIFE) {
            currentType = LIFE;
        } else if (position == TOPIC2) {
            currentType = TOPIC2;
        } else if (position == TECHNOLOGY) {
            currentType = TECHNOLOGY;
        } else if (position == ACTIVITY) {
            currentType = ACTIVITY;
        } else if (position == TOPIC3) {
            currentType = TOPIC3;
        } else if (position == FASHION) {
            currentType = FASHION;
        } else if (position == AD) {
            currentType = AD;
        } else if (position == RECREATION) {
            currentType = RECREATION;
        } else if (position == OPER) {
            currentType = OPER;
        } else if (position == TOPIC4) {
            currentType = TOPIC4;
        } else if (position == MOVIE) {
            currentType = MOVIE;
        }

        return currentType;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == GRIDVIEW) {
            return new GVViewHolder(mContext, inflater.inflate(R.layout.grid_item, null));
        } else if (viewType == COMIC) {
            return new ComicViewHolder(mContext, inflater.inflate(R.layout.region_item, null));
        } else if (viewType == CREATE) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == MUSIC) {
            return new ComicViewHolder(mContext, inflater.inflate(R.layout.region_item, null));
        } else if (viewType == TOPIC) {
            return new TopicViewHolder(mContext, inflater.inflate(R.layout.topic_item, null));
        } else if (viewType == DANCE) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == GANE) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == GUICHU) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == TOPIC1) {
            return new TopicViewHolder(mContext, inflater.inflate(R.layout.topic_item, null));
        } else if (viewType == LIFE) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == TOPIC2) {
            return new TopicViewHolder(mContext, inflater.inflate(R.layout.topic_item, null));
        } else if (viewType == TECHNOLOGY) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        } else if (viewType == ACTIVITY) {
            return new ActivityViewHolder(mContext, inflater.inflate(R.layout.activity_item, null));
        } else if (viewType == TOPIC3) {
            return new TopicViewHolder(mContext, inflater.inflate(R.layout.topic_item, null));
        } else if (viewType == FASHION) {
            return new ComicViewHolder(mContext, inflater.inflate(R.layout.region_item, null));
        }else if (viewType == AD) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        }else if (viewType == RECREATION) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        }else if (viewType == OPER) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        }else if (viewType == TOPIC4) {
            return new TopicViewHolder(mContext, inflater.inflate(R.layout.topic_item, null));
        }else if (viewType == MOVIE) {
            return new CreateViewHolder(mContext, inflater.inflate(R.layout.create_item, null));
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == GRIDVIEW) {
            GVViewHolder viewHolder = (GVViewHolder) holder;
            viewHolder.setData(gridBeanData);
        } else if (getItemViewType(position) == COMIC) {
            ComicViewHolder viewHolder = (ComicViewHolder) holder;
            viewHolder.setData(datas.get(0));//| 13
        } else if (getItemViewType(position) == CREATE) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(1));
        } else if (getItemViewType(position) == MUSIC) {
            ComicViewHolder viewHolder = (ComicViewHolder) holder;
            viewHolder.setData(datas.get(2));
        } else if (getItemViewType(position) == TOPIC) {
            TopicViewHolder viewHolder = (TopicViewHolder) holder;
            viewHolder.setData(datas.get(3));//|7|9|12|17
        } else if (getItemViewType(position) == DANCE) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(4));
        } else if (getItemViewType(position) == GANE) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(5));
        } else if (getItemViewType(position) == GUICHU) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(6));
        } else if (getItemViewType(position) == TOPIC1) {
            TopicViewHolder viewHolder = (TopicViewHolder) holder;
            viewHolder.setData(datas.get(7));//|7|9|12|17
        } else if (getItemViewType(position) == LIFE) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(8));
        } else if (getItemViewType(position) == TOPIC2) {
            TopicViewHolder viewHolder = (TopicViewHolder) holder;
            viewHolder.setData(datas.get(9));//|7|9|12|17
        } else if (getItemViewType(position) == TECHNOLOGY) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(10));
        } else if (getItemViewType(position) == ACTIVITY) {
            ActivityViewHolder viewHolder = (ActivityViewHolder) holder;
            viewHolder.setData(datas.get(11));
        }else if (getItemViewType(position) == TOPIC3) {
            TopicViewHolder viewHolder = (TopicViewHolder) holder;
            viewHolder.setData(datas.get(12));//|7|9|12|17
        }else if (getItemViewType(position) == FASHION) {
            ComicViewHolder viewHolder = (ComicViewHolder) holder;
            viewHolder.setData(datas.get(13));
        }else if (getItemViewType(position) == AD) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(14));
        }else if (getItemViewType(position) == RECREATION) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(15));
        }else if (getItemViewType(position) == OPER) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(16));
        }else if (getItemViewType(position) == TOPIC4) {
            TopicViewHolder viewHolder = (TopicViewHolder) holder;
            viewHolder.setData(datas.get(17));//|7|9|12|17
        }else if (getItemViewType(position) == MOVIE) {
            CreateViewHolder viewHolder = (CreateViewHolder) holder;
            viewHolder.setData(datas.get(18));
        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class GVViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.gv_draw)
        MyGridView gvDraw;

        public GVViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(List<DistrictGridBean.DataBean> gridBeanData) {
            DistrictGridAdapter adapter = new DistrictGridAdapter(gridBeanData);
            gvDraw.setAdapter(adapter);

            gvDraw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    class ComicViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        @Bind(R.id.iv_region)
        ImageView ivRegion;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_region)
        TextView tvRegion;
        @Bind(R.id.gv_region)
        MyGridView gvRegion;
        @Bind(R.id.btn_more)
        Button btnMore;
        @Bind(R.id.tv_refresh)
        TextView tvRefresh;
        @Bind(R.id.banner_region)
        Banner bannerRegion;

        public ComicViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = mContext;
        }

        public void setData(DistrictRecycleBean.DataBean dataBean) {
            tvTitle.setText(dataBean.getTitle());


            ComicAdapter adapter = new ComicAdapter(dataBean.getBody());
            gvRegion.setAdapter(adapter);

            //设置点击事件
            gvRegion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });

            tvRegion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "进去看看", Toast.LENGTH_SHORT).show();
                }
            });

            btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "更多", Toast.LENGTH_SHORT).show();

                }
            });

            tvRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "刷新", Toast.LENGTH_SHORT).show();
                }
            });


            //banner
            final List<DistrictRecycleBean.DataBean.BannerBean.BottomBean> bottomBeen = dataBean.getBanner().getBottom();

            int size = bottomBeen.size();
            List<String> imgs = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String image = bottomBeen.get(i).getImage();
                imgs.add(image);
            }

            //简单使用
            bannerRegion.setImages(imgs)
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
            bannerRegion.setBannerAnimation(BackgroundToForegroundTransformer.class);
            //设置点击事件
            bannerRegion.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    int realPosition = position - 1;
                    WebViewBean bean = new WebViewBean();
                    bean.setTitle(bottomBeen.get(realPosition).getTitle());
                    bean.setLink(bottomBeen.get(realPosition).getUri());

                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra(TopicCenterAdapter.LINK, bean);
                    mContext.startActivity(intent);
//                    Toast.makeText(mContext, "position" + realPosition, Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

    class CreateViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        @Bind(R.id.iv_region)
        ImageView ivRegion;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_region)
        TextView tvRegion;
        @Bind(R.id.gv_region)
        MyGridView gvRegion;
        @Bind(R.id.btn_more)
        Button btnMore;
        @Bind(R.id.tv_refresh)
        TextView tvRefresh;

        public CreateViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = mContext;
        }

        public void setData(DistrictRecycleBean.DataBean dataBean) {

            tvTitle.setText(dataBean.getTitle());

            ComicAdapter adapter = new ComicAdapter(dataBean.getBody());
            gvRegion.setAdapter(adapter);

            //设置点击事件
            gvRegion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                }
            });

            tvRegion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "进去看看", Toast.LENGTH_SHORT).show();
                }
            });

            btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "更多", Toast.LENGTH_SHORT).show();

                }
            });

            tvRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "刷新", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    class TopicViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        @Bind(R.id.iv_region)
        ImageView ivRegion;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_region)
        TextView tvRegion;
        @Bind(R.id.iv_topic)
        ImageView ivTopic;

        public TopicViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = mContext;
        }

        public void setData(final DistrictRecycleBean.DataBean dataBean) {
            tvTitle.setText("话题");
            Glide.with(mContext)
                    .load(dataBean.getBody().get(0).getCover())
                    .crossFade()
                    .into(ivTopic);

            ivTopic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebViewBean bean = new WebViewBean();
                    bean.setLink(dataBean.getBody().get(0).getUri());

                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra(TopicCenterAdapter.LINK, bean);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_region)
        ImageView ivRegion;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_region)
        TextView tvRegion;
        @Bind(R.id.rv_activity)
        RecyclerView rvActivity;
        private final Context mContext;

        public ActivityViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mContext = mContext;
        }

        public void setData(final DistrictRecycleBean.DataBean dataBean) {

            tvTitle.setText(dataBean.getTitle());
            //设置适配器
            ActivityAdapter adapter = new ActivityAdapter(mContext, dataBean);

            rvActivity.setAdapter(adapter);
            //设置布局管理器
            rvActivity.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

            //设置点击事件

            adapter.setOnItemClickListener(new ActivityAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
//                    Toast.makeText(mContext, "position"+position, Toast.LENGTH_SHORT).show();
                    WebViewBean bean = new WebViewBean();
                    bean.setTitle(dataBean.getBody().get(position).getTitle());
                    bean.setLink(dataBean.getBody().get(position).getUri());

                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra(TopicCenterAdapter.LINK, bean);
                    mContext.startActivity(intent);
                }
            });

        }
    }

}
