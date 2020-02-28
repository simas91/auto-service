package autoservice.controller;

import autoservice.domain.Braking;
import autoservice.service.BrakingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("braking")
public class BrakingController {

    private final BrakingService brakingService;

    @RequestMapping("{id}")
    public Braking getAllBraking(@PathVariable UUID id) {
        return brakingService.getAllBraking(id);
    }

}
