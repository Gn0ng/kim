package com.kim.entity;


import com.kim.dto.BOMdto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="BOM")
@ToString
public class BOM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static BOM createBOM(BOMdto bomDto){
        BOM bom = new BOM();
        bom.setProduct(bomDto.getProduct());
        bom.setMat1(bomDto.getMat1());
        bom.setMat2(bomDto.getMat2());
        bom.setMat3(bomDto.getMat3());
        bom.setMat4(bomDto.getMat4());
        bom.setMat5(bomDto.getMat5());
        bom.setMat6(bomDto.getMat6());
        bom.setMat7(bomDto.getMat7());
        bom.setJelly(bomDto.getJelly());


        return bom;
    }

    public void updateBOM(BOMdto bomdto){
        this.product=bomdto.getProduct();
        this.mat1=bomdto.getMat1();
        this.mat2=bomdto.getMat2();
        this.mat3=bomdto.getMat3();
        this.mat4=bomdto.getMat4();
        this.mat5=bomdto.getMat5();
        this.mat6=bomdto.getMat6();
        this.mat7=bomdto.getMat7();
        this.jelly= bomdto.getJelly();


    }


}
