package RoutesManagement.BusRoutes.dao.Location;

import RoutesManagement.BusRoutes.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocationDao {
     List<Location> getAllLocations() ;

  boolean locationExists(String locationId);

}
