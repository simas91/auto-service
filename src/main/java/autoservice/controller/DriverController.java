package autoservice.controller;

import autoservice.domain.Driver;
import autoservice.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("driver")
public class DriverController {

    private final DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @PostMapping()
    public void addNewDriver(@RequestBody Driver driver) {
        driverService.addNewDriver(driver);
    }

    @RequestMapping("{id}")
    public Driver selectDriver(@PathVariable UUID id) {
        return driverService.selectDriver(id);
    }

    @PostMapping("{id}")
    public void updateDriver(@PathVariable UUID id, @RequestBody Driver driver) {
        driverService.updateDriver(id, driver);
    }

}
