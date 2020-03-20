package autoservice.service;

import autoservice.dao.DriverDAO;
import autoservice.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverService {

    public final DriverDAO driverDAO;

    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }

    public void addNewDriver(Driver driver) {
        driverDAO.addNewDriver(UUID.randomUUID(), driver);
    }

    public Driver selectDriver(UUID id) {
        return driverDAO.selectDriver(id);
    }

    public void updateDriver(UUID id, Driver driver) {
        driverDAO.updateDriver(id, driver);
    }
}
