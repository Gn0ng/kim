package com.kim.dto;

import com.kim.entity.BOM;
import com.kim.entity.Barcode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class BarcodeDto {

    private Long id;

    private String barcodeId;


    private Long orderId;

    private LocalDateTime startTime;

    private String ea;

    private LocalDateTime endTime;

    private String matId;

    private String processId;

    private int result;

    private static ModelMapper modelMapper = new ModelMapper();

    public Barcode createBarcode(){
        return modelMapper.map(this, Barcode.class);
    }
    public static BarcodeDto of(Barcode barcode) {
        return modelMapper.map(barcode,BarcodeDto.class);
    }

}
