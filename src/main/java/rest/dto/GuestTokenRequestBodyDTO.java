package rest.dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GuestTokenRequestBodyDTO {

    @JsonProperty("grant_type")
    private String grant_type;
    private String scope;

    public String getGrant_type() {
        return grant_type;
    }

    public GuestTokenRequestBodyDTO setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public GuestTokenRequestBodyDTO setScope(String scope) {
        this.scope = scope;
        return this;
    }
}
