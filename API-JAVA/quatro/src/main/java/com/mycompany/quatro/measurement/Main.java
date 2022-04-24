package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        FileSystem fileSystem = operatingSystem.getFileSystem();
        List<OSFileStore> osFileStores = fileSystem.getFileStores();
        Looca looca = new Looca();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Insertion insertion = new Insertion();
        Temperatura temperatura = new Temperatura();

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                insertion.cpuMeasurementInsertion(Math.round(looca.getProcessador().getUso()), temperatura.getTemperatura(), dtf.format(now), 1);
                System.out.println(String.format("Uso processador: %.2f", looca.getProcessador().getUso()));
                System.out.println("Frequência do processador: " + looca.getProcessador().getFrequencia());
                System.out.println("Temperatura do processador: " + looca.getTemperatura());
                insertion.memoryMeasurementInsertion(looca.getMemoria().getEmUso(), dtf.format(now), 2);
                System.out.println(String.format("Memória: %d", looca.getMemoria().getEmUso()));
                for(OSFileStore fileStore : osFileStores) {
                    insertion.diskMeasurementInsertion((fileStore.getTotalSpace() - fileStore.getFreeSpace()), dtf.format(now), fileStore.getUUID());
                    System.out.println("UUID: " + fileStore.getUUID());
                    System.out.println("Espaço disponível: " + fileStore.getFreeSpace());
                    System.out.println("Espaço total: " + fileStore.getTotalSpace());
                    System.out.println("Espaço usado:" + (fileStore.getTotalSpace() - fileStore.getFreeSpace()));
                }
            }
        },0,5000);
    }
}