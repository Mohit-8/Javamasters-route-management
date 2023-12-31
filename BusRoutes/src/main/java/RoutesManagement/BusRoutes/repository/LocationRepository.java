package RoutesManagement.BusRoutes.repository;

import RoutesManagement.BusRoutes.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location,String> {

    Location getLocationByLocationPlace(String locationName);
}
