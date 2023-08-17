package com.kamar.cloud_native_application.components.controllers;

import com.kamar.cloud_native_application.components.repositories.CatRepository;
import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.web.bind.annotation.*;

/**
 * a cat controller class.
 * @author kamarbaraka.*/

@RestController
public class CatController {

    private final CatRepository catRepository;

    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @PostMapping("/cat_add")
    public void addCat(String catName){

        this.catRepository.save(new Cat(catName));

    }

    @GetMapping("/cat_get")
    @ResponseBody
    public String getCat(String catName){

        Cat cat = catRepository.getCatByCatName(catName);

        return "cat name = %s, cat ID = %s".formatted(cat.getCatName(), cat.getCatId());
    }

    @PutMapping("/cat_put")
    public String putCat(String name){

        this.catRepository.save(new Cat(name));

        return "success";
    }
}
