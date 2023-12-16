package RoutesManagement.BusRoutes.controller;

import RoutesManagement.BusRoutes.Service.Route.RouteService;
import RoutesManagement.BusRoutes.model.Route;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RouteController {

    @Autowired
    RouteService routeService;

    @GetMapping("/route/{id}")
    public ResponseEntity<?> getRoute(String id) {

        try {
            return ResponseEntity.ok(routeService.getRoute(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/route")
    public ResponseEntity<?> getAllRoutesOfBus(@RequestParam String busNumber) {

        try {
            return ResponseEntity.ok(routeService.getAllRoutesOfBus(busNumber));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/route")
    public ResponseEntity<?> createRoute( @RequestBody Route route) {
        try {
            return ResponseEntity.ok(routeService.createRoute(route));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/route/{id}")
    public ResponseEntity<?> updateRoute(String id, @RequestBody  Route route) {
        try {
            return ResponseEntity.ok(routeService.updateRoute(id, route));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/route/{id}")
    public ResponseEntity<?> deleteRoute(String id) {

        try {
            routeService.deleteRoute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
