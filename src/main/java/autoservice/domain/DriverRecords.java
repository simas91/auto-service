package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
public class DriverRecords {

    @JsonProperty("vehicleId")
    @NotBlank
    private final UUID vehicleId;

    @JsonProperty("driverId")
    @NotBlank
    private final UUID driverId;

    @JsonProperty("dateOfStart")
    private final Date dateOfStart;

    @JsonProperty("dateOfFinish")
    private final Date dateOfFinish;

    @JsonProperty("milesAtStart")
    private final int milesAtStart;

    @JsonProperty("milesAtFinish")
    private final int milesAtFinish;

    @JsonProperty("milesDone")
    private final int milesDone;

    @JsonProperty("info")
    private final String info;

}
