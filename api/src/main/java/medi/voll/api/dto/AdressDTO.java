package medi.voll.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AdressDTO(
    
    @NotBlank
    String street, 
    
    @NotBlank
    String number, 
    
    String complement,              
    
    @NotBlank
    String neighborhood, 
    
    @NotBlank
    String city, 
    
    @NotBlank
    String uf 
    
    ) {
    
}
