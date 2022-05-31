package com.pro100user.travelagencybackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CityDTO {

    private Long id;

    private Long countryId;

    private String country;

    private String name;
}
