package com.pro100user.travelagencybackend.dto;

import com.pro100user.autoservicebackend.entity.enums.Sex;
import com.pro100user.travelagencybackend.entity.enums.Sex;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private Sex sex;
}
