package autoservice.service;

import autoservice.dao.DriverRecordsDAO;
import autoservice.domain.DriverRecords;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverRecordsService {

    private final DriverRecordsDAO driverRecordsDAO;

    public List<DriverRecords> getAllDriverRecords() {
        return driverRecordsDAO.getAllDriverRecords();
    }

    public List<DriverRecords> getAllRecordsByDriver(UUID driverId) {
        return driverRecordsDAO.getAllRecordsByDriver(driverId);
    }

    public List<DriverRecords> getAllRecordsByVehicle(UUID vehicleId) {
        return driverRecordsDAO.getAllRecordsByVehicle(vehicleId);
    }
}
