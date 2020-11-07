package com.itAcademy.ex13paintingshop.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Shop extends AbstractEntity implements Serializable {

   @Column(name = "shop_name")
   @NotNull
    private String shopName;

   @Column(name = "shop_capacity")
   @NotNull
    private int shopCapacity;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Painting> paintings = new ArrayList<>();

    public Shop(){};

    public Shop(
            String shopName,
            int shopCapacity
    ){
        this.shopName = shopName;
        this.shopCapacity = shopCapacity;
    };


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopCapacity() {
        return shopCapacity;
    }

    public void setShopCapacity(int shopCapacity) {
        this.shopCapacity = shopCapacity;
    }

    public List<Painting> getPaintings() {
        return paintings;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", shopCapacity=" + shopCapacity +
                ", paintings=" + paintings +
                '}';
    }
}
