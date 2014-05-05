package com.devfest.roboguice.test;

import android.app.Application;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.mock.MockApplication;
import android.widget.ListView;

import com.devfest.roboguice.app.MainActivity;
import com.devfest.roboguice.app.MainApplication;
import com.devfest.roboguice.app.R;
import com.devfest.roboguice.test.mock.MockMainApplication;
import com.devfest.roboguice.test.mock.TestModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

import roboguice.RoboGuice;

/**
 * Created by david on 4/28/14.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2 {

    private MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

//        final AbstractModule[] modules = new AbstractModule[] {new TestModule()};
//        final Injector injector = Guice.createInjector(modules);
//        injector.injectMembers(this);
         //RoboGuice.getInjector(app).injectMembers(this);

        //setApplication(new MockMainApplication(getInstrumentation().getContext()));
        //Application app = new MockMainApplication(getInstrumentation().getContext());
        //setApplication(app);
        //RoboGuice.setBaseApplicationInjector(app, RoboGuice.DEFAULT_STAGE, new TestModule());
        //RoboGuice.setBaseApplicationInjector(app, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(app)).with(new TestModule()));
        //RoboGuice.getInjector(app).injectMembers(this);

        mActivity = (MainActivity) getActivity();

        Application app = mActivity.getApplication();

        RoboGuice.setBaseApplicationInjector(app, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(app)).with(new TestModule()));
    }

    public void testNumberOfRows(){

        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);

        ListView list = (ListView)mActivity.findViewById(R.id.taskList);

        assertNotNull(list);

        int count = list.getAdapter().getCount();

        assertEquals(3, count);
    }
}
