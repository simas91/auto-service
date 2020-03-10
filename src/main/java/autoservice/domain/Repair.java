package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
public class Repair {

    @JsonProperty("vehicleId")
    private final UUID vehicleId;

    @JsonProperty("department")
    @NotBlank
    private final String department;

    @JsonProperty("section")
    @NotBlank
    private final String section;

    @JsonProperty("part")
    @NotBlank
    private final String part;

    @JsonProperty("dateOfService")
    @NotBlank
    private final Date dateOfService;

    @JsonProperty("dateOfExpiration")
    private final Date dateOfExpiration;

    @JsonProperty("milesOfService")
    @NonNull
    private final int milesOfService;

    @JsonProperty("milesOfExpiration")
    private final int milesOfExpiration;

    @JsonProperty("positionOrQuantity")
    private final String positionOrQuantity;

    @JsonProperty("text")
    private final String info;

}
