package com.kim.service;

import com.kim.dto.BOMdto;
import com.kim.dto.MatDto;
import com.kim.entity.BOM;
import com.kim.entity.Mat;
import com.kim.repository.MatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MatService {

    private final MatRepository matRepository;
    public Mat saveMat(Mat mat) { return matRepository.save(mat);  }


    @Transactional(readOnly = true)
    public MatDto getMatDtl(Long matId){

        Mat mat = matRepository.findById(matId)
                .orElseThrow(EntityNotFoundException::new);
        MatDto matdto = MatDto.of(mat);
        return matdto;
    }

    public List<Mat> matList() {
        return matRepository.findAll();
    }

    public List<Mat> findmat(String product){
        return matRepository.findByProduct(product);

    }

//    public int findQuan(String product){
//        int quan = 0;
//
//
//
//
//        return quan;
//    }


}
