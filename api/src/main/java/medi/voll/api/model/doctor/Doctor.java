package medi.voll.api.model.doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import medi.voll.api.dto.Doctor.PostDoctorDTO;
import medi.voll.api.dto.Doctor.PutDoctorDTO;
import medi.voll.api.model.Adress;


@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private Boolean active;
    
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adress adress;


    public Doctor(PostDoctorDTO doctor) {
        this.active = true;
        this.name = doctor.name();
        this.email = doctor.email();
        this.crm = doctor.crm();
        this.specialty = doctor.specialty();
        this.phone = doctor.phone();
        this.adress = new Adress(doctor.adress());
        
    }

    public void update(PutDoctorDTO doctor) {
        this.id = doctor.id();
        this.name = doctor.name();
        this.phone = doctor.phone();
        this.adress.update(doctor.adress());
    }


    public void delete() {
        this.active = false;
    }
}
