package com.kim.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name="process")
public class process {

    @Id
    private String name;

    private int min;

    private int leadTime;

    private int produce;

    private int status;

    private LocalDateTime endTime;

    private int max;



}
