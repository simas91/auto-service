package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
public class Repair {

    @JsonProperty("vehicleId")
    @NotBlank
    private final UUID vehicleId;

    @JsonProperty("mechanicId")
    private final UUID mechanicId;

    @JsonProperty("department")
    @NotNull
    private final int department;

    @JsonProperty("section")
    @NotNull
    private final int section;

    @JsonProperty("part")
    @NotNull
    private final int part;

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
