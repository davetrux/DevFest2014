package com.devfest.manualinjection.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.devfest.manualinjection.app.MainActivity;

/**
 * Created by david on 4/28/14.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity activity;

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        setApplication(new MockMainApplication());

        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(intent, null, null);

        activity = getActivity();
    }

    public void testNumberOfRows(){

        assertNotNull(activity);

    }
}
