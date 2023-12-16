package RoutesManagement.BusRoutes.Service.Location;
import java.util.List;

import RoutesManagement.BusRoutes.model.Location;

public interface LocationService {
    List<Location> getAllLocations();

    boolean locationExists(String locationId);
}
