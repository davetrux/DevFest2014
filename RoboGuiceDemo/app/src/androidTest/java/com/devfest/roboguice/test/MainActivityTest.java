package com.devfest.roboguice.test;

import android.app.Application;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.ListView;

import com.devfest.roboguice.app.MainActivity;
import com.devfest.roboguice.app.R;
import com.devfest.roboguice.test.mock.MockMainApplication;

/**
 * Created by david on 4/28/14.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        Application app = new MockMainApplication(getInstrumentation().getContext());
        setApplication(app);
        app.onCreate();
    }


    public void testNumberOfRows(){

        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);

        startActivity(intent, null, null);

        ListView list = (ListView)mActivity.findViewById(R.id.taskList);

        assertNotNull(list);

        int count = list.getAdapter().getCount();

        assertEquals(3, count);
    }
}
