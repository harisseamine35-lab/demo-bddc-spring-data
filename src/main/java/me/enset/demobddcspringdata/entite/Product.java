package me.enset.demobddcspringdata.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "PRODUCTS")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Product {
    @Id @GeneratedValue
    private long id ;
    private String name ;
    private double price;
    private int quantity;



}
