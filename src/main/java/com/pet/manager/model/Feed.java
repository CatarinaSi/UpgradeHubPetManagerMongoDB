package com.pet.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.manager.controller.request.FeedRequest;
import com.pet.manager.controller.response.FeedResponse;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feed {
    private int id;
    private LocalTime feedTime;
    private FoodType foodType;

}
