package autoservice.controller;

import autoservice.domain.Mechanic;
import autoservice.service.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
