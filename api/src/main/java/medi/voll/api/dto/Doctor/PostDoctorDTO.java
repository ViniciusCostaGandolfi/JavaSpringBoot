package medi.voll.api.dto.Doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.voll.api.dto.Adress.PostAdressDTO;
import medi.voll.api.model.doctor.Specialty;

public record PostDoctorDTO(
    @NotBlank
    String name, 

    @NotBlank @Email
    String email, 

    @NotBlank @Pattern(regexp = "\\d{11, 20}")
    String phone,

    @NotBlank @Pattern(regexp = "\\d{4, 6}")
    String crm,  
    
    @NotNull
    Specialty specialty, 

    @NotNull @Valid
    PostAdressDTO adress
    ) {
    
}
