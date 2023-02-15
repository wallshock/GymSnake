package org.example;

public class Configuration {
    public static int BP;
    public static int BD;
    public static int LD;
    public static int VMax;

    public static int N;
    public static int P;
    public static int IL;
    public static int IW;
    public static int IS;
    public Configuration(int LethalDose, int MaximumSpeedLimit, int BonusLength, int BonusSpeed, int TailLength, int MapSize, int InitialLength, int InitialWidth, int InitialSpeed) {
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
