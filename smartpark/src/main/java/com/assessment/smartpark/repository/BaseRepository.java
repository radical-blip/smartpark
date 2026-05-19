package com.assessment.smartpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Entity> extends JpaRepository<Entity, String> {
    
}
