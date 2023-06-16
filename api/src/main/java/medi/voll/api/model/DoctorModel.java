package medi.voll.api.model;

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
import medi.voll.api.dto.DoctorDTO;
import medi.voll.api.dto.PutDoctorDTO;


@Table(name = "doctors")
@Entity(name = "DoctorModel")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorModel {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String cellphone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private Boolean active;
    
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AdressModel adress;


    public DoctorModel(DoctorDTO doctor) {
        this.active = true;
        this.name = doctor.name();
        this.email = doctor.email();
        this.crm = doctor.crm();
        this.specialty = doctor.specialty();
        this.cellphone = doctor.cellphone();
        this.adress = new AdressModel(doctor.adress());
        
    }

    public void update(PutDoctorDTO doctor) {
        this.id = doctor.id();
        this.name = doctor.name();
        this.cellphone = doctor.cellphone();
        this.adress.update(doctor.adress());
    }


    public void delete() {
        this.active = false;
    }
}
