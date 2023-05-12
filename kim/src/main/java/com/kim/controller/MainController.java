package com.kim.controller;

import com.kim.dto.BOMdto;
import com.kim.dto.BarcodeDto;
import com.kim.dto.MatDto;
import com.kim.dto.OrderDto;
import com.kim.entity.BOM;
import com.kim.entity.Barcode;
import com.kim.entity.Mat;
import com.kim.entity.Order;
import com.kim.repository.BOMRepository;
import com.kim.repository.BarcodeRepository;
import com.kim.repository.MatRepository;
import com.kim.repository.OrderRepository;
import com.kim.service.BOMService;
import com.kim.service.BarcodeService;
import com.kim.service.MatService;
import com.kim.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private BOMService bomService;
    @Autowired
    private MatService matService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MatRepository matRepository;
    @Autowired
    private BarcodeService barcodeService;


    @GetMapping(value="/")
    public String main(Model model){

        return "main"; }

    @GetMapping(value="/bom")
    public String bom(Model model){
        model.addAttribute("bomdto",new BOMdto());
        return "BOM/BOM";
    }

    @GetMapping(value="/mat")
    public String mat(Model model){

        model.addAttribute("matdto",new MatDto());


        return "mat/getMat";
    }

    @GetMapping(value="/order")
    public String order(Model model){

        model.addAttribute("orderdto",new OrderDto());

        return "order/getOrder";
    }
    @PostMapping(value="/test")
    public String test(Model model,@Valid BOMdto bomdto , BindingResult bindingResult){

        System.out.println(1);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "입력값이 올바르지 않습니다.");
            System.out.println(2);
            return "redirect:/";

        }

        try {
            BOM bom = BOM.createBOM(bomdto);
            System.out.println(bom);
            System.out.println(3);
            bomService.saveBOM(bom);

        } catch (Exception e) {
            System.out.println(4);
            return "redirect:/";
        }

        System.out.println(5);
        return  "redirect:/test/test";
    }

    @PostMapping(value="/getmat")
    public String test1(Model model,@Valid MatDto matDto , BindingResult bindingResult){

        System.out.println(1);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "입력값이 올바르지 않습니다.");
            System.out.println(2);
            return "redirect:/";

        }

        try {
            Mat mat = Mat.createMat(matDto);
            System.out.println(mat);
            System.out.println(3);
            matService.saveMat(mat);

        } catch (Exception e) {
            System.out.println(4);
            return "redirect:/mat";
        }

        System.out.println(5);
        return  "redirect:/mat/test";
    }

    @PostMapping(value="/getorder")
    public String test2(Model model,@Valid OrderDto orderDto , BindingResult bindingResult){

        System.out.println(1);

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "입력값이 올바르지 않습니다.");
            System.out.println(2);
            return "redirect:/";

        }

        try {
            System.out.println(orderDto);
            Order order = Order.createOrder(orderDto);

//            System.out.println(3);
            orderService.saveOrder(order);
            System.out.println(order);
//            orderDto = orderService.getorderDtl(order.getId());
            orderService.saveProcess1(order);


/*            if(orderDto.getProduct().equals("양배추")){
                System.out.println(1);
                orderService.saveProcess1(orderDto);
            }
            else if(orderDto.getProduct().equals("흑마늘")){
                orderService.saveProcess2(orderDto);
                System.out.println(2);
            }else{
                orderService.saveProcess3(orderDto);
                System.out.println(3);
            }*/


        } catch (Exception e) {
            System.out.println(4);
            return "redirect:/order";
        }

        System.out.println(5);
        return  "redirect:/order/test";
    }


    @GetMapping(value="/test/test")
    public String testtt(Model model){

        List<BOM> bom= bomService.bomList();

        model.addAttribute("list", bom);

        return "/test/test";
    }

    @GetMapping(value="/mat/test")
    public String testtat(Model model){

        List<Mat> mat= matService.matList();

        model.addAttribute("list", mat);

        return "/mat/mat";
    }

    @GetMapping(value="/order/test")
    public String testt3(Model model){

        List<Order> order= orderService.orderList();

        model.addAttribute("list", order);

        return "/order/order";
    }


    @GetMapping(value="/comp")
    public String tasda(Model model){

        List<Order> order = orderService.orderList();

 /*       if(orderDto.getProduct().equals("양배추")){

            LocalDateTime ttt = orderDto.getOrderDate();

            ttt = ttt.plusHours(90);

            orderDto.setComDate(ttt);
            List<Mat> mats = matRepository.findByProduct("양배추");
            int cab = 0;
            for(Mat mat : mats){
                cab += mat.getEa();
            }
            int order = orderDto.getQuantity();

            double req = (double)(order*((30*80)/0.8)/2)/1000;//필요량

            int req2 = (int)Math.ceil(req);





            //필요량만큼 없으면
            if(req > cab){
                System.out.println("자재가 부족합니다");
                //자재 발주 진행
            }
//            else {
                cab -= req; //자재에서 필요량만큼 빼주기 (구현 어떻게 할지 아직 모르겠음)

                model.addAttribute("order2", order);
                model.addAttribute("cab", cab);
                model.addAttribute("req", req2);
                model.addAttribute("order", orderDto);
                model.addAttribute("product", orderDto.getProduct());
                model.addAttribute("ordate", orderDto.getOrderDate());
                model.addAttribute("comdate", orderDto.getComDate());
                model.addAttribute("id",orderDto.getId());

//            }
        }
*/

        model.addAttribute("list",order);



        return "/comp/comp";
    }

    @GetMapping(value="/comp/{id}")
    public String tasdaa(Model model){


        List<Barcode> barcode= barcodeService.barcodeList();

        model.addAttribute("list", barcode);
//

        return "/comp/compList";
    }


//
//    @GetMapping(value="/error")
//    public String main1(){ return "redirect:/"; }
}
