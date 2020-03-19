package autoservice.service;

import autoservice.dao.MechanicDAO;
import autoservice.domain.Mechanic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MechanicService {

    private final MechanicDAO mechanicDAO;

    public List<Mechanic> getAllMechanics() {
        return mechanicDAO.getAllMechanics();
    }

    public void addNewMechanic(Mechanic mechanic) {
        mechanicDAO.addNewMechanic(UUID.randomUUID(), mechanic);
    }
}
