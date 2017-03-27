package bilibili.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import bilibili.bilibili.base.BaseFragment;

/**
 * Created by XUERU on 2017/3/4.
 */

public class RegionViewPagerAdapter extends FragmentPagerAdapter {
    private  ArrayList<BaseFragment> fragments;
    private String[] titles = new String[]{"番剧","动画","音乐","舞蹈","游戏"};

    public RegionViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<BaseFragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
