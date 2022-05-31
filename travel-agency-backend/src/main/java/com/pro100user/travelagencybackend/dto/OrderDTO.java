package com.pro100user.travelagencybackend.dto;

import com.pro100user.travelagencybackend.entity.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDTO {

    private Long id;

    private UserDTO user;

    private RoomDTO room;

    private Status status;

    private double price;

    private LocalDate startAt;

    private LocalDate endAt;

    private LocalDateTime createdAt;
}
