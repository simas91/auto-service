package autoservice.controller;

import autoservice.domain.Repair;
import autoservice.service.RepairService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("service")
public class RepairController {

    private final RepairService repairService;

    @GetMapping
    public List<Repair> getAllRepairs() {
        return repairService.getAllRepairs();
    }

    @RequestMapping("{vehicleId}/{department}/{section}/{part}")
    public List<Repair> getSpecificVehicleRepair(@PathVariable UUID vehicleId, @PathVariable int department, @PathVariable int section, @PathVariable int part) {
        return repairService.getSpecificVehicleRepair(vehicleId, department, section, part);
    }

    @RequestMapping("mechanic/{mechanicId}/{department}/{section}/{part}")
    public List<Repair> getSpecificMechanicRepair(@PathVariable UUID mechanicId, @PathVariable int department, @PathVariable int section, @PathVariable int part) {
        return repairService.getSpecificMechanicRepair(mechanicId, department, section, part);
    }

    @RequestMapping("{mechanicId}")
    public List<Repair> getAllSelectedMechanicRepair(@PathVariable UUID mechanicId) {
        return repairService.getAllSelectedMechanicRepair(mechanicId);
    }

    @PostMapping
    public void addNewRepair (@RequestBody Repair repair) {
        repairService.addNewRepair(repair);
    }

}

