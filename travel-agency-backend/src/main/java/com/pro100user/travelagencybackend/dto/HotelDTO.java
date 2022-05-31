package com.pro100user.travelagencybackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HotelDTO {

    private Long id;

    private String name;

    private List<String> images;

    private String address;

    private CityDTO city;

    private int rating;

    private String description;

    private List<RoomDTO> rooms;

    private double price;
}
