package autoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@ToString
@Getter
@AllArgsConstructor
public class Mechanic {

    @JsonProperty("mechanic_id")
    private final UUID mechanicId;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("surname")
    private final String surname;

    @JsonProperty("date_of_birth")
    private final Date dateOfBirth;

    @JsonProperty("phone_number")
    private final String phoneNumber;

    @JsonProperty("date_of_start")
    private final Date dateOfStart;

    @JsonProperty("date_of_leave")
    private final Date dateOfLeave;

}
