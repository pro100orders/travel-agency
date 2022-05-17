package com.pro100user.travelagencybackend.service;

import com.pro100user.travelagencybackend.dto.*;

import java.util.List;

public interface OrderService {

    OrderDTO create(OrderCreateDTO dto);
    OrderDTO getById(Long orderId);
    OrderDTO update(OrderUpdateDTO dto);
    boolean delete(Long orderId);
    List<OrderDTO> getAll();
}
