package com.example.hybris.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OAuthResponseDTO {

    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;
}
