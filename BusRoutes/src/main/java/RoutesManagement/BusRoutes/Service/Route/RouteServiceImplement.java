package RoutesManagement.BusRoutes.Service.Route;

import RoutesManagement.BusRoutes.Service.Location.LocationService;
import RoutesManagement.BusRoutes.dao.Bus.BusDao;
import RoutesManagement.BusRoutes.dao.Route.RouteDao;
import RoutesManagement.BusRoutes.model.Bus;
import RoutesManagement.BusRoutes.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImplement implements RouteService{
    @Autowired
    RouteDao routeDaoService;
    @Autowired
    BusDao busDao;
    @Autowired
    LocationService locationService;

    @Override
    public Route createRoute(Route route) throws Exception {
        validateCreateRouteRequest(route);
        return routeDaoService.createRoute(route);
    }


    @Override
    public Route getRoute(String routeId) throws Exception {
        return routeDaoService.getRoute(routeId);
    }

    @Override
    public Route updateRoute(String id, Route route) throws Exception {
        route.setId(id);
        validateUpdateRouteRequest(route);
        return routeDaoService.updateRoute(route);

    }


    @Override
    public void deleteRoute(String routeId) throws Exception {
        routeDaoService.deleteRoute(routeId);
    }

    @Override
    public List<Route> getAllRoutesOfBus(String busNumber) throws Exception {
        Optional<Bus> bus = busDao.findByBusNumber(busNumber);
        String busId;
        if (bus.isPresent())
            busId = bus.get().getId();
        else
            throw new Exception("Bus with reg number " + busNumber + " does not exist");
        return routeDaoService.getAllRoutesByBusId(busId);
    }

    private void validateCreateRouteRequest(Route route) throws Exception {
        busDao.getBus(route.getBusId());
        checkLocation(route.getSource());
        checkLocation(route.getDestination());
        List<Route> routeEntities = routeDaoService.getAllRoutesByBusId(route.getBusId());
        if (route.getStartTime().isAfter(route.getEndTime()) || route.getStartTime().equals(route.getEndTime())) {
            throw new Exception("Start time cannot be after/equal to end time");
        }

        boolean conflictExists = routeEntities.stream().anyMatch(existingRoute ->
                existingRoute.getWeekday().equals(route.getWeekday()) &&
                        ((timeEqualOrAfter(route.getStartTime(), existingRoute.getStartTime()) && timeEqualOrBefore(route.getStartTime(), existingRoute.getEndTime())) ||
                                (timeEqualOrAfter(route.getEndTime(), existingRoute.getStartTime()) && timeEqualOrBefore(route.getEndTime(), existingRoute.getEndTime())))
        );
        if (conflictExists) {
            throw new Exception("Route already exists for the given time slot");
        }

    }

    private void checkLocation(String location) throws Exception {
        if (!locationService.locationExists(location)) {
            throw new Exception("Location " + location + "does not exist");
        }
    }

    private boolean timeEqualOrAfter(LocalTime a, LocalTime b) {
        return a.equals(b) || a.isAfter(b);
    }

    private boolean timeEqualOrBefore(LocalTime a, LocalTime b) {
        return a.equals(b) || a.isBefore(b);
    }

    private void validateUpdateRouteRequest(Route route) throws Exception {
        busDao.getBus(route.getBusId());
        checkLocation(route.getSource());
        checkLocation(route.getDestination());
        List<Route> routeEntities = routeDaoService.getAllRoutesByBusId(route.getBusId());
        boolean conflictExists = routeEntities.stream().anyMatch(existingRoute ->
                (!existingRoute.getId().equals(route.getId())) &&
                        existingRoute.getWeekday().equals(route.getWeekday()) &&
                        ((route.getStartTime().isAfter(existingRoute.getStartTime()) && route.getStartTime().isBefore(existingRoute.getEndTime())) ||
                                (route.getEndTime().isAfter(existingRoute.getStartTime()) && route.getEndTime().isBefore(existingRoute.getEndTime())))
        );
        if (conflictExists) {
            throw new Exception("Route already exists for the given time slot");
        }
    }

}
