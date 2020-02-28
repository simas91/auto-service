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
public class Braking {

    @JsonProperty("vehicleId")
    private final UUID vehicleId;

    @JsonProperty("section")
    @NonNull
    private final int section;

    @JsonProperty("part")
    @NonNull
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

    @JsonProperty("position")
    private final String position;

    @JsonProperty("text")
    private final String info;

}
