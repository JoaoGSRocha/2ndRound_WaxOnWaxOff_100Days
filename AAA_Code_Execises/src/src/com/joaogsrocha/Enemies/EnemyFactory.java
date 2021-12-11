package com.joaogsrocha.Enemies;

import com.joaogsrocha.AbstractFactory;
import com.joaogsrocha.Enemy;


public class EnemyFactory extends AbstractFactory {
    @Override
    public Enemy getEnemy(String enemyType) {
        if(enemyType.equalsIgnoreCase("MINION")){
            return new Minion();
        }else if(enemyType.equalsIgnoreCase("SUPERMINION")){
            return new SuperMinion();
        }
        return null;
    }
}
