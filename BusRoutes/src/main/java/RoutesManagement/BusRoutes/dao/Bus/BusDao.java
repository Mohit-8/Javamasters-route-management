package RoutesManagement.BusRoutes.dao.Bus;

import RoutesManagement.BusRoutes.model.Bus;

import java.util.Optional;

public interface BusDao {

    Bus saveBus(Bus bus);

    Bus getBus(String id) throws Exception;

    void deleteBus(String id) throws Exception;

    Bus updateBus(Bus bus) throws Exception;
    Optional<Bus> findByBusNumber(String busNumber);
}
