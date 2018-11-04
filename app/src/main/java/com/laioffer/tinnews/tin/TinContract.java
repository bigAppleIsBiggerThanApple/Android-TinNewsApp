package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.mvp.MvpContract;

public interface TinContract {


    interface View extends MvpContract.View<Presenter> {

    }

    interface Presenter extends MvpContract.Presenter<View, Model> {

    }

    interface Model extends MvpContract.Model<Presenter> {

    }
}

