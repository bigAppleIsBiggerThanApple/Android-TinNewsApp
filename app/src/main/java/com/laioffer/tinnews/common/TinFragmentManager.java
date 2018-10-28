package com.laioffer.tinnews.common;

import android.os.Bundle;

import com.laioffer.tinnews.save.detail.SavedNewsDetailedFragment;

public interface TinFragmentManager {

    void doFragmentTransaction(TinBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);

}
