package com.spring.services.springDataJPA;

import com.spring.model.PetType;
import com.spring.repositories.PetTypeRepository;
import com.spring.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PetTypeSDjpaService implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeSDjpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petType = new HashSet<>();
        petTypeRepository.findAll().forEach(petType::add);
        return petType;
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> OptionalPetType = petTypeRepository.findById(id);
        return OptionalPetType.orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
