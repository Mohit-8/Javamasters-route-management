package RoutesManagement.BusRoutes.Service.Location;

import RoutesManagement.BusRoutes.dao.Location.LocationDao;
import RoutesManagement.BusRoutes.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImplement implements LocationService {

    @Autowired
    LocationDao locationDao;

    @Override
    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }

    @Override
    public boolean locationExists(String location) {
        return locationDao.locationExists(location);
    }
}
