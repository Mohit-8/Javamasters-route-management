package RoutesManagement.BusRoutes.controller;

import RoutesManagement.BusRoutes.Service.Bus.BusService;
import RoutesManagement.BusRoutes.model.Bus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    @Autowired
    BusService busService;

    @PostMapping("/buses")
    public ResponseEntity<?> createBus(@RequestBody Bus bus) {
        try {
            return ResponseEntity.ok(busService.addBus(bus));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buses/{id}")
    public ResponseEntity<?> getBus(@PathVariable String id) {
        try {
            return ResponseEntity.ok(busService.getBus(id));
        } catch (Exception e) {
return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/buses/{id}")
    public ResponseEntity<?> modifyBusDetails(@PathVariable String id,
                                                     @RequestBody  Bus bus) {
        try {
            bus.setId(id);
            return ResponseEntity.ok(busService.updateBus(id, bus));
        } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/buses/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable  String id) {
        try {
            busService.deleteBus(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
