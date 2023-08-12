package com.kamar.cloud_native_application.persistence;

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

    public Cat(String catName) {
        this.catName = catName;
    }

    public Cat() {
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
