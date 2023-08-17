package com.kamar.cloud_native_application.components.repositories;

import com.kamar.cloud_native_application.components.persistence.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * a repository to manage and perform CRUD operations on cat objects.
 * @author kamarbaraka.*/

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {

    Cat findCatByCatId(Long id);
    Cat findCatByCatName(String name);

}
