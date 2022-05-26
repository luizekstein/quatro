package com.mycompany.quatro.measurement;

import java.util.Timer;
import java.util.TimerTask;

public class InsertJavaCli {
    public static void main(String[] args) {
        Measurement measurement = new Measurement();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                measurement.run();
                System.out.println("Memória RAM: " + measurement.getHardware().getRamUsage());
                System.out.println("CPU: " + measurement.getHardware().getProcessorUsage());
                System.out.println("Disco: " + measurement.getHardware().getDiskUsage());
            }
        }, 0, 60000);
    }
}
