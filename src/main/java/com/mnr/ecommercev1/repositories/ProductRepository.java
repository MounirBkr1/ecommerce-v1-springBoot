package com.mnr.ecommercev1.repositories;

import com.mnr.ecommercev1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*") //autoriser tous les domaines a acceder a cette api Rest
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {

    @RestResource(path="/selectedproducts")
            //pour chercher les données;on tapent: http://localhost:8080/products/search/selectedproducts
    public List<Product> findBySelectedIsTrue();

    @RestResource(path="/productsByKeyword")
     //pour chercher les données;on tapent: http://localhost:8080/products/search/productsByKeyword
      //@Query("select p from Product p where p.name like:x")
       //public List<Product>chercher(@Param("x") String mc);
     //ou procede with spring data like that
     public List<Product> findByNameContains(@Param("mc") String mc);

    @RestResource(path="/promoProducts")
    //http://localhost:8080/products/search/productsByKeyword/promoProducts
    public List<Product> findByPromotionIsTrue();

    @RestResource(path="/dispoProducts")
    //http://localhost:8080/products/search/productsByKeyword/dispoProducts
    public List<Product> findByAvailableIsTrue();

}
