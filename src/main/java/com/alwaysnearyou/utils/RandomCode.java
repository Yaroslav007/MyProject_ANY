package com.alwaysnearyou.utils;

import java.util.Random;

public class RandomCode {

    public int randomNumber(){
        Random random = new Random();
        int rage = 9999;
        int number = 1000+random.nextInt(rage-1000);

        return number;
    }
}
