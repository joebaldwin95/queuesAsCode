package com.qac.model;

public class Queue {

    private String name;
    private boolean fifo;
    private boolean encrypted;
    private boolean dlq;
    private String dlqName;
    private int maxDelivery;
    private String orgId;
    private String envId;

    public Queue(String name, boolean fifo, boolean encrypted, boolean dlq, String dlqName,
            long maxDelivery, String orgId, String envId) {
        super();
        this.name = name;
        this.fifo = fifo;
        this.encrypted = encrypted;
        this.dlq = dlq;
        this.dlqName = dlqName;
        this.maxDelivery = (int) maxDelivery;
        this.orgId = orgId;
        this.envId = envId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFifo() {
        return fifo;
    }

    public void setFifo(boolean fifo) {
        this.fifo = fifo;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public boolean isDlq() {
        return dlq;
    }

    public void setDlq(boolean dlq) {
        this.dlq = dlq;
    }

    public String getDlqName() {
        return dlqName;
    }

    public void setDlqName(String dlqName) {
        this.dlqName = dlqName;
    }

    public int getMaxDelivery() {
        return maxDelivery;
    }

    public void setMaxDelivery(int maxDelivery) {
        this.maxDelivery = maxDelivery;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEnvId() {
        return envId;
    }

    public void setEnvId(String envId) {
        this.envId = envId;
    }
}