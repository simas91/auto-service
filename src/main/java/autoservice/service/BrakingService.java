package autoservice.service;

import autoservice.dao.BrakingDAO;
import autoservice.domain.Braking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrakingService {

    private final BrakingDAO brakingDAO;

    public Braking getAllBraking(UUID id) {
        return brakingDAO.selectAllBraking(id);
    }
}
