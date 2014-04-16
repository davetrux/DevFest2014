package com.devfest;

import com.devfest.fowl.Bird;

/**
 * Created by truxall on 4/16/2014.
 */
public class DiExample {

    private Bird mBird;

    public DiExample(Bird bird) {
        mBird = bird;
    }

    public String birdCall(){
        return mBird.call().toUpperCase();
    }
}
