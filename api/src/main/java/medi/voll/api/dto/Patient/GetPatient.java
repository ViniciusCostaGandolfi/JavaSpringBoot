package medi.voll.api.dto.Patient;

import medi.voll.api.model.Adress;
import medi.voll.api.model.Patient;

public record GetPatient(
    Long id,
    String name,
    String cpf,
    String email,
    String phone,
    Adress adress
    ) {
    public GetPatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getCpf(), patient.getEmail(), patient.getPhone(), patient.getAdress());

    }
}
