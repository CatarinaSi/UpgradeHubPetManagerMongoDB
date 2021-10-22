package com.pet.manager.service;


import com.pet.manager.controller.response.FeedResponse;
import com.pet.manager.model.Feed;
import com.pet.manager.model.PetType;
import com.pet.manager.exception.PetNotFound;
import com.pet.manager.model.Pet;
import com.pet.manager.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepo;

    public PetService(PetRepository petRepo) {
        this.petRepo = petRepo;
    }

    public Pet findById(String id) {
        return petRepo.findById(id).orElseThrow(PetNotFound::new);
    }

    public void deleteById(String id) {
        petRepo.deleteById(id);
    }

    public List<Pet> findByType(String type) {
        return petRepo.findByType(PetType.valueOf(type));
    }

    public Pet findByName(String name) {
        return petRepo.findByName(name).orElseThrow(PetNotFound::new);
    }

    public Pet addPet(Pet pet) {
        return petRepo.save(pet);
    }

    public Pet updatePet(String id, String name, PetType type) {
        Pet pet= this.findById(id);
        pet.setName(name);
        pet.setType(type);
        return petRepo.save(pet);
    }
//
//    public List<Feed> getFeedsByPetId(String id) {
//        return
//    }

}
