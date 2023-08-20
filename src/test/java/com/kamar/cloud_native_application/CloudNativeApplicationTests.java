package com.kamar.cloud_native_application;

import com.kamar.cloud_native_application.components.persistence.Cat;
import com.kamar.cloud_native_application.components.repositories.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.stream.Stream;

/**
 * test class for the cat.
 * the best.
 * @author kamarbaraka.*/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CloudNativeApplicationTests {

    @Autowired
    MockMvc mock;

    @Autowired
    CatRepository catRepository;

    @BeforeEach
    void before(){

        /*create a stream of names and use them to construct cats.*/
        Stream.of("cookie", "jetty", "beans", "noland").forEach(name -> catRepository.save(new Cat(name)));

    }

    @Test
    void persistenceTest() throws Exception{

        MediaType halJson = MediaType.parseMediaType("application/hal+json");

        this.mock.perform(get("/cats")).andExpect(status().isOk()).andExpect(content().contentType(halJson)).
                andExpect(System.out::println);
    }

    @Test
    void contextLoads() {
    }

}
