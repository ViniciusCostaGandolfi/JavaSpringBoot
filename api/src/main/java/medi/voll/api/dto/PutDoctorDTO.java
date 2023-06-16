package medi.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record PutDoctorDTO(
    @NotNull Long id, 
    String name, 
    String cellphone, 
    AdressDTO adress
    ) {
    
}
