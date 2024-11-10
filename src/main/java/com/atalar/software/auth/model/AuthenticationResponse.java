package com.atalar.software.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AuthenticationResponse(@JsonProperty("access_token") String accessToken,
                                     @JsonProperty("refresh_token") String refreshToken) {
}
