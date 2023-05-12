package com.kim.service;

import com.kim.dto.BarcodeDto;
import com.kim.dto.MatDto;
import com.kim.dto.OrderDto;
import com.kim.entity.Barcode;
import com.kim.entity.Mat;
import com.kim.entity.Order;
import com.kim.repository.BarcodeRepository;
import com.kim.repository.MatRepository;
import com.kim.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final MatRepository matRepository;
    @Autowired
    private final BarcodeService barcodeService;
    @Autowired
    private final BarcodeRepository barcodeRepository;

    public Order saveOrder(Order order) { return orderRepository.save(order);  }


    @Transactional(readOnly = true)
    public OrderDto getorderDtl(Long orderId){

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        OrderDto orderDto = OrderDto.of(order);
        return orderDto;
    }

    public List<Order> orderList() {

        return orderRepository.findAll();
    }

    public void saveProcess1(Order order){

        int dayOver = 0;

        //세척

        BarcodeDto barcodeDto1 = new BarcodeDto();
        barcodeDto1.setBarcodeId("kim-wash-"+001);//번호 자동 증가 구현 필요

        barcodeDto1.setOrderId(order.getId());
        barcodeDto1.setStartTime(LocalDateTime.now().plusMinutes(20+dayOver));
        double aaaa = order.getQuantity()*((30*80)/0.8)/2/1000;
        int cab = (int) Math.ceil(aaaa);
        List<Mat> matlist = matRepository.findByProduct("양배추");
        Mat mat1 = matlist.get(0);
        if(mat1.getEa() >= cab){
            mat1.setEa(mat1.getEa()-cab);
        }
        else{
            mat1.setEa(0);
            Mat mat2 = matlist.get(1);
            mat2.setEa(mat2.getEa()+mat1.getEa()-cab);
        }




        int water = cab;

        barcodeDto1.setEa("양배추 "+cab+"kg"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto1.setMatId("양배추 id: " +001);//추후 구현
        barcodeDto1.setProcessId("세척");
        barcodeDto1.setEndTime(LocalDateTime.now().plusMinutes(50+dayOver));
        barcodeDto1.setResult(cab);
        Barcode barcode1 = Barcode.createBarcode(barcodeDto1);
        System.out.println(barcode1);
        barcodeRepository.save(barcode1);



        //전처리
        BarcodeDto barcodeDto2 = new BarcodeDto();
        barcodeDto2.setBarcodeId("kim-before-"+001);//번호 자동 증가 구현 필요
        barcodeDto2.setOrderId(order.getId());
        barcodeDto2.setStartTime(LocalDateTime.now().plusMinutes(70+dayOver));


        barcodeDto2.setEa("양배추 "+cab+"kg"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto2.setMatId("양배추 id: " +001);//추후 구현
        barcodeDto2.setProcessId("전처리");
        barcodeDto2.setEndTime(LocalDateTime.now().plusMinutes(130+dayOver));
        barcodeDto2.setResult(cab);
        Barcode barcode2 = Barcode.createBarcode(barcodeDto2);
        barcodeRepository.save(barcode2);

        //추출
        BarcodeDto barcodeDto3 = new BarcodeDto();
        barcodeDto3.setBarcodeId("kim-extract-"+001);//번호 자동 증가 구현 필요
        barcodeDto3.setOrderId(order.getId());
        barcodeDto3.setStartTime(LocalDateTime.now().plusMinutes(190+dayOver));


        barcodeDto3.setEa("양배추 "+cab+"kg, 물 "+water+"L"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto3.setMatId("양배추 id: " +001);//추후 구현
        aaaa = (cab+water)*800;
        System.out.println(aaaa);
        cab = (int) Math.ceil(aaaa);
        System.out.println(cab);
        barcodeDto3.setProcessId("추출");
        barcodeDto3.setEndTime(LocalDateTime.now().plusMinutes(3070+dayOver));
        barcodeDto3.setResult(cab);
        Barcode barcode3 = Barcode.createBarcode(barcodeDto3);
        barcodeRepository.save(barcode3);



        //충진

        BarcodeDto barcodeDto4 = new BarcodeDto();
        barcodeDto4.setBarcodeId("kim-fill-"+001);//번호 자동 증가 구현 필요
        barcodeDto4.setOrderId(order.getId());
        barcodeDto4.setStartTime(LocalDateTime.now().plusMinutes(3090+dayOver));


        barcodeDto4.setEa("양배추 추출액상 "+cab+"ml"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto4.setMatId("양배추 id: " +"001");//추후 구현
        barcodeDto4.setProcessId("충진");
        barcodeDto4.setEndTime(LocalDateTime.now().plusMinutes(3450+dayOver));
        aaaa = cab/80;
        System.out.println(aaaa);
        cab = (int) Math.ceil(aaaa);
        System.out.println(cab);

        barcodeDto4.setResult(cab);
        Barcode barcode4 = Barcode.createBarcode(barcodeDto4);
        barcodeRepository.save(barcode4);

        //검사

        BarcodeDto barcodeDto5 = new BarcodeDto();
        barcodeDto5.setBarcodeId("kim-check-"+"001");//번호 자동 증가 구현 필요
        barcodeDto5.setOrderId(order.getId());
        barcodeDto5.setStartTime(LocalDateTime.now().plusMinutes(3460+dayOver));


        barcodeDto5.setEa("양배추즙 "+cab+"ea"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto5.setMatId("양배추 추출액상 id: " +"001");//추후 구현
        barcodeDto5.setProcessId("검사");
        barcodeDto5.setEndTime(LocalDateTime.now().plusMinutes(3700+dayOver));
        barcodeDto5.setResult(cab);
        Barcode barcode5 = Barcode.createBarcode(barcodeDto5);
        barcodeRepository.save(barcode5);

        int remain = (int)aaaa % 30;
        if(remain == 0){

        }else {
            MatDto matDto = new MatDto();
            matDto.setProduct("양배추즙");
            matDto.setEa(remain);
            matDto.setArrive(LocalDateTime.now().plusMinutes(3700+dayOver));

            Mat mat = Mat.createMat(matDto);
            matRepository.save(mat);
        }


        //포장

        BarcodeDto barcodeDto6 = new BarcodeDto();
        barcodeDto6.setBarcodeId("kim-pack-"+"001");//번호 자동 증가 구현 필요
        barcodeDto6.setOrderId(order.getId());
        barcodeDto6.setStartTime(LocalDateTime.now().plusMinutes(5160+dayOver));


        barcodeDto6.setEa("양배추즙 "+cab+"ea"); // 필요 재료 리스트는 공정을 보고 가져옴 -> 추후 구현
        barcodeDto6.setMatId("양배추즙: " +"001");//추후 구현
        barcodeDto6.setProcessId("포장");
        barcodeDto6.setEndTime(LocalDateTime.now().plusMinutes(5400+dayOver));
        aaaa = cab / 30;
        System.out.println(aaaa);
        cab = (int) Math.ceil(aaaa);
        System.out.println(cab);
        order.updateComDate(barcodeDto6.getEndTime());
        barcodeDto6.setResult(cab);
        Barcode barcode6 = Barcode.createBarcode(barcodeDto6);
        barcodeRepository.save(barcode6);





    }
    public void saveProcess2(OrderDto orderDto){




    }

    public void saveProcess3(OrderDto orderDto){



    }




}
