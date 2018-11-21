package com.laioffer.tinnews.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.ViewModelAdapter;
import com.laioffer.tinnews.mvp.MvpContract;
import com.laioffer.tinnews.mvp.MvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TinProfileFragment extends MvpFragment<ProfileContract.Presenter> implements ProfileContract.View{

    private ViewModelAdapter viewModelAdapter;

    public static TinProfileFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TinProfileFragment fragment = new TinProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tin_profile, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;

    }

    @Override
    public ProfileContract.Presenter getPresenter() {
        return new ProfilePresenter();
    }

    @Override
    public void setView() {

    }

    @Override
    public void onCacheCleared() {

    }
}
