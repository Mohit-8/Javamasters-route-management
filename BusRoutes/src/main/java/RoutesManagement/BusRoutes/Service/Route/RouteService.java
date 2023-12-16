package RoutesManagement.BusRoutes.Service.Route;

import RoutesManagement.BusRoutes.model.Route;

import java.util.List;

public interface RouteService {
    Route getRoute(String routeId) throws Exception;
    Route createRoute(Route route) throws Exception;

    Route updateRoute(String id, Route route) throws Exception;

    void deleteRoute(String routeId) throws Exception;

    List<Route> getAllRoutesOfBus(String busNumber) throws Exception;

}
