package com.laioffer.tinnews.common;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.laioffer.tinnews.common.BaseViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewModelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<BaseViewModel> viewModels;
    private final SparseArrayCompat<BaseViewModel> viewTypeMap;

    public ViewModelAdapter() {
        viewModels = new ArrayList<>();
        viewTypeMap = new SparseArrayCompat<>();
    }


    public void addViewModels(Collection<? extends BaseViewModel> viewModels) {
        this.viewModels.clear();
        this.viewTypeMap.clear();
        addAll(viewModels);
        notifyDataSetChanged();
    }

    public void addViewModel(BaseViewModel viewModel) {
        this.viewModels.add(viewModel);
        viewTypeMap.put(viewModel.getViewType(), viewModel);
        int position = getPosition(viewModel);
        notifyItemInserted(position);
    }

    public void removeViewModel(int position) {
        if (position < -1 || position >= viewModels.size()) {
            return;
        }
        viewModels.remove(position);
        notifyItemRemoved(position);
    }

    private void removeViewModel(BaseViewModel viewModel) {
        int position = getPosition(viewModel);
        removeViewModel(position);
    }

    private int getPosition(BaseViewModel viewModel) {
        int position = viewModels.indexOf(viewModel);
        return  position;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewTypeMap.get(viewType).createViewHolder(parent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewModels.get(position).bindViewHolder(holder);
    }


    @Override
    public int getItemCount() {
        return viewModels.size();
    }


    @Override
    public int getItemViewType(int position) {
        return viewModels.get(position).getViewType();
    }


    private void addAll(Collection<? extends BaseViewModel> viewModels) {
        if (viewModels == null) {
            return;
        }

        for (BaseViewModel baseViewModel : viewModels) {
            this.viewModels.add(baseViewModel);

            //If there are multiple items of the same type the index will just update
            viewTypeMap.put(baseViewModel.getViewType(), baseViewModel);
        }
    }

    public boolean isEmpty() {
        return viewModels.isEmpty();
    }
}
