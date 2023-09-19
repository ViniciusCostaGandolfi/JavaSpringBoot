package medi.voll.api.dto.Doctor;

import medi.voll.api.model.Adress;
import medi.voll.api.model.doctor.Doctor;
import medi.voll.api.model.doctor.Specialty;



public record  GetDoctorDTO(Long id, String name, String email, String crm , String phone, Specialty specialty, Adress adress) {
    public GetDoctorDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), 
             doctor.getPhone(), doctor.getSpecialty(), doctor.getAdress());
    }
    

}
