package com.db.entitys;

import java.sql.Timestamp;

public class ClientsUpsEntity {
    private String id;
    private String clientIp;
    private int clientPort;
    private int deviceType;
    private String deviceName;
    private String account;
    private int locationType;
    private String locationLat;
    private String locationLng;
    private String locationAddr;
    private String msgContent;
    private Timestamp createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(String locationLng) {
        this.locationLng = locationLng;
    }

    public String getLocationAddr() {
        return locationAddr;
    }

    public void setLocationAddr(String locationAddr) {
        this.locationAddr = locationAddr;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsUpsEntity that = (ClientsUpsEntity) o;

        if (clientPort != that.clientPort) return false;
        if (deviceType != that.deviceType) return false;
        if (locationType != that.locationType) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (clientIp != null ? !clientIp.equals(that.clientIp) : that.clientIp != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (locationLat != null ? !locationLat.equals(that.locationLat) : that.locationLat != null) return false;
        if (locationLng != null ? !locationLng.equals(that.locationLng) : that.locationLng != null) return false;
        if (locationAddr != null ? !locationAddr.equals(that.locationAddr) : that.locationAddr != null) return false;
        if (msgContent != null ? !msgContent.equals(that.msgContent) : that.msgContent != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + clientPort;
        result = 31 * result + deviceType;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + locationType;
        result = 31 * result + (locationLat != null ? locationLat.hashCode() : 0);
        result = 31 * result + (locationLng != null ? locationLng.hashCode() : 0);
        result = 31 * result + (locationAddr != null ? locationAddr.hashCode() : 0);
        result = 31 * result + (msgContent != null ? msgContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
