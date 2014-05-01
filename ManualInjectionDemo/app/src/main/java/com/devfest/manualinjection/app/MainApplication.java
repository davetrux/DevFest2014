package com.devfest.manualinjection.app;

import android.app.Application;

import com.devfest.manualinjection.data.DataProvider;
import com.devfest.manualinjection.data.SqlLiteProvider;

/**
 * Created by truxall on 4/28/2014.
 */
public class MainApplication extends Application {

    private DataProvider mProvider;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public DataProvider getDataProvider() {
        if(mProvider == null) {
            mProvider = new SqlLiteProvider(this);
        }

        return mProvider;
    }
}
