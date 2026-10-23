package com.mw.pub.service;

import com.mw.pub.dto.CreateOrderDto;
import com.mw.pub.dto.OrderResponseDto;
import com.mw.pub.entities.Order;

import java.util.List;

public interface OrderService {

    public OrderResponseDto createOrder(CreateOrderDto createOrderDto);
    public List<OrderResponseDto> getMyOrders();
    public OrderResponseDto getMyOrder(Long orderId);
    public List<OrderResponseDto> getAllOrders();
    public List<OrderResponseDto> getUserOrders(Long userId);
    public OrderResponseDto getOrder(Long orderId);
    public String deleteOrder(Long orderID);


}
