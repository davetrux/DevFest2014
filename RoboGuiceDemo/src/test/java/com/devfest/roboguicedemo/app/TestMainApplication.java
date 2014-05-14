package com.devfest.roboguicedemo.app;

import com.devfest.roboguicedemo.test.mock.TestModule;
import org.robolectric.Robolectric;
import org.robolectric.TestLifecycleApplication;
import roboguice.RoboGuice;

import java.lang.reflect.Method;

/**
 * Created by truxall on 5/13/2014.
 */
public class TestMainApplication extends MainApplication implements TestLifecycleApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
                RoboGuice.newDefaultRoboModule(this), new TestModule());
    }

    @Override
    public void beforeTest(Method method) {

    }

    @Override
    public void prepareTest(Object test) {
        TestMainApplication application = (TestMainApplication) Robolectric.application;

        RoboGuice.setBaseApplicationInjector(application, RoboGuice.DEFAULT_STAGE,
                RoboGuice.newDefaultRoboModule(application), new TestModule());

        RoboGuice.getInjector(application).injectMembers(test);
    }

    @Override
    public void afterTest(Method method) {

    }
}
