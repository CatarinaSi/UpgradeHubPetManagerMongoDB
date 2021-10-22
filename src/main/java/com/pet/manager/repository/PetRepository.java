package com.pet.manager.repository;

import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
    List<Pet> findByType(PetType type);

    Optional<Pet> findByName(String name);
}