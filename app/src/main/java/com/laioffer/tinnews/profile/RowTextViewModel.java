package com.laioffer.tinnews.profile;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.BaseViewModel;

public class RowTextViewModel extends BaseViewModel<RowTextViewModel.RowTextViewModelHolder> {

    private final String rowText;
    private final View.OnClickListener listener;
    public RowTextViewModel(String rowText, View.OnClickListener listener) {
        super(R.layout.setting_row_text_layout);
        this.rowText = rowText;
        this.listener = listener;
    }

    @Override
    public RowTextViewModelHolder createItemViewHolder(View view) {
        return new RowTextViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(RowTextViewModelHolder holder) {
        holder.row.setText(rowText);
        holder.row.setOnClickListener(listener);
    }

    static class RowTextViewModelHolder extends RecyclerView.ViewHolder {
        TextView row;
        RowTextViewModelHolder(View itemView) {
            super(itemView);
            row = itemView.findViewById(R.id.row_text);
        }
    }
}
