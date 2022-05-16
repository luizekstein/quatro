package com.mycompany.quatro.log;

import com.mycompany.quatro.measurement.DiskUsage;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private Integer id;
    private String dhGenerate;
    private Double processorUsage;
    private Long diskUsage;
    private Long ramUsage;

    private List<DiskUsage> diskUsageList = new ArrayList<>();

    public Logs(String dhGenerate, Double processorUsage, Long ramUsage) {
        this.id = 0;
        this.dhGenerate = dhGenerate;
        this.processorUsage = processorUsage;
        this.ramUsage = ramUsage;
    }

    public void addDiskUsage(DiskUsage diskUsage) {
        this.diskUsageList.add(diskUsage);
    }

    public List<DiskUsage> getDiskUsageList() {
        return this.diskUsageList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDhGenerate() {
        return dhGenerate;
    }

    public void setDhGenerate(String dhGenerate) {
        this.dhGenerate = dhGenerate;
    }

    public Double getProcessorUsage() {
        return processorUsage;
    }

    public void setProcessorUsage(Double processorUsage) {
        this.processorUsage = processorUsage;
    }

    public Long getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Long diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Long getRamUsage() {
        return ramUsage;
    }

    public void setRamUsage(Long ramUsage) {
        this.ramUsage = ramUsage;
    }

    @Override public String toString() {
        return String.format(
                "[ID: %d, DATA: %s, USO DO PROCESSADOR: %.2f, USO DO DISCO: %s, USO DA MEMÓRIA RAM: %d]",
                this.id+=1, this.dhGenerate, this.processorUsage, this.diskUsageList, this.ramUsage
        );
    }
}
