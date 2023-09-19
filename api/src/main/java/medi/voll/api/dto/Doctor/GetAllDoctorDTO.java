package medi.voll.api.dto.Doctor;

import medi.voll.api.model.doctor.Doctor;
import medi.voll.api.model.doctor.Specialty;

public record GetAllDoctorDTO(Long id, String name, String email, String crm, Specialty specialty) {
    public GetAllDoctorDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
