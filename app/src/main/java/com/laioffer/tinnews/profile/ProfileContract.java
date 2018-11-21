package com.laioffer.tinnews.profile;
import com.laioffer.tinnews.mvp.MvpContract;

public interface ProfileContract {

    interface View extends MvpContract.View<Presenter> {
        void setView();

        void onCacheCleared();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void onCacheCleared();

        android.view.View.OnClickListener getCacheClearListener();

        android.view.View.OnClickListener getOnCountryChangeListener(String country);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void deleteAllNewsCache();

        void setDefaultCountry(String country);
    }
}
