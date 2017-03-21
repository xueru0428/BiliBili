package bilibili.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import bilibili.bilibili.base.BaseFragment;

/**
 * Created by XUERU on 2017/3/4.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private  ArrayList<BaseFragment> fragments;
    private String[] titles = new String[]{"直播", "推荐","追番","分区","发现"};

    public MainViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<BaseFragment> fragments) {
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
