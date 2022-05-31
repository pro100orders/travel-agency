package com.pro100user.travelagencybackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserUpdateDTO {

    @JsonIgnore
    private Long id;

    @NotNull
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 64, message = "Name must be between 8 and 64")
    private String name;

    @NotNull
    @NotBlank(message = "Surname cannot be empty")
    @Size(max = 64, message = "Surname must be up to 64")
    private String surname;

    @NotNull
    @Email(message = "Email does not match format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotNull
    @NotBlank(message = "Phone cannot be empty")
    @Size(max = 64, message = "Phone must be up to 64")
    private String phone;

    @NotNull
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64")
    private String password;

    @NotNull
    @NotBlank(message = "New password cannot be empty")
    @Size(min = 8, max = 64, message = "New password must be between 8 and 64")
    private String newPassword;
}
