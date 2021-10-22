package com.pet.manager.controller.response;

import com.pet.manager.model.PetType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetResponse {
    private String id;
    private String name;
    private PetType type;
}