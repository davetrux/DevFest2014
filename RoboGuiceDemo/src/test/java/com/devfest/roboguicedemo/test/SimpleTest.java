package com.devfest.roboguicedemo.test;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by truxall on 4/10/2014.
 */
public class SimpleTest {

    @Test
    public void testNothing(){
        final int expected = 1;
        final int reality = 1;
        assertEquals(expected, reality);
    }
}
