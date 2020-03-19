package autoservice.controller;

import autoservice.domain.Vehicle;
import autoservice.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("{id}")
    public Vehicle selectVehicle(@PathVariable UUID id) {
        return vehicleService.selectVehicle(id);
    }

    @PostMapping("{id}")
    public void updateVehicle(@PathVariable UUID id, @RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(id, vehicle);
    }

}
