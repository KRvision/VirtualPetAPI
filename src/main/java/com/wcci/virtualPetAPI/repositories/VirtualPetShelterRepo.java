package com.wcci.virtualPetAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.VirtualPetShelter;

@Repository
public interface VirtualPetShelterRepo extends JpaRepository<VirtualPetShelter, Long> {
    Optional<VirtualPetShelter> findByShelterName(String shelterName);
}