package com.kim.service;

import com.kim.dto.BOMdto;
import com.kim.entity.BOM;
import com.kim.repository.BOMRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BOMService {

    private final BOMRepository bomRepository;


    public BOM saveBOM(BOM bom) { return bomRepository.save(bom);  }

    public Long updateBOM(BOMdto bomdto) throws Exception{
        BOM bom = bomRepository.findById(bomdto.getId())
                .orElseThrow(EntityNotFoundException::new);
        bom.updateBOM(bomdto);
        return bom.getId();
    }
    @Transactional(readOnly = true)
    public BOMdto getBOMDtl(Long bomId){

        BOM bom = bomRepository.findById(bomId)
                .orElseThrow(EntityNotFoundException::new);
        BOMdto bomdto = BOMdto.of(bom);
        return bomdto;
    }

    public List<BOM> bomList() {
        //기존 List<Board>값으로 넘어가지만 페이징 설정을 해주면 Page<Board>로 넘어갑니다.
        return bomRepository.findAll();
    }
}
