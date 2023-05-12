package com.kim.dto;

import com.kim.entity.BOM;
import com.kim.entity.Mat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class MatDto {

    private Long id;

    private String product;

    private LocalDateTime arrive;

    private int ea;

    private static ModelMapper modelMapper = new ModelMapper();

    public Mat createMat(){
        return modelMapper.map(this, Mat.class);
    }
    public static MatDto of(Mat mat) {
        return modelMapper.map(mat,MatDto.class);
    }



}
