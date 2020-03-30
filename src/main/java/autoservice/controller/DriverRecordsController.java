package autoservice.controller;

import autoservice.domain.DriverRecords;
import autoservice.service.DriverRecordsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addNewRecord (@RequestBody DriverRecords driverRecords) {
        driverRecordsService.addNewRepair(driverRecords);
    }
}
