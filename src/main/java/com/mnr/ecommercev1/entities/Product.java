package com.mnr.ecommercev1.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private  boolean promotion;

    private boolean selected;
    private boolean available;
    private String photoName;
    @ManyToOne
    private Category category;
}
