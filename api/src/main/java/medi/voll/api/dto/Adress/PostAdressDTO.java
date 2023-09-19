package medi.voll.api.dto.Adress;

import jakarta.validation.constraints.NotBlank;

public record PostAdressDTO(
    
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
