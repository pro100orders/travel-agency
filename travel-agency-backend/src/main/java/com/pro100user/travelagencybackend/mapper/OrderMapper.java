package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.*;
import com.pro100user.travelagencybackend.entity.Order;
import com.pro100user.travelagencybackend.entity.Room;
import com.pro100user.travelagencybackend.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {UserMapper.class, RoomMapper.class})
public interface OrderMapper {

    Order toEntity(OrderCreateDTO dto);
    Order toEntity(OrderUpdateDTO dto);

    OrderDTO toOrderDTO(Order order);
    List<OrderDTO> toListOrderDTO(List<Order> orders);
}
