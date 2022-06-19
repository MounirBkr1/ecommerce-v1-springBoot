package com.mnr.ecommercev1.repositories;

import com.mnr.ecommercev1.entities.Category;
import com.mnr.ecommercev1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
