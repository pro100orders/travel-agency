package com.pro100user.travelagencybackend.mapper;

import com.pro100user.travelagencybackend.dto.OrderCreateDTO;
import com.pro100user.travelagencybackend.dto.OrderDTO;
import com.pro100user.travelagencybackend.dto.OrderUpdateDTO;
import com.pro100user.travelagencybackend.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UserMapper.class, RoomMapper.class})
public interface OrderMapper {

    @Mapping(source = "roomId", target = "room.id")
    Order toEntity(OrderCreateDTO dto);
    Order toEntity(OrderUpdateDTO dto);

    OrderDTO toOrderDTO(Order order);
    List<OrderDTO> toOrderDTO(List<Order> orders);
}
