package com.hp.reference.test;

import android.app.Fragment;
import com.hp.reference.app.Main;
import com.hp.reference.app.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by truxall on 4/18/2014.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private Main activity;
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(Main.class).get();
    }

//    @Test
//    public void shouldFail() {
//        assertTrue(true);
//    }

    @Test
    public void shouldNotBeNull() {

        assertNotNull(activity);

        Object fragment = (Fragment) activity.getFragmentManager().findFragmentById(R.id.container);

        assertNotNull(fragment);
    }
}
