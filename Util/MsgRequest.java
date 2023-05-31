package Util;

import java.io.Serializable;
import java.util.Random;

public class MsgRequest implements Serializable{
    private double value1;
    private char escolha;
    private Random nuRandom;
    
    public MsgRequest(double value1, Random nuRandom, char escolha) {
        this.value1 = value1;
        this.nuRandom = nuRandom;
        this.escolha = escolha;
    }

    public double getValue1() {
        return value1;
    }

    public Random getNuRandom() {
        return nuRandom;
    }

    public char getEscolha() {
        return escolha;
    }

}