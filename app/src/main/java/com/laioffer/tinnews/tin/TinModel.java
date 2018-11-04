package com.laioffer.tinnews.tin;

public class TinModel implements TinContract.Model {
    private TinContract.Presenter presenter;
    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
