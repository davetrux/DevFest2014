package com.devfest;

import com.devfest.fowl.Crow;
import com.devfest.fowl.BlueJay;
import com.devfest.fowl.Owl;

/**
 * Created by truxall on 4/10/2014.
 */
public class BadExample {

    public String birdCall(String birdType){

        if(birdType.equals("Owl")) {
            Owl bird = new Owl();
            return bird.call().toUpperCase();
        } else if(birdType.equals("BlueJay")) {
            BlueJay bird = new BlueJay();
            return bird.call().toUpperCase();
        } else if(birdType.equals("Crow")) {
            Crow bird = new Crow();
            return bird.call().toUpperCase();
        }
        return "";
   }
}
