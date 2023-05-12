package com.kim.dto;

import com.kim.entity.BOM;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;

@Setter
@Getter
@ToString

public class BOMdto {

    private Long id;

    private String product;

    private int mat1;

    private int mat2;

    private int mat3;

    private int mat4;

    private int mat5;

    private int mat6;

    private int mat7;


    private int jelly;

    private static ModelMapper modelMapper = new ModelMapper();

    public BOM createBOM(){
        return modelMapper.map(this, BOM.class);
    }
    public static BOMdto of(BOM bom) {
        return modelMapper.map(bom,BOMdto.class);
    }


}
