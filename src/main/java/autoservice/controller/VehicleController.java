package autoservice.controller;

import autoservice.domain.Vehicle;
import autoservice.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping
    public void addNewVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addNewVehicle(vehicle);
    }

}
