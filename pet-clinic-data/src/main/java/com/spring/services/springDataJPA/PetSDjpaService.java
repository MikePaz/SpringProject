package com.spring.services.springDataJPA;

import com.spring.model.Pet;
import com.spring.repositories.PetRepository;
import com.spring.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDjpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
       Set<Pet> pets = new HashSet<>();
       petRepository.findAll().forEach(pets::add);
       return pets;
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> optionalPets = petRepository.findById(id);
        return optionalPets.orElse(null);

    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
