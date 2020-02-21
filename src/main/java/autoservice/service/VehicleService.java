package autoservice.service;

import autoservice.dao.VehicleDAO;
import autoservice.domain.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleDAO vehicleDAO;

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.selectAllVehicles();
    }
}
