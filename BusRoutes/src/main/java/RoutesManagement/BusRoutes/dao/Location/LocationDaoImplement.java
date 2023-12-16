package RoutesManagement.BusRoutes.dao.Location;

import RoutesManagement.BusRoutes.model.Location;
import RoutesManagement.BusRoutes.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationDaoImplement implements LocationDao{
    @Autowired
    LocationRepository locationRepository;

    public LocationDaoImplement(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        if(locationRepository.count()==0)
        {
            locationRepository.save(new Location("Delhi"));
            locationRepository.save(new Location("Chandigarh"));
            locationRepository.save(new Location("Patna"));
            locationRepository.save(new Location("Jaipur"));
            locationRepository.save(new Location("Bangalore"));
            locationRepository.save(new Location("Udaipur"));
            locationRepository.save(new Location("Chennai"));

        }
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public boolean locationExists(String locationPlace) {
        return locationRepository.getLocationByLocationPlace(locationPlace)!=null;
    }

}
