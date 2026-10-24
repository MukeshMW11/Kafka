package com.mw.pub.controller;


import com.mw.pub.dto.CreateOrderDto;
import com.mw.pub.dto.OrderResponseDto;
import com.mw.pub.entities.Order;
import com.mw.pub.service.OrderService;
import com.sun.net.httpserver.HttpsConfigurator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

//   User -> create order

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody CreateOrderDto createOrderDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(createOrderDto));
    }

//    User -> Get order

    @GetMapping("/my")
    public ResponseEntity<List<OrderResponseDto>> getMyOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getMyOrders());
    }



//    User -> get a particular order
    @GetMapping("/my/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getMyOrder(orderId));
    }


//    Admin -> Get All Orders
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }


//    Admin -> Get Orders by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponseDto>> getUserOrders(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getUserOrders(userId));
    }


//    Admin ->
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(orderId));
    }


//    Admin -> Delete an order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orderService.deleteOrder(orderId));
    }
}
