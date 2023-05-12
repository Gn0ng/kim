package com.kim.repository;

import com.kim.dto.BOMdto;
import com.kim.entity.BOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BOMRepository extends JpaRepository<BOM, Long>, QuerydslPredicateExecutor<BOM> {

    public BOM findByProduct(String product);

}
