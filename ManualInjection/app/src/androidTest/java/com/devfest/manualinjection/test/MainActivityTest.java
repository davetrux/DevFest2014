package com.devfest.manualinjection.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.devfest.manualinjection.app.MainActivity;

/**
 * Created by david on 4/28/14.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        setApplication(new MockMainApplication());

    }

    public void testNumberOfRows(){

        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(intent, null, null);

        MainActivity activity = getActivity();

        assertNotNull(activity);

    }
}
