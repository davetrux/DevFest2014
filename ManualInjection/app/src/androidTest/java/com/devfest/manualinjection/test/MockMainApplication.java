package com.devfest.manualinjection.test;

import android.test.mock.MockApplication;

import com.devfest.manualinjection.data.DataProvider;

/**
 * Created by david on 4/28/14.
 */
public class MockMainApplication extends MockApplication {

    public DataProvider getDataProvider() {
        return new MockDataSource();
    }

}
