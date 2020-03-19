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

    @RequestMapping("{department}/{section}/{part}/{id}")
    public List<Repair> getAllService(@PathVariable UUID id, @PathVariable String department, @PathVariable String section, @PathVariable String part) {
        return repairService.getAllService(id, department, section, part);
    }

    @PostMapping
    public void addNewRepair (@RequestBody Repair repair) {
        repairService.addNewRepair(repair);
    }

}

