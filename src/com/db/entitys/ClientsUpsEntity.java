package com.db.entitys;

import java.sql.Timestamp;

public class ClientsUpsEntity {
    private String id;
    private String packid;
    private String clientIp;
    private int clientPort;
    private int deviceType;
    private String deviceName;
    private String account;
    private int locationType;
    private String locationLat;
    private String locationLng;
    private String locationAddr;
    private Integer packType;
    private String msgContent;
    private Timestamp packTime;
    private Timestamp createTime;
    private String agent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackid() {
        return packid;
    }

    public void setPackid(String packid) {
        this.packid = packid;
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

    public Integer getPackType() {
        return packType;
    }

    public void setPackType(Integer packType) {
        this.packType = packType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Timestamp getPackTime() {
        return packTime;
    }

    public void setPackTime(Timestamp packTime) {
        this.packTime = packTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsUpsEntity entity = (ClientsUpsEntity) o;

        if (clientPort != entity.clientPort) return false;
        if (deviceType != entity.deviceType) return false;
        if (locationType != entity.locationType) return false;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (packid != null ? !packid.equals(entity.packid) : entity.packid != null) return false;
        if (clientIp != null ? !clientIp.equals(entity.clientIp) : entity.clientIp != null) return false;
        if (deviceName != null ? !deviceName.equals(entity.deviceName) : entity.deviceName != null) return false;
        if (account != null ? !account.equals(entity.account) : entity.account != null) return false;
        if (locationLat != null ? !locationLat.equals(entity.locationLat) : entity.locationLat != null) return false;
        if (locationLng != null ? !locationLng.equals(entity.locationLng) : entity.locationLng != null) return false;
        if (locationAddr != null ? !locationAddr.equals(entity.locationAddr) : entity.locationAddr != null)
            return false;
        if (packType != null ? !packType.equals(entity.packType) : entity.packType != null) return false;
        if (msgContent != null ? !msgContent.equals(entity.msgContent) : entity.msgContent != null) return false;
        if (packTime != null ? !packTime.equals(entity.packTime) : entity.packTime != null) return false;
        if (createTime != null ? !createTime.equals(entity.createTime) : entity.createTime != null) return false;
        if (agent != null ? !agent.equals(entity.agent) : entity.agent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (packid != null ? packid.hashCode() : 0);
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + clientPort;
        result = 31 * result + deviceType;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + locationType;
        result = 31 * result + (locationLat != null ? locationLat.hashCode() : 0);
        result = 31 * result + (locationLng != null ? locationLng.hashCode() : 0);
        result = 31 * result + (locationAddr != null ? locationAddr.hashCode() : 0);
        result = 31 * result + (packType != null ? packType.hashCode() : 0);
        result = 31 * result + (msgContent != null ? msgContent.hashCode() : 0);
        result = 31 * result + (packTime != null ? packTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (agent != null ? agent.hashCode() : 0);
        return result;
    }
}
