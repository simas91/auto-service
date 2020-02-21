package autoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Vehicle {

    private final UUID vehicleId;
    private final String registration;
    private final String manufacturer;
    private final String model;
    private final Integer year;
    private final Integer mileage;

}
