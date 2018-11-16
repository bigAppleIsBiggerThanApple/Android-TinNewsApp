package com.laioffer.tinnews.tin;

import android.annotation.SuppressLint;

import com.laioffer.tinnews.TinApplication;
import com.laioffer.tinnews.database.AppDatabase;
import com.laioffer.tinnews.retrofit.NewsRequestApi;
import com.laioffer.tinnews.retrofit.RetrofitClient;
import com.laioffer.tinnews.retrofit.response.News;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TinModel implements TinContract.Model {
    private TinContract.Presenter presenter;

    private final NewsRequestApi newsRequestApi;

    //8.2 add db reference
    private final AppDatabase db;

    public TinModel() {
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);
        //8.2 add db reference
        db = TinApplication.getDataBase();
    }


    //move the Retrofit client here

    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchData() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    //pass the fetch data to the mode
                    presenter.showNewsCard(baseResponse.articles);
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void saveFavoriteNews(News news) {
        Disposable disposable = Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{
            System.out.print("xx");
        }, error -> {
        });
    }


}
