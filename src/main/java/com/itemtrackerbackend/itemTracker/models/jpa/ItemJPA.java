package com.itemtrackerbackend.itemTracker.models.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "item")
public class ItemJPA {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "urlImage")
    private String urlImage;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "status")
    private String status = "ON";

}
