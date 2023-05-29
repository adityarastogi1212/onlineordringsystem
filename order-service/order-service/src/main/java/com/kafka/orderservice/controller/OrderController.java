package com.kafka.orderservice.controller;

import com.kafka.basedomains.dto.Order;
import com.kafka.basedomains.dto.OrderEvent;
//import com.kafka.orderservice.entity.OrderingData;
import com.kafka.orderservice.kafka.OrderProducer;
//import com.kafka.orderservice.repository.OrderingDataRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

//    private OrderingDataRepository dataRepository;

//    public OrderController(OrderingDataRepository dataRepository) {
//        this.dataRepository = dataRepository;
//    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setStatus("Pending");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);
        return "Order placed Successfully";
    }

//    OrderingData orderingData = new OrderingData();
//    orderingData.setData(orderEvent);
//    dataRepository.save(orderingData);


}


