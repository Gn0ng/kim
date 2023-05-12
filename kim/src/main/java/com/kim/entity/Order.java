package com.kim.entity;

import com.kim.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="ordered")
@Setter
@Getter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderBy;

    private String product;

    private int quantity;

    private LocalDateTime orderDate;

    private String status;

    private String lotNum;

    private LocalDateTime comDate;

    private int jelly;

    public static Order createOrder(OrderDto orderDto){
        Order order = new Order();
        order.setOrderBy(orderDto.getOrderBy());
        order.setProduct(orderDto.getProduct());
        order.setQuantity(orderDto.getQuantity());
        order.setOrderDate(LocalDateTime.now());
        if(orderDto.getProduct().equals("양배추")||orderDto.getProduct().equals("흑마늘")){
            order.setJelly(1);
        }else {
            order.setJelly(2);
        }
        return order;
    }

    public void updateComDate(LocalDateTime comDate){
        this.comDate = comDate;
    }



}
