package com.pro100user.travelagencybackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CountryDTO {

    private Long id;

    private String name;
}
