package medi.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import medi.voll.api.dto.Doctor.PostDoctorDTO;
import medi.voll.api.dto.Doctor.GetAllDoctorDTO;
import medi.voll.api.dto.Doctor.GetDoctorDTO;
import medi.voll.api.dto.Doctor.PutDoctorDTO;
import medi.voll.api.model.doctor.Doctor;
import medi.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private  DoctorRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity<GetDoctorDTO> post(@RequestBody @Valid PostDoctorDTO doctorDTO, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(doctorDTO);
        repository.save(doctor);
        var uri = uriBuilder.path("/doctors/{id}")
            .buildAndExpand(doctor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new GetDoctorDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<GetAllDoctorDTO>> getAll(@PageableDefault(size=10, page=0, sort={"name"}, direction=Direction.ASC) Pageable pagiable) {
        Page<Doctor> listDocstors = repository.findByActiveTrue(pagiable);
        Page<GetAllDoctorDTO> pageListDoctors = listDocstors.map((doctorModel -> new GetAllDoctorDTO(doctorModel)));
        return ResponseEntity.ok(pageListDoctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable @Valid Long id) {
        var doctorFromDataBase = this.repository.getReferenceById(id);
        return ResponseEntity.ok(doctorFromDataBase);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<GetDoctorDTO> put(@RequestBody @Valid PutDoctorDTO doctor) {
        Doctor doctorFromDataBase = repository.getReferenceById(doctor.id());
        doctorFromDataBase.update(doctor);
        return ResponseEntity.ok(new GetDoctorDTO(doctorFromDataBase));
    }

    @Transactional
    @DeleteMapping("/final/{id}")
    public ResponseEntity<String> finalDelete(@PathVariable @Valid Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable @Valid Long id) {
        Doctor doctorFromDataBase = this.repository.getReferenceById(id);
        doctorFromDataBase.delete();
        return ResponseEntity.noContent().build();
    }
    
}
