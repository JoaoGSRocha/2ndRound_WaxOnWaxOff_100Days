package com.joaogsrocha;

import java.awt.*;
import java.io.IOException;

public class NEwMain {
    public static void main(String[] args) {
        //get Enemy Factory
        AbstractFactory enemyFactory = FactoryProducer.getFactory(false);
        //get an object of Enemy, in this case Minion
        Enemy enemy1 = enemyFactory.getEnemy("MINION");
        //call draw method of Enemy Minion
        enemy1.draw();
        //get an object of Enemy SuperMinion
        Enemy enemy2 = enemyFactory.getEnemy("SUPERMINION");
        //call draw method of Enemy SuperMinion
        enemy2.draw();
        //get Enemy factory
        AbstractFactory enemyFactoryBuffed = FactoryProducer.getFactory(true);
        //get an object of Enemy BuffedMinion
        Enemy enemy3 = enemyFactoryBuffed.getEnemy("BUFFEDMINION");
        //call draw method of Enemy BuffedMinion
        enemy3.draw();
        //get an object of Enemy BuffedSuperMinion
        Enemy enemy4 = enemyFactoryBuffed.getEnemy("BUFFEDSUPERMINION");
        //call draw method of Enemy BuffedSuperMinion
        enemy4.draw();
    }
}
