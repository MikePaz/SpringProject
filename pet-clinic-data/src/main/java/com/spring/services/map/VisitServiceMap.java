package com.spring.services.map;

import com.spring.model.Visit;
import com.spring.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("default")
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getOwner() == null
                || object.getPet().getId() == null) {
            throw new RuntimeException("invalid visit");
        }
        return  super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
