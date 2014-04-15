package com.devfest;

import com.devfest.fowl.Bird;
import com.devfest.fowl.Chicken;
import com.devfest.fowl.Duck;
import com.devfest.fowl.Owl;

/**
 * Created by truxall on 4/10/2014.
 */
public class BadExample {

    public String birdCall(String birdType){
        Bird bird = null;

        if(birdType.equals("Owl")) {
            bird = new Owl();
        } else if(birdType.equals("Duck")) {
            bird = new Duck();
        } else if(birdType.equals("Chicken")) {
            bird = new Chicken();
        }

        return bird.call();
    }
}
