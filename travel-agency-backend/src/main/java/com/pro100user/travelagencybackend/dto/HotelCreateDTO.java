package com.pro100user.travelagencybackend.dto;

import com.pro100user.travelagencybackend.entity.City;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HotelCreateDTO {

    @NotNull
    @Size(max = 64, message = "Name must be up to 64 characters long")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull
    @Size(max = 255, message = "Address must be up to 255 characters long")
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotNull
    @Min(value = 1, message = "City id cannot be less than 1")
    private Long cityId;

    @NotNull
    @Min(value = 0, message = "Rating cannot be less than 0")
    private int rating;

    @NotNull
    @Size(max = 255, message = "Description must be up to 255 characters long")
    @NotBlank(message = "Description cannot be empty")
    private String description;
}
