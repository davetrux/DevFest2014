package com.devfest.roboguice.test.mock;

import android.content.Context;
import android.test.mock.MockApplication;

import roboguice.RoboGuice;

/**
 * Created by david on 4/28/14.
 */
public class MockMainApplication extends MockApplication {

    public MockMainApplication(Context context){
        super();
        attachBaseContext(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(this), new TestModule());
        //RoboGuice.getInjector(this).injectMembers(this);

    }
}
