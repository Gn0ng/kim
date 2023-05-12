package com.kim.entity;


import com.kim.dto.BarcodeDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name="barcode")
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String barcodeId;

    private Long orderId;

    private LocalDateTime startTime;

    private String ea;

    private LocalDateTime endTime;

    private String matId;

    private String processId;

    private int result;

    public static Barcode createBarcode(BarcodeDto barcodeDto){
        Barcode barcode = new Barcode();
        barcode.setOrderId(barcodeDto.getOrderId());
        barcode.setBarcodeId(barcodeDto.getBarcodeId());
        barcode.setStartTime(barcodeDto.getStartTime());
        barcode.setEa(barcodeDto.getEa());
        barcode.setEndTime(barcodeDto.getEndTime());
        barcode.setMatId(barcodeDto.getMatId());
        barcode.setProcessId(barcodeDto.getProcessId());
        barcode.setResult(barcodeDto.getResult());
        return barcode;
    }


}
