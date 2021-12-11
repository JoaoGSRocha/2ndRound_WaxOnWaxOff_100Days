package com.joaogsrocha;

public interface AbilityScores {
    public static int STR = 0;
    public static int DEX = 0;
    public static int INT = 0;
    public static int WIS = 0;
    public static int CHA = 0;


    public int hpCalc(int lvl, int con, int die);

    /******
     * getCon()
     * This method returns constitution that is used to calculate HP
     * @params  int con
     * @return
     */
    public int getCon();
    /******
     * setCon()
     * This method sets constitution that is used to calculate HP
     * @params  int con
     * @return
     */
    public abstract void setCon(int con);
}
