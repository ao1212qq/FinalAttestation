package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Данный метод позволяет получить список всех товаров
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }




    public Order getOrderId(int id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    /*

   @Transactional
    public void updateOrder(int id,Product product, Person person, Order order){
        order.setId(id);
        order.setProduct(product);
       order.setPerson(person);
        orderRepository.save(order);
    }
    */
    @Transactional
    public void updateOrder(int id, String number, Product product, Person person, int count,float price,LocalDateTime dateTime, Order orders){
        orders = orderRepository.findById(id).orElseThrow();
        orders.setId(id);
        orders.setProduct(product);
        orders.setPerson(person);
        orders.setNumber(number);
        orders.setDateTime(dateTime);
        orders.setPrice(price);
        orders.setCount(count);
        orderRepository.save(orders);
    }

}
