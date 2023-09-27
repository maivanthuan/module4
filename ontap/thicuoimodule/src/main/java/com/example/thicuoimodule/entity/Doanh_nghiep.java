package com.example.thicuoimodule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class doanh_nghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @NotBlank

}
