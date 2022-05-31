package com.pro100user.travelagencybackend.dto;

import com.pro100user.travelagencybackend.entity.Hotel;
import com.pro100user.travelagencybackend.entity.enums.Rating;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RoomCreateDTO {

    @NotNull
    @Min(value = 1, message = "Hotel id cannot be less than 1")
    private Long hotelId;

    @NotNull
    @Min(value = 0, message = "Price cannot be less than 0")
    private double price;

    @NotNull
    @Min(value = 0, message = "Rating cannot be less than 0")
    private int rating;

    @NotNull
    @Min(value = 1, message = "Count people cannot be less than 1")
    private int countPeople;

    @NotNull
    @Size(max = 255, message = "Description must be up to 255 characters long")
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull
    @Min(value = 1, message = "Count id cannot be less than 1")
    private Long count;
}
