package com.kim.service;

import com.kim.dto.BarcodeDto;
import com.kim.entity.Barcode;
import com.kim.repository.BarcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BarcodeService {

    private final BarcodeRepository barcodeRepository;
    public Barcode saveBarcode(Barcode barcode) { return barcodeRepository.save(barcode);  }

    @Transactional(readOnly = true)
    public BarcodeDto getBarcodeDtl(Long orderId){

        Barcode barcode = barcodeRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        BarcodeDto barcodeDto = BarcodeDto.of(barcode);
        return barcodeDto;
    }
    public List<Barcode> barcodeList() {
        //기존 List<Board>값으로 넘어가지만 페이징 설정을 해주면 Page<Board>로 넘어갑니다.
        return barcodeRepository.findAll();
    }
    public List<Barcode> barcodeList2(Long id) {
        //기존 List<Board>값으로 넘어가지만 페이징 설정을 해주면 Page<Board>로 넘어갑니다.
        return barcodeRepository.findByOrderId(id);
    }


}
