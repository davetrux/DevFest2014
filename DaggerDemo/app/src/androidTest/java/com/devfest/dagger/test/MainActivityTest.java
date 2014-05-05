package com.devfest.dagger.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.ListView;

import com.devfest.dagger.app.MainActivity;
import com.devfest.dagger.app.R;
import com.devfest.dagger.test.mock.MockMainApplication;

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
        //setApplication(new MockMainApplication());
        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(intent, null, null);

        MainActivity activity = getActivity();

        assertNotNull(activity);


        ListView list = (ListView)activity.findViewById(R.id.taskList);

        assertNotNull(list);

        int count = list.getAdapter().getCount();

        assertEquals(count, 3);
    }
}
