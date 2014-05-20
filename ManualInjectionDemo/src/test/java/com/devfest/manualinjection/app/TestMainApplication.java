package com.devfest.manualinjection.app;

import com.devfest.manualinjection.data.DataProvider;
import com.devfest.manualinjection.test.mock.MockDataSource;
import org.robolectric.TestLifecycleApplication;

import java.lang.reflect.Method;

/**
 * Created by truxall on 5/15/2014.
 */
public class TestMainApplication extends MainApplication implements TestLifecycleApplication {

    @Override
    public DataProvider getDataProvider() {
        return new MockDataSource();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void beforeTest(Method method) {

    }

    @Override
    public void prepareTest(Object test) {

    }

    @Override
    public void afterTest(Method method) {

    }
}
