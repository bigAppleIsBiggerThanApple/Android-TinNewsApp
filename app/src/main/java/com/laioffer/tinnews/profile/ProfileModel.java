package com.laioffer.tinnews.profile;
import com.laioffer.tinnews.TinApplication;
import com.laioffer.tinnews.database.AppDatabase;

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = TinApplication.getDataBase();

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void deleteAllNewsCache() {

    }

    @Override
    public void setDefaultCountry(String country) {

    }
}
