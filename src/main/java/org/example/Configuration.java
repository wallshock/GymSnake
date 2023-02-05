package org.example;

public class Configuration {
    public static int BP;
    public static int BD;
    public static int LD;
    public static int VMax;

    public static int N;
    public static int P;

    public Configuration(int LethalDose, int MaximumSpeedLimit, int BonusLength, int BonusSpeed,int BackLength,int MapSize) {
        LD = LethalDose;
        VMax = MaximumSpeedLimit;
        BD = BonusLength;
        BP =BonusSpeed;
        P = BackLength;
        N=MapSize;
    }
}
