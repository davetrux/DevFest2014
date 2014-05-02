package com.devfest.roboguice.app;

import android.app.Application;
import roboguice.RoboGuice;

/**
 * Created by truxall on 4/28/2014.
 */
public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        DataModule module = new DataModule(this);

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(this), module);

    }

}
