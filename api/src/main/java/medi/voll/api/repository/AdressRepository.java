package medi.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import medi.voll.api.model.AdressModel;



public interface AdressRepository extends JpaRepository<AdressModel, Long> {
    
}
