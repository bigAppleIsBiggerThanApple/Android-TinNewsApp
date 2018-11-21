package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.profile.CountryEvent;
import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {
    private TinContract.View view;

    //link the model with presenter
    private TinContract.Model model;

    public TinPresenter() {
        this.model = new TinModel();
        //link the model with presenter
        this.model.setPresenter(this);
    }

    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
            //7.6
            this.model.fetchData(countryEvent.country);
        }
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(TinContract.View view) {
        //hold the reference
        this.view = view;
        //5.7 start to fetchData
        this.model.fetchData("us");
    }

    @Override
    public void onViewDetached() {
        //clear the reference
        this.view = null;
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);
    }


}
