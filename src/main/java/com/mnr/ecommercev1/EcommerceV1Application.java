package com.mnr.ecommercev1;

import com.mnr.ecommercev1.entities.Category;
import com.mnr.ecommercev1.entities.Product;
import com.mnr.ecommercev1.repositories.CategoryRepository;
import com.mnr.ecommercev1.repositories.ProductRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class EcommerceV1Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoriaRepository;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //qd on envoi un fichier de format json, tu expose son id
        repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);

        categoriaRepository.save(new Category(null,"computers",null,null,null));
        categoriaRepository.save(new Category(null,"Printers",null,null,null));
        categoriaRepository.save(new Category(null,"Smart Phone",null,null,null));

        Random rnd= new Random();
        categoriaRepository.findAll().forEach(c->{

            for (int i =0;i<10; i++){
                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setPrice(100 + rnd.nextInt(1000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }

        });

    }

}


//min : 42