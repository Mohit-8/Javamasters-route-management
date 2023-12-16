package RoutesManagement.BusRoutes.dao.Route;

import RoutesManagement.BusRoutes.model.Route;
import RoutesManagement.BusRoutes.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteImplement implements RouteDao{
@Autowired
    RouteRepository routeRepository;

    @Override
    public Route getRoute(String id) throws Exception {
        return routeRepository.findById(id).orElseThrow(() -> new Exception("Route with id " + id + " not found"));
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Route route) throws Exception {
        getRoute(route.getId());
        return routeRepository.save(route);
    }

    @Override
    public void deleteRoute(String id) throws Exception {
        getRoute(id);
        routeRepository.deleteById(id);
    }

    @Override
    public List<Route> getAllRoutesByBusId(String busId) {
        return routeRepository.findAllByBusId(busId);
    }
}
