package medi.voll.api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import medi.voll.api.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    @Query("SELECT d FROM DoctorModel d WHERE d.active = true")
    Page<DoctorModel> findByActiveTrue(Pageable pagiable);
}
