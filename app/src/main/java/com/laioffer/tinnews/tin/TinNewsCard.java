package com.laioffer.tinnews.tin;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.common.Util;

import com.laioffer.tinnews.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.squareup.picasso.Picasso;

@Layout(R.layout.tin_news_card)
public class TinNewsCard {

    @View(R.id.news_image)
    private ImageView image;
    @View(R.id.news_title)
    private TextView newsTitle;

    @View(R.id.news_description)
    private TextView newsDescription;

    private final News news;
    private final SwipePlaceHolderView swipeView;

    private final OnSwipeListener onSwipeListener;

    public TinNewsCard(News news, SwipePlaceHolderView swipeView, OnSwipeListener onSwipeListener) {
        this.news = news;
        this.swipeView = swipeView;
        this.onSwipeListener = onSwipeListener;
    }

    @Resolve
    private void onResolved(){
        if (Util.isStringEmpty(news.image)) {
            image.setImageResource(R.drawable.no_image_available);
        } else {
            Picasso.get().load(news.getImage()).into(image);
        }
        newsTitle.setText(news.getTitle());
        newsDescription.setText(news.getDescription());
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        swipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
        onSwipeListener.onLike(news);

    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }


    interface OnSwipeListener {
        void onLike(News news);
    }
}


