package bilibili.bilibili.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bilibili.bilibili.R;
import bilibili.bilibili.adapter.MainViewPagerAdapter;
import bilibili.bilibili.base.BaseFragment;
import bilibili.bilibili.fragment.CatchFragment;
import bilibili.bilibili.fragment.CommunityFragment;
import bilibili.bilibili.fragment.DistrictFragment;
import bilibili.bilibili.fragment.LiveFragment;
import bilibili.bilibili.fragment.RecommedFragment;
import butterknife.Bind;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.title_slide)
    ImageView titleSlide;
    @Bind(R.id.title_user)
    ImageView titleUser;
    @Bind(R.id.tv_login)
    TextView tvLogin;
    @Bind(R.id.ll_slide)
    LinearLayout llSlide;
    @Bind(R.id.title_game)
    ImageButton titleGame;
    @Bind(R.id.title_download)
    ImageButton titleDownload;
    @Bind(R.id.title_search)
    ImageButton titleSearch;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ArrayList<BaseFragment> fragments;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        //初始化各个fragment
        initFragment();


        //设置适配器
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        //关联viewpager
        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new LiveFragment());
        fragments.add(new RecommedFragment());
        fragments.add(new CatchFragment());
        fragments.add(new DistrictFragment());
        fragments.add(new CommunityFragment());
    }

    @Override
    protected void initListener() {

    }

}
