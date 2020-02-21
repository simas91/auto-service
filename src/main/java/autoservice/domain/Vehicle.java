package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private final String manufacturer;

    @JsonProperty("model")
    @NotBlank
    private final String model;

    @JsonProperty("year")
    @NonNull
    private final Integer year;

    @JsonProperty("mileage")
    @NonNull
    private final Integer mileage;
}
