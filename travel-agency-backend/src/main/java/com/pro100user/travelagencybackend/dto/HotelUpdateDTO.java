package com.pro100user.travelagencybackend.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HotelUpdateDTO {

    @NotNull
    @Min(value = 1, message = "Hotel id cannot be less than 1")
    private Long id;

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
