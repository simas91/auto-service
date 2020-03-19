package autoservice.service;

import autoservice.RegistrationValidator;
import autoservice.dao.VehicleDAO;
import autoservice.domain.Vehicle;
import autoservice.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleDAO vehicleDAO;
    private final RegistrationValidator registrationValidator;

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.selectAllVehicles();
    }

    public  void addNewVehicle(Vehicle vehicle) {

        if(isRegistrationNotTaken(vehicle) & isRegistrationValid(vehicle)) {
            vehicleDAO.insertVehicle(UUID.randomUUID(), vehicle);
        }
    }

    public Vehicle selectVehicle(UUID id) {
        return vehicleDAO.selectVehicle(id);
    }

    public void updateVehicle(UUID id, Vehicle vehicle) {

        if(isRegistrationValid(vehicle)){
            vehicleDAO.updateVehicle(id, vehicle);
        }
    }



    private boolean isRegistrationNotTaken(Vehicle vehicle) {

        if (vehicleDAO.isRegistrationTaken(vehicle.getRegistration())) {
            throw new ApiRequestException("Registration number: " + vehicle.getRegistration() + " already exists");
        }

        return true;
    }

    private boolean isRegistrationValid(Vehicle vehicle) {

        if (!registrationValidator.test(vehicle.getRegistration())) {
            throw new ApiRequestException(vehicle.getRegistration() + " is not valid registration number");
        }
        return true;
    }
}
