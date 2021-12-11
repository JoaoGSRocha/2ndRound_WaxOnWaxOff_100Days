package com.joaogsrocha.Enemies;

import com.joaogsrocha.Enemy;

public class Minion implements Enemy {
    @Override
    public void draw() {
        System.out.println("Inside Minion::draw() method");
    }
}
