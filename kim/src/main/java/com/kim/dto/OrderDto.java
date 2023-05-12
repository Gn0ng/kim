package com.kim.dto;

import com.kim.entity.Mat;
import com.kim.entity.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
public class OrderDto {

    private Long id;

    private String orderBy;

    private String product;

    private int quantity;

    private LocalDateTime orderDate;

    private String status;

    private String lotNum;

    private LocalDateTime comDate;

    private int jelly;

    private static ModelMapper modelMapper = new ModelMapper();

    public Order createOrder(){
        return modelMapper.map(this, Order.class);
    }

    public static OrderDto of(Order order) {
        return modelMapper.map(order,OrderDto.class);
    }



}
