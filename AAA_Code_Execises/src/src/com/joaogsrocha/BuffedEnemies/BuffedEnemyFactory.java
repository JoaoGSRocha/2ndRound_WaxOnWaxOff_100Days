package com.joaogsrocha.BuffedEnemies;

import com.joaogsrocha.AbstractFactory;
import com.joaogsrocha.Enemy;

public class BuffedEnemyFactory extends AbstractFactory {
    @Override
    public Enemy getEnemy(String enemyType) {
        if(enemyType.equalsIgnoreCase("BUFFEDMINION")){
            return new BuffedMinion();
        }else if(enemyType.equalsIgnoreCase("BUFFEDSUPERMINION")){
            return new BuffedSuperMinion();
        }
        return null;
    }
}

