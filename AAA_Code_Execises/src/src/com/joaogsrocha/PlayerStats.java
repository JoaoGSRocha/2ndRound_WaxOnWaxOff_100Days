package com.joaogsrocha;

public class PlayerStats implements AbilityScores, Equipment {
    private int hp;
    private int con;

    @Override
    public int hpCalc(int lvl, int con, int die) {
     return 0;
    }

    @Override
    public int getCon() {
        return con;
    }

    @Override
    public void setCon(int con) {
        this.con = con;
    }
}