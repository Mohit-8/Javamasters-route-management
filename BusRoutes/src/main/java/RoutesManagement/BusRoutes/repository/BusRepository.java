package RoutesManagement.BusRoutes.repository;

import RoutesManagement.BusRoutes.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends MongoRepository<Bus, String> {
    Optional<Bus> findByBusNumber(String busNumber);
}
