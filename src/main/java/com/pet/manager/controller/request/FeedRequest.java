package com.pet.manager.controller.request;

import com.pet.manager.model.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedRequest {
    private LocalTime feedTime;
    private FoodType foodType;
}
