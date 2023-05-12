package com.kim.repository;

import com.kim.entity.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface BarcodeRepository extends JpaRepository<Barcode, Long>, QuerydslPredicateExecutor<Barcode> {

    public List<Barcode> findByOrderId(Long id);
}
