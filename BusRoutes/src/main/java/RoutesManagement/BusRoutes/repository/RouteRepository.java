package RoutesManagement.BusRoutes.repository;

import RoutesManagement.BusRoutes.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends MongoRepository<Route,String> {
    List<Route> findAllByBusId(String busId);
}
