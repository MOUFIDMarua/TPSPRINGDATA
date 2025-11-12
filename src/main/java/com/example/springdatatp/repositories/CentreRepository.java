package com.example.springdatatp.repositories;


import com.example.springdatatp.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "centres")
public interface CentreRepository extends JpaRepository<Centre, Long> {
}
