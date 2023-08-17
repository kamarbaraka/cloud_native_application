package com.kamar.cloud_native_application.components.controllers;

import com.kamar.cloud_native_application.components.repositories.CatRepository;
import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    public List<Cat> getCat(String cname){

        /*construct and persist several cats*/
        Stream.of("kamar", "baraka", "kahindi").forEach(name -> catRepository.save(new Cat(name)));

        List<Cat> catList = catRepository.findAll();
//        List<String> foundCats = new ArrayList<>();

        /*for (Cat cat :
                catList) {
            String catName = cat.getCatName();
            if (catName.equals(cname))
                return new ArrayList<>(List.of(cat.getCatName()));
            foundCats.add(catName);
        }
        return foundCats;*/

        catList.removeIf(cat -> !cat.getCatName().equals(cname));
        return catList;

//        return "cat name = %s, cat ID = %s".formatted(cat.getCatName(), cat.getCatId());
    }

    @PutMapping("/cat_put")
    public String putCat(String name){

        this.catRepository.save(new Cat(name));

        return "success";
    }
}
