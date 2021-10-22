package com.pet.manager.controller.response;

import com.pet.manager.model.FoodType;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedResponse {
    private int id;
    private LocalTime feedTime;
    private FoodType foodType;
}