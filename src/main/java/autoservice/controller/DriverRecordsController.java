package autoservice.controller;

import autoservice.domain.DriverRecords;
import autoservice.service.DriverRecordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("records")
public class DriverRecordsController {

    private final DriverRecordsService driverRecordsService;

    @GetMapping
    public List<DriverRecords> getAllDriverRecords() {
        return driverRecordsService.getAllDriverRecords();
    }

    @RequestMapping("{driverId}")
    public List<DriverRecords> getAllRecordsByDriver(@PathVariable UUID driverId ) {
        return driverRecordsService.getAllRecordsByDriver(driverId);
    }

    @RequestMapping("/vehicle/{vehicleId}")
    public List<DriverRecords> getAllRecordsByVehicle(@PathVariable UUID vehicleId ) {
        return driverRecordsService.getAllRecordsByVehicle(vehicleId);
    }

}
