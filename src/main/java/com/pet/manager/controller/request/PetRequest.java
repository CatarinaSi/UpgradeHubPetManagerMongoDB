package com.pet.manager.controller.request;

import com.pet.manager.model.PetType;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetRequest {
    private String name;
    private PetType type;
}
