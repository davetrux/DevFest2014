package com.devfest.test;

import com.devfest.BadExample;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by truxall on 4/16/2014.
 */
public class BadExampleTest {

    @Test
    public void BlueJayTest() {

        BadExample underTest = new BadExample();

        String result = underTest.birdCall("BlueJay");

        assertTrue(result.equals("JAY JAY"));
    }

    @Test
    public void OwlTest() {

        BadExample underTest = new BadExample();

        String result = underTest.birdCall("Owl");

        assertTrue(result.equals("HOOT"));
    }

    @Test
    public void CrowTest() {

        BadExample underTest = new BadExample();

        String result = underTest.birdCall("Crow");

        assertTrue(result.equals("CAW CAW"));
    }

    @Test
    public void MissingInputTest() {

        BadExample underTest = new BadExample();

        String result = underTest.birdCall("");

        assertTrue(result.equals(""));
    }

    @Test
    public void BadInputTest() {

        BadExample underTest = new BadExample();

        String result = underTest.birdCall("Cow");

        assertTrue(result.equals(""));
    }
}
