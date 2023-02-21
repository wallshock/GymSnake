package org.example;

public class Configuration {
    public static double BP;
    public static int BD;
    public static int LD;
    public static int VMax;

    public static int N = 10;
    public static int P;
    public static int IL;
    public final static int GRID_WIDTH = 1200;
    public final static int GRID_HEIGHT = 1200;
    public static int IW;
    public static double IS;
    public Configuration(int LethalDose, int MaximumSpeedLimit, int BonusLength, double BonusSpeed, int TailLength, int MapSize, int InitialLength, int InitialWidth, double InitialSpeed) {
        LD = LethalDose;
        VMax = MaximumSpeedLimit;
        BD = BonusLength;
        BP =BonusSpeed;
        P = TailLength;
        N=MapSize;
        IL = InitialLength;
        IW = InitialWidth;
        IS = InitialSpeed;
    }
}
