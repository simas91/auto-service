package autoservice.service;

import autoservice.dao.VehicleDAO;
import autoservice.domain.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleDAO vehicleDAO;

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.selectAllVehicles();
    }

    public  void addNewVehicle(Vehicle vehicle) {
        vehicleDAO.insertVehicle(UUID.randomUUID(), vehicle);
    }
}
