

package com.laioffer.tinnews.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public abstract class TinBasicActivity extends AppCompatActivity implements TinFragmentManager {
    protected static final String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    @Override
    public void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra(BUNDLE, bundle);
        this.startActivity(intent);
        if (isFinished) {
            finish();
        }
    }

    @LayoutRes
    protected abstract int getLayout();
}
