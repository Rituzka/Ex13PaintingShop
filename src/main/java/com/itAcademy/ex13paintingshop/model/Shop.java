package com.itAcademy.ex13paintingshop.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class Shop extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "shop_name")
   @NotNull
    private String shopName;

   @Column(name = "shop_capacity")
   @NotNull
    private int shopCapacity;


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

}
