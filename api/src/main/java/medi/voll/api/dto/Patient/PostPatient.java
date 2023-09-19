package medi.voll.api.dto.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.voll.api.model.Adress;

public record PostPatient(
    @NotBlank
    String name,
    
    @NotBlank @Pattern(regexp = "\\d{11, 20}")
    String cpf,

    @NotBlank @Email
    String email,

    @NotBlank @Pattern(regexp = "\\d{11, 20}")
    String phone,

    @NotNull @Valid
    Adress adress
) {
    
}
