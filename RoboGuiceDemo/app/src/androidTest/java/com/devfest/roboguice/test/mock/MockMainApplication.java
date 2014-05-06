package com.devfest.roboguice.test.mock;

import android.content.Context;
import android.test.mock.MockApplication;

import com.google.inject.util.Modules;

import roboguice.RoboGuice;

/**
 * Created by david on 4/28/14.
 */
public class MockMainApplication extends MockApplication {

    private Context mContext;

    public MockMainApplication(Context context){

        attachBaseContext(context);
        mContext = context;
    }

    @Override
    public void onCreate() {

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(this)).with(new TestModule()));

    }
}
