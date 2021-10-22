package com.pet.manager.controller;

import com.pet.manager.controller.request.FeedRequest;
import com.pet.manager.controller.request.PetRequest;
import com.pet.manager.controller.response.FeedResponse;
import com.pet.manager.controller.response.PetResponse;
import com.pet.manager.exception.PetNotFound;
import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PetController {
    public final PetService petServ;

    public PetController(PetService petServ) {
        this.petServ = petServ;
    }

    @GetMapping("/pets-id/{id}")
    public PetResponse getPetById(@PathVariable(value = "id") String id) {
        Pet pet = petServ.findById(id);
        return new PetResponse(pet.getId(), pet.getName(), pet.getType());
    }

    @DeleteMapping("/pets")
    public void deleteById(@PathVariable(value = "id") String id) {
        petServ.deleteById(id);

    }

    @GetMapping("/pets-type/{type}")
    public List<PetResponse> getPetByType(@PathVariable(value = "type") String type) {
        List<Pet> petList = petServ.findByType(type);
        List<PetResponse> petResponseList = new ArrayList<>();
        for (Pet pet : petList) {
            petResponseList.add(new PetResponse(pet.getId(), pet.getName(), pet.getType()));
        }
        return petResponseList;
    }

    @GetMapping("/pets-name/{name}")
    public PetResponse getPetByName(@PathVariable(value = "name") String name) {
        Pet pet = petServ.findByName(name);
        return new PetResponse(pet.getId(), pet.getName(), pet.getType());
    }
    @PostMapping("/pets")
    public PetResponse addPet(@RequestBody PetRequest petRequest){
        Pet pet = petServ.addPet(Pet.builder()
                .name(petRequest.getName())
                .type(petRequest.getType())
                .build()
        );
        return new PetResponse(pet.getId(), pet.getName(), pet.getType());
    }

    @PutMapping("/pets/{id}")
    public PetResponse updatepet(@RequestBody PetRequest petRequest,@PathVariable(value="id")String id){
        Pet pet =petServ.updatePet(
                id,
                petRequest.getName(),
                petRequest.getType()
        );
        return new PetResponse(pet.getId(), pet.getName(), pet.getType());
    }
    @GetMapping("/pets/{id}/feed")
    public List<FeedResponse> getPetByFeed(@PathVariable(value="id")String id){
        List<Feed> feedList = petServ.getFeedsByPetId;
        List<FeedResponse> FeedResponseList = new ArrayList<>();
        for (Feed feed : feedList) {
                FeedResponseList.add(new FeedResponse(feed.getId(), feed.getFeedTime(), feed.getFoodType()));
        }
        return FeedResponseList;
    }

}

