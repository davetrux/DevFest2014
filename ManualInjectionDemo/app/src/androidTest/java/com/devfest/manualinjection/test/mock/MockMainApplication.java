package com.devfest.manualinjection.test.mock;

import android.test.mock.MockApplication;

import com.devfest.manualinjection.app.MainApplication;
import com.devfest.manualinjection.data.DataProvider;

/**
 * Created by david on 4/28/14.
 */
public class MockMainApplication extends MainApplication {

    @Override
    public DataProvider getDataProvider() {
        return new MockDataSource();
    }

}
