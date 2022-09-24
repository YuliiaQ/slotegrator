package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorizationUnderPlayerResponseBodyDTO {
    private String token_type;
    private String expires_in;
    private String access_token;
    private String refresh_token;
}
