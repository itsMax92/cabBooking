package com.cabBook.cabBook.model;

import com.opencsv.bean.CsvBindByName;

public class Cab {

    private Integer locationId;
    @CsvBindByName(column = "driverName")
    private String driverName;
    @CsvBindByName(column = "contactNumber")
    private String contactNumber;
    @CsvBindByName(column = "vehicleType")
    private String vehicleType;
    @CsvBindByName(column = "vehicleNumber")
    private String vehicleNumber;
    @CsvBindByName(column = "isAvailable")
    private Boolean isAvailable;

    public Cab() {
    }

    public Cab(String driverName, String contactNumber, String vehicleType, String vehicleNumber, boolean isAvailable) {
        this.driverName = driverName;
        this.contactNumber = contactNumber;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = isAvailable;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "locationId=" + locationId +
                ", driverName='" + driverName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
