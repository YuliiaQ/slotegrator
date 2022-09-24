package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterNewPlayerResponseBodyDTO {
    private String id;
    private String timeZoneId;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String gender;
    private String phoneNumber;
    private String birthdate;
    private String bonusesAllowed;
    private String isVerified;
}
