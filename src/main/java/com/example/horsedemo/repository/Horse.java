package com.example.horsedemo.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@ToString
@Entity
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String age;
    private String price;

    public Horse() {
    }

    public Horse(String type, String age, String price) {
        this.type = type;
        this.age = age;
        this.price = price;
    }

    public Horse(Integer id, String type, String age, String price) {
        this.id = id;
        this.type = type;
        this.age = age;
        this.price = price;
    }
}
