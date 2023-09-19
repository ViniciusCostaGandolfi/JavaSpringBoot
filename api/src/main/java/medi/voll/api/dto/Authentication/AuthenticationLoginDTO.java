package medi.voll.api.dto.Authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationLoginDTO(
    @Email @NotBlank
    String email, 
    @NotBlank
    String password
    ) {

}


