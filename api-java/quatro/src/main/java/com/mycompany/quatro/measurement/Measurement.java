package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.mycompany.quatro.log.Logs;
import org.json.JSONObject;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimerTask;

public class Measurement extends TimerTask {
    HardwareData hardware = new HardwareData();

    //get data from disks
    SystemInfo systemInfo = new SystemInfo();
    OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    FileSystem fileSystem = operatingSystem.getFileSystem();
    List<OSFileStore> osFileStores = fileSystem.getFileStores();

    //looca api
    Looca looca = new Looca();
    Temperatura temperatura = new Temperatura();
    //date format
    LocalDateTime now;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //database insertion
    Insertion insertion = new Insertion();

    JSONObject json = new JSONObject();
    @Override
            public void run() {
                this.now = LocalDateTime.now();
                try {
                    Logs log = new Logs(dtf.format(now), looca.getProcessador().getUso(), looca.getMemoria().getEmUso());
                    insertion.cpuMeasurementInsertion(looca.getProcessador().getUso(), temperatura.getTemperatura(), dtf.format(now), 1);
                    hardware.setProcessorUsage(looca.getProcessador().getUso());
                    insertion.memoryMeasurementInsertion(looca.getMemoria().getEmUso(), dtf.format(now), 2);
                    hardware.setRamUsage(looca.getMemoria().getEmUso());

                    for (OSFileStore fileStore : osFileStores) {
                        System.out.println(fileStore.getTotalSpace());
                        insertion.diskMeasurementInsertion((fileStore.getTotalSpace() - fileStore.getFreeSpace()), dtf.format(now), fileStore.getUUID());
                        hardware.setDiskUsage(fileStore.getTotalSpace() - fileStore.getFreeSpace());
                        DiskUsage diskUsage = new DiskUsage(fileStore.getUUID(), fileStore.getTotalSpace() - fileStore.getFreeSpace());
                        
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    public HardwareData getHardware() {
        return hardware;
    }
}
