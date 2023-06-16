package medi.voll.api.dto;

import medi.voll.api.model.DoctorModel;
import medi.voll.api.model.Specialty;

public record GetAllDoctorDTO(Long id, String name, String email, String crm, Specialty specialty) {
    public GetAllDoctorDTO(DoctorModel doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
