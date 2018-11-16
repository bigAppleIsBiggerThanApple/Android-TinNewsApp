package com.laioffer.tinnews.save;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.TinFragmentManager;
import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.save.detail.SavedNewsDetailedFragment;

import java.util.LinkedList;
import java.util.List;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {

    private List<News> newsList;
    private TinFragmentManager fragmentManager;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsAdapter(TinFragmentManager tinFragmentManager) {
        this.fragmentManager = tinFragmentManager;
        this.newsList = new LinkedList<>();

    }

    public void setNewsList(List<News> newsList) {
        this.newsList.clear();
        this.newsList.addAll(newsList);
        notifyDataSetChanged();
    }

    @Override
    public SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SavedNewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.author.setText(news.getAuthor());
        holder.description.setText(news.getDescription());
        holder.icon.setImageResource(getDrawable());
        holder.itemView.setOnClickListener(v -> {
            fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance());
        });
    }

    private @DrawableRes
    int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }
}
