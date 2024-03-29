package com.spring.services.map;

import com.spring.model.Speciality;
import com.spring.model.Vet;
import com.spring.services.SpecialtyService;
import com.spring.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile("default")
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>0) {
            object.getSpecialties().forEach(speciality ->{
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            } );
        }

        return super.save(object);
    }

}
