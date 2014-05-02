package com.devfest.roboguice.test;

import android.test.InstrumentationTestCase;

/**
 * Created by truxall on 4/10/2014.
 */
public class SimpleTest extends InstrumentationTestCase {

    public void testNothing(){
        final int expected = 1;
        final int reality = 1;
        assertEquals(expected, reality);
    }
}
