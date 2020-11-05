package com.itAcademy.ex13paintingshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop extends AbstractEntity implements Serializable {

   @Column(name = "shop_name")
    private String shopName;

   @Column(name = "shop_capacity")
    private int shopCapacity;

    @OneToMany(mappedBy = "shops", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Painting> paintings = new LinkedList<>();

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
