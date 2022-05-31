package com.pro100user.travelagencybackend.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderCreateDTO {

    @NotNull
    @Min(value = 1, message = "Room id cannot be less than 1")
    private Long roomId;

    @NotNull
    private LocalDate startAt;

    @NotNull
    private LocalDate endAt;
}
