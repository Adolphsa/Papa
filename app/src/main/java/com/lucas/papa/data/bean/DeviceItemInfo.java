package com.lucas.papa.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lucas
 * Date: 2020/9/26 17:16
 */
public class DeviceItemInfo implements Parcelable {

    private int headerImg;
    private String deviceName;
    private int signalImg;
    private String address;

    public int getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(int headerImg) {
        this.headerImg = headerImg;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getSignalImg() {
        return signalImg;
    }

    public void setSignalImg(int signalImg) {
        this.signalImg = signalImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.headerImg);
        dest.writeString(this.deviceName);
        dest.writeInt(this.signalImg);
        dest.writeString(this.address);
    }

    public DeviceItemInfo() {
    }

    protected DeviceItemInfo(Parcel in) {
        this.headerImg = in.readInt();
        this.deviceName = in.readString();
        this.signalImg = in.readInt();
        this.address = in.readString();
    }

    public static final Creator<DeviceItemInfo> CREATOR = new Creator<DeviceItemInfo>() {
        @Override
        public DeviceItemInfo createFromParcel(Parcel source) {
            return new DeviceItemInfo(source);
        }

        @Override
        public DeviceItemInfo[] newArray(int size) {
            return new DeviceItemInfo[size];
        }
    };
}
