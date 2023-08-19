package com.kamar.cloud_native_application.components.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * a cat entity to represent a cat.
 * @author kamarbaraka.*/


@Entity
public class Cat {

    @Id
    @GeneratedValue
    private long catId;

    private String catName;

    private String  catAge;

    public Cat(String catName) {
        this.catName = catName;
    }

    public Cat(String catName, String  catAge){
        this.catAge = catAge;
        this.catName = catName;
    }

    public Cat() {
    }

    public String  getCatAge() {
        return catAge;
    }

    public void setCatAge(String  catAge) {
        this.catAge = catAge;
    }

    public long getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
