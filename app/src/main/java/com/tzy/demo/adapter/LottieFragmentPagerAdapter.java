package com.tzy.demo.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tzy.demo.activity.animator.LottieFragment;

/**
 * Created by tang
 * 2018/4/18
 */
public class LottieFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String mFolders[];
    private String mJsons[];

    public LottieFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFolders = new String[] {"images1", "images2", "images3", "images4"};
        mJsons = new String[] {"page1.json", "page2.json", "page3.json", "page4.json"};
    }

    /**
     * Return the Fragment associated with landscape specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return LottieFragment.newInstance(mFolders[position], mJsons[position]);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mFolders.length;
    }
}
