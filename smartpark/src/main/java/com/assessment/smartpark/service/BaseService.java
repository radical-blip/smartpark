package com.assessment.smartpark.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.assessment.smartpark.model.table.BaseEntity;
import com.assessment.smartpark.repository.BaseRepository;

public abstract class BaseService<Entity extends BaseEntity, Repository extends BaseRepository<Entity>> {
    
    @Autowired
    Repository repository;
    
    public Class<Entity> getBaseClass() {
        return (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    public Optional<Entity> findOptionalById(String id){
        return repository.findById(id);
    }

    public Entity findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Entity entity) {
        repository.deleteById(entity.getId());
    }

    public List<Entity> findAll() {
        return repository.findAll();
    }

}
