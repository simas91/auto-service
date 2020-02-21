package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
public class Vehicle {

    @JsonProperty("vehicleId")
    private final UUID vehicleId;
    @JsonProperty("registration")
    private final String registration;
    @JsonProperty("manufacturer")
    private final String manufacturer;
    @JsonProperty("model")
    private final String model;
    @JsonProperty("year")
    private final Integer year;
    @JsonProperty("mileage")
    private final Integer mileage;

}
