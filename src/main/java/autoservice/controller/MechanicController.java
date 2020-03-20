package autoservice.controller;

import autoservice.domain.Mechanic;
import autoservice.service.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("mechanic")
public class MechanicController {

    private final MechanicService mechanicService;

    @GetMapping
    public List<Mechanic> getAllMechanics() {
        return mechanicService.getAllMechanics();
    }

    @PostMapping()
    public void addNewMechanic(@RequestBody Mechanic mechanic) {
        mechanicService.addNewMechanic(mechanic);
    }

    @RequestMapping("{id}")
    public Mechanic selectMechanic(@PathVariable UUID id) {
        return mechanicService.selectMechanic(id);
    }

    @PostMapping("{id}")
    public void updateMechanic(@PathVariable UUID id, @RequestBody Mechanic mechanic) {
        mechanicService.updateMechanic(id, mechanic);
    }

}
