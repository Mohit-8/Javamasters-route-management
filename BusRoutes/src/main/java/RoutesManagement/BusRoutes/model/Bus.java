package RoutesManagement.BusRoutes.model;

public class Bus {
    private String id;

    private String busType;

    private String busNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Bus(String id, String busType, String busNumber, String name) {
        this.id = id;
        this.busType = busType;
        this.busNumber = busNumber;
        this.name = name;
    }

}