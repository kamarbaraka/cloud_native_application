package com.kamar.cloud_native_application.components.controllers;

import com.kamar.cloud_native_application.components.repositories.CatRepository;
import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * a cat controller class.
 * @author kamarbaraka.*/

@Controller
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @PostMapping("/cat_add")
    public void addCat(String catName){

        this.catRepository.save(new Cat(catName));

    }

    @GetMapping("/cat_get")
    @ResponseBody
    public String getCat(String catName){

//        Cat cat = catRepository.getCatByCatName(catName);

//        return "cat name = %s, cat ID = %s".formatted(cat.getCatName(), cat.getCatId());
        return "hello";
    }
}
