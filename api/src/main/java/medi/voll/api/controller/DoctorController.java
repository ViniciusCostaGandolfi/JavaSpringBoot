package medi.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import medi.voll.api.dto.DoctorDTO;
import medi.voll.api.dto.GetAllDoctorDTO;
import medi.voll.api.dto.PutDoctorDTO;
import medi.voll.api.model.DoctorModel;
import medi.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private  DoctorRepository repository;

    @Transactional
    @PostMapping
    public void post(@RequestBody @Valid DoctorDTO doctor) {
        repository.save(new DoctorModel(doctor));
    }

    @GetMapping
    public Page<GetAllDoctorDTO> getAll(@PageableDefault(size=10, page=0, sort={"name"}, direction=Direction.ASC) Pageable pagiable) {
        Page<DoctorModel> listDocstors = repository.findByActiveTrue(pagiable);
        Page<GetAllDoctorDTO> pageListDoctors = listDocstors.map((doctorModel -> new GetAllDoctorDTO(doctorModel)));
        return pageListDoctors;
    }

    @GetMapping("/{id}")
    public DoctorModel get(@PathVariable @Valid Long id) {
        return this.repository.getReferenceById(id);
    }

    @Transactional
    @PutMapping
    public void put(@RequestBody @Valid PutDoctorDTO doctor) {
        DoctorModel doctorFromDataBase = repository.getReferenceById(doctor.id());
        doctorFromDataBase.update(doctor);
    }

    @Transactional
    @DeleteMapping("/final/{id}")
    public void finalDelete(@PathVariable @Valid Long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Valid Long id) {
        DoctorModel doctorFromDataBase = this.repository.getReferenceById(id);
        doctorFromDataBase.delete();
    }
    
}
