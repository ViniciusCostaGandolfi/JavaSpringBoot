package medi.voll.api.dto.Doctor;

import jakarta.validation.constraints.NotNull;
import medi.voll.api.dto.Adress.PostAdressDTO;

public record PutDoctorDTO(
    @NotNull Long id, 
    String name, 
    String phone, 
    PostAdressDTO adress
    ) {
    
}
