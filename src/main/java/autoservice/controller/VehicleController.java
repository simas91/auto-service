package autoservice.controller;

import autoservice.domain.Vehicle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return List.of(
                new Vehicle(UUID.randomUUID(),
                        "FD60LWM",
                        "Honda",
                        "Civic",
                        2011,                        91300),
                new Vehicle(UUID.randomUUID(),
                        "AE04SWJ",
                        "Yamaha",
                        "R1",
                        2004,
                        15233)
        );
    }

}
