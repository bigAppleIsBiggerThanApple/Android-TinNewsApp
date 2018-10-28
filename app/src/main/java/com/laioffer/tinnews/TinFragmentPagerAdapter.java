package com.laioffer.tinnews;

import android.support.v4.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.laioffer.tinnews.common.ContainerFragment;

public class TinFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments = new Fragment[FRAGMENT_NUMBER];
    public static int FRAGMENT_NUMBER = 3;

    public TinFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        for (int i = 0; i < FRAGMENT_NUMBER; i++) {
            fragments[i] = ContainerFragment.newInstance(i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 0 || position >= FRAGMENT_NUMBER) {
            throw new IndexOutOfBoundsException("Out of Boundary");
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return FRAGMENT_NUMBER;
    }
}
