package com.pro100user.travelagencybackend.dto;

import com.pro100user.travelagencybackend.entity.enums.Rating;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RoomDTO {

    private Long id;

    private Long hotelId;

    private double price;

    private int rating;

    private int countPeople;

    private String description;
}
