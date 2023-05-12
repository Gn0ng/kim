package com.kim.repository;

import com.kim.entity.Mat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface MatRepository extends JpaRepository<Mat, Long>, QuerydslPredicateExecutor<Mat> {

    List<Mat> findByProduct(String product);

}
