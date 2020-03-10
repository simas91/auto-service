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

    public List<Repair> getAllService(UUID id, String department, String section, String part) {
        return repairDAO.getAllService(id, department, section, part);
    }
}

