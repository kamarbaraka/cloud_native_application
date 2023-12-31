package com.kamar.cloud_native_application.components.controllers;

import com.kamar.cloud_native_application.components.repositories.CatRepository;
import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * a cat controller class.
 * @author kamarbaraka.*/

@RestController
@ConditionalOnClass({CatRepository.class})
@RequestMapping(value = "/api", consumes = {"application/hal+json", "application/json", "text/plain",
"text/chars"})
public class CatController {

    private final CatRepository catRepository;

    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @PostMapping(value = "/cat_add", consumes = {"application/hal+json", "application/json", "text/plain",
    "text/chars"},
    produces = {"application/json"})
    @CrossOrigin(origins = {"http://localhost:63343/"}, methods = {RequestMethod.POST})
    public HttpStatus addCat(@RequestBody Map<String , String> cat){

        String name = cat.get("name");
        String age = cat.get("age");

        catRepository.save(new Cat(name, age));

        return HttpStatus.OK;

    }

    @GetMapping(value = "/cat_get", consumes = {"application/json", "text/plain"}, produces = {"application/json"})
    @CrossOrigin(origins = {"http://localhost:63343/"}, methods = {RequestMethod.GET})
    public List<Cat> getCat(@RequestParam("name") String name){

        return catRepository.findCatsByCatName(name);

    }


    @PutMapping(value = "/cat_put", consumes = {"application/json", "text/plain"})
    @CrossOrigin(origins = {"http://localhost:63343/"}, methods = {RequestMethod.PUT})
    public HttpStatus putCat(@RequestParam("name") String catName, @RequestParam("age") String catAge){

        /*get the cat by name*/
        Cat cat = this.catRepository.findCatByCatName(catName);

        /*update the cat's properties*/
        cat.setCatAge(catAge);

        /*save the updated cat*/
        this.catRepository.save(cat);

        return HttpStatus.OK;
    }
}
