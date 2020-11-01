package com.itAcademy.ex13paintingshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class Shop implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "shop_id")
    private int idShop;

}
