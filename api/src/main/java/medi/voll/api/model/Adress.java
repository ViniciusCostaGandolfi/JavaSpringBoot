package medi.voll.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import medi.voll.api.dto.Adress.PostAdressDTO;

@Table(name = "adresses")
@Entity(name = "Adress")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street; 
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;

    public Adress(PostAdressDTO adress) {
        this.street = adress.street();
        this.number = adress.number();
        this.complement = adress.complement();
        this.neighborhood = adress.neighborhood();
        this.city = adress.city();
        this.uf = adress.uf();
    }

    public void update(PostAdressDTO adress) {
        this.street = adress.street();
        this.number = adress.number();
        this.complement = adress.complement();
        this.neighborhood = adress.neighborhood();
        this.city = adress.city();
        this.uf = adress.uf();
    }
}
