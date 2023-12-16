package RoutesManagement.BusRoutes.dao.Route;
import RoutesManagement.BusRoutes.model.Route;
import java.util.List;

public interface RouteDao {
    Route getRoute(String routeId) throws Exception;

    Route createRoute(Route route);

    Route updateRoute(Route route) throws Exception;

    void deleteRoute(String id) throws Exception;

    List<Route> getAllRoutesByBusId(String busId);

}
