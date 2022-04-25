package com.mycompany.quatro.measurement;

import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.util.List;

public class HardwareData {
    SystemInfo systemInfo = new SystemInfo();
    OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
    FileSystem fileSystem = operatingSystem.getFileSystem();
    List<OSFileStore> osFileStores = fileSystem.getFileStores();
    Looca looca = new Looca();


    private Double processorUsage;

    private Long diskUsage;

    private Long ramUsage;

    public HardwareData() {
        this.processorUsage = 0.0;
        this.ramUsage = 0L;
        this.diskUsage = 0L;
    }

    public String getProcessorUsage() {
       return Double.toString(this.processorUsage);
    }

    public String getDiskUsage() {
        return Long.toString(this.diskUsage);
    }

    public String getRamUsage() {
        return Long.toString(this.ramUsage);
    }

    public String getOperationalSystem() {
      return operatingSystem.getFamily();
    }

    public void setProcessorUsage(Double usage) {
        this.processorUsage = usage;
    }

    public void setRamUsage(Long usage) {
        this.ramUsage = usage;
    }

    public void setDiskUsage(Long usage) {
        this.diskUsage += usage;
    }
}
