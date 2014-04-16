package com.devfest.test;

import com.devfest.DiExample;
import com.devfest.fowl.BlueJay;
import com.devfest.fowl.Crow;
import com.devfest.fowl.Owl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by truxall on 4/16/2014.
 */
public class DiExampleTest {

    @Test
    public void BlueJayTest() {

        DiExample underTest = new DiExample(new BlueJay());

        String result = underTest.birdCall();

        assertTrue(result.equals("JAY JAY"));
    }

    @Test
    public void OwlTest() {

        DiExample underTest = new DiExample(new Owl());

        String result = underTest.birdCall();

        assertTrue(result.equals("HOOT"));
    }

    @Test
    public void CrowTest() {

        DiExample underTest = new DiExample(new Crow());

        String result = underTest.birdCall();

        assertTrue(result.equals("CAW CAW"));
    }

    @Test (expected = NullPointerException.class)
    public void NullTest() {

        DiExample underTest = new DiExample(null);

        String result = underTest.birdCall();
    }
}
