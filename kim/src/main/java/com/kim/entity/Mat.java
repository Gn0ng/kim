package com.kim.entity;

import com.kim.dto.MatDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="mat")
@Getter
@Setter
@ToString
public class Mat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private LocalDateTime arrive;

    private int ea;


    public static Mat createMat(MatDto matDto){
        Mat mat = new Mat();
        mat.setProduct(matDto.getProduct());
        mat.setArrive(LocalDateTime.now());
        mat.setEa(matDto.getEa());

        return mat;
    }


}
