package com.joaogsrocha;

import com.joaogsrocha.BuffedEnemies.BuffedEnemyFactory;
import com.joaogsrocha.Enemies.EnemyFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean buffed){
        if(buffed){
            return new BuffedEnemyFactory();
        }else{
            return new EnemyFactory();
        }
    }
}
