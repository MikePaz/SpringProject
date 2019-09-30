package com.spring.services.springDataJPA;

import com.spring.model.Speciality;
import com.spring.repositories.SpecialityRepository;
import com.spring.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDjpaService implements SpecialtyService {
    private final SpecialityRepository specialityRepository;

    public SpecialtySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> optionalSpeciality = specialityRepository.findById(id);
        return optionalSpeciality.orElse(null);
    }


    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
            specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);

    }
}
