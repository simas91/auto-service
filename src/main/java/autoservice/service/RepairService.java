package autoservice.service;

import autoservice.dao.RepairDAO;
import autoservice.domain.Repair;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RepairService {

    private final RepairDAO repairDAO;

    public List<Repair> getSpecificVehicleRepair(UUID vehicleId, int department, int section, int part) {
        return repairDAO.getSpecificVehicleRepair(vehicleId, department, section, part);
    }

    public List<Repair> getSpecificMechanicRepair(UUID mechanicId, int department, int section, int part) {
        return repairDAO.getSpecificMechanicRepair(mechanicId, department, section, part);
    }

    public List<Repair> getAllSelectedMechanicRepair(UUID mechanicId) {
        return repairDAO.getAllSelectedMechanicRepair(mechanicId);
    }

    public void addNewRepair(Repair repair) {
        repairDAO.insertNewRepair(repair);
    }

    public List<Repair> getAllRepairs() {
        return repairDAO.getAllRepairs();
    }
}

