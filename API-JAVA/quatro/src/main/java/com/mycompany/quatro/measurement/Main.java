package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                System.out.println(String.format("%.2f", looca.getProcessador().getUso()));
                System.out.println(String.format("Memória: %d", looca.getMemoria().getEmUso()));
                System.out.println(String.format("Disco: %s", looca.getGrupoDeDiscos().getVolumes()));
            }
        },0,3000);
    }
}
