package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository
        extends JpaRepository<Owner, String> {

}