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
public class Driver {

    @JsonProperty("driver_id")
    private final UUID driverId;

    @JsonProperty("name")
    @NotBlank
    private final String name;

    @JsonProperty("surname")
    @NotBlank
    private final String surname;

    @JsonProperty("date_of_birth")
    @NotBlank
    private final Date dateOfBirth;

    @JsonProperty("phone_number")
    @NotBlank
    private final String phoneNumber;

    @JsonProperty("date_of_start")
    @NotBlank
    private final Date dateOfStart;

    @JsonProperty("date_of_leave")
    @NotBlank
    private final Date dateOfLeave;

    @JsonProperty("miles_done")
    private final Integer milesDone;

    @JsonProperty("hours_done")
    private final Integer hoursDone;

}
