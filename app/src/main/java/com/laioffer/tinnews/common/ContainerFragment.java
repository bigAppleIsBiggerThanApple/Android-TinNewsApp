package com.laioffer.tinnews.common;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.save.SavedNewsFragment;
import com.laioffer.tinnews.tin.TinGalleryFragment;

import android.support.v4.app.Fragment;

public class ContainerFragment extends TinBasicFragment {
    private int pageIndex;
    public static final int HOME_PAGE = 0;
    public static final String HOME_PAGE_TAG = "home_page";
    public static final int SAVE_PAGE = 1;
    public static final String SAVE_PAGE_TAG = "save_page";
    public static final int PROFILE_PAGE = 2;
    public static final String PROFILE_PAGE_TAG = "profile_page";
    private Fragment initFragment;


    public static ContainerFragment newInstance(int pageIndex) {
        ContainerFragment containerFragment = new ContainerFragment();
        containerFragment.pageIndex = pageIndex;
        containerFragment.initFragment = createInitFragmentByIndex(pageIndex);

        return containerFragment;
    }

    private static Fragment createInitFragmentByIndex(int pageIndex) {
        switch (pageIndex) {
            case HOME_PAGE:
                return TinGalleryFragment.newInstance();
            case SAVE_PAGE:
                return SavedNewsFragment.newInstance();
            case PROFILE_PAGE:
                return null;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //replace old layout with child_fragment_container
        return inflater.inflate(R.layout.child_fragment_container, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (initFragment != null && !initFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().replace(R.id.child_fragment_container, initFragment, getCurrentTag(pageIndex))
                    .commit();
        }
    }
    public static String getCurrentTag(int position) {
        switch (position) {
            case HOME_PAGE:
                return HOME_PAGE_TAG;
            case SAVE_PAGE:
                return SAVE_PAGE_TAG;
            case PROFILE_PAGE:
                return PROFILE_PAGE_TAG;
            default:
                return null;
        }
    }
    public static int getPositionById(int id) {
        switch (id) {
            case R.id.action_tin:
                return HOME_PAGE;
            case R.id.action_save:
                return SAVE_PAGE;
            case R.id.action_profile:
                return PROFILE_PAGE;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

}

