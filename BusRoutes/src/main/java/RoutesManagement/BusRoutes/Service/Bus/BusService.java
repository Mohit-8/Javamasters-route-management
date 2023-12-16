package RoutesManagement.BusRoutes.Service.Bus;

import RoutesManagement.BusRoutes.model.Bus;

public interface BusService {

    Bus getBus(String id) throws Exception;

    Bus addBus(Bus bus) throws Exception;

    Bus updateBus(String id, Bus bus) throws Exception;

    void deleteBus(String id) throws Exception;
}
