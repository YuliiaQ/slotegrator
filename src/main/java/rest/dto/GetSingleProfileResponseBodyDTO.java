package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetSingleProfileResponseBodyDTO {

    private String id;
    private String country_id;
    private String timezone_id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String gender;
    private String phone_number;
    private String birthdate;
    private String bonuses_allowed;
    private String is_verified;

}
