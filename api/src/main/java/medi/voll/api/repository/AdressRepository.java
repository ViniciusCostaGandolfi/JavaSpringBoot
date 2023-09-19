package medi.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import medi.voll.api.model.Adress;



public interface AdressRepository extends JpaRepository<Adress, Long> {
    
}
