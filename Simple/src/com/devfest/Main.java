package com.devfest;

import com.devfest.fowl.Bird;
import com.devfest.fowl.BlueJay;
import com.devfest.fowl.Crow;
import com.devfest.fowl.Owl;

public class Main {

    public static void main(String[] args) {

        BadExample bad = new BadExample();

        System.out.println(bad.birdCall("Owl"));

        System.out.println();

        Bird owl = new Owl();
        
        DiExample good = new DiExample(owl);

        System.out.println(good.birdCall());

        good.setBird(new Crow());

        System.out.println(good.birdCall());

        System.out.println(good.birdCall(new BlueJay()));

    }
}
