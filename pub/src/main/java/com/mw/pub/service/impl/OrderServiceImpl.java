package com.mw.pub.service.impl;

import com.mw.pub.dto.CreateOrderDto;
import com.mw.pub.dto.OrderResponseDto;
import com.mw.pub.entities.Order;
import com.mw.pub.entities.User;
import com.mw.pub.exception.OrderNotFound;
import com.mw.pub.exception.UserNotFound;
import com.mw.pub.repository.OrderRepository;
import com.mw.pub.repository.UserRepository;
import com.mw.pub.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(CreateOrderDto createOrderDto) {

        Order newOrder = new Order();
        newOrder.setName(createOrderDto.getName());
        newOrder.setPrice(createOrderDto.getPrice());
        newOrder.setDescription(createOrderDto.getDescription());
        newOrder.setUser(getLoggedInUser());

        Order createdOrder = orderRepository.save(newOrder);
        return mapDbToDto(createdOrder);

    }

    @Override
    @Transactional
    public List<OrderResponseDto> getMyOrders() {
        User currentLoggedInUser = getLoggedInUser();

        return orderRepository.findByUserId(currentLoggedInUser.getId())
                .stream()
                .map(this::mapDbToDto)
                .toList();
    }

    @Override
    @Transactional
    public OrderResponseDto getMyOrder(Long orderId) {

        User loggedInUser =  getLoggedInUser();
        Order myOrder = orderRepository.findByIdAndUserId(orderId , loggedInUser.getId() ).orElseThrow(()-> new OrderNotFound("The order with" + orderId + "cannot be " +
                "found"));

        return  mapDbToDto(myOrder);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapDbToDto)
                .toList();
    }

    @Override
    public List<OrderResponseDto> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::mapDbToDto)
                .toList();
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        Order order =  orderRepository.findById(orderId)
                .orElseThrow(()-> new OrderNotFound("The order with id : " + orderId + "cannot be found" ));
    return  mapDbToDto(order);
    }

    @Override
    @Transactional
    public String deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFound("The order with id : " + orderId + "cannot be found" ));
        orderRepository.delete(order);
        return "The order was successfully deleted";
    }

    @Override
    public String deleteMyOrder(Long orderId) {
        User loggedInuser = getLoggedInUser();
        Order order = orderRepository.findByIdAndUserId(orderId , loggedInuser.getId()).orElseThrow(()-> new OrderNotFound("The order related to user cannot be found"));
        return "The  order was successfully deleted";
    }


    private User getLoggedInUser(){

        String email = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication().getName());

        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFound("The user with email " + email + " was not found" ));
    }


    private OrderResponseDto mapDbToDto(Order order){
        OrderResponseDto orderResponseDtoOrderDto = new OrderResponseDto();
        orderResponseDtoOrderDto.setName(order.getName());
        orderResponseDtoOrderDto.setPrice(order.getPrice());
        orderResponseDtoOrderDto.setDescription(order.getDescription());
        orderResponseDtoOrderDto.setCreated_by(order.getUser().getId());
        return orderResponseDtoOrderDto;
    }

}
