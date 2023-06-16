package medi.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.voll.api.model.Specialty;

public record DoctorDTO(
    @NotBlank
    String name, 

    @NotBlank @Email
    String email, 

    @NotBlank @Pattern(regexp = "\\d{11, 20}")
    String cellphone,

    @NotBlank @Pattern(regexp = "\\d{4, 6}")
    String crm,  
    
    @NotNull
    Specialty specialty, 

    @NotNull @Valid
    AdressDTO adress
    ) {
    
}
