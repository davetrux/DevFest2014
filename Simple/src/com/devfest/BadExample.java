package com.devfest;

import com.devfest.fowl.Bird;
import com.devfest.fowl.Crow;
import com.devfest.fowl.BlueJay;
import com.devfest.fowl.Owl;

/**
 * Created by truxall on 4/10/2014.
 */
public class BadExample {

    public String birdCall(String birdType){

        Bird bird = null;

        if(birdType.equals("Owl")) {
            bird = new Owl();
        } else if(birdType.equals("BlueJay")) {
            bird = new BlueJay();
        } else if(birdType.equals("Crow")) {
            bird = new Crow();
        }

        if(bird == null) {return "";}

        return bird.call().toUpperCase();
   }
}
