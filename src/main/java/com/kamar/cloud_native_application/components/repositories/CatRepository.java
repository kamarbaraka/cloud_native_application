package com.kamar.cloud_native_application.components.repositories;

import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * a repository to manage and perform CRUD operations on cats.
 * @author kamarbaraka.*/

@RepositoryRestResource
public interface CatRepository extends CrudRepository<Cat, Long> {

    Cat findCatByCatId(Long id);
    Cat findCatByCatName(String name);

    List<Cat> findCatsByCatName(String catName);

    Cat findCatByCatIds(long... ids);

}
