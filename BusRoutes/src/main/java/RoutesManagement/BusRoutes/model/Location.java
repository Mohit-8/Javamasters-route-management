package RoutesManagement.BusRoutes.model;

public class Location {
    private String id;
    private String locationPlace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationPlace() {
        return locationPlace;
    }

    public void setLocationPlace(String locationPlace) {
        this.locationPlace = locationPlace;
    }

    public Location(String locationPlace) {
        this.locationPlace = locationPlace;
    }
}
