package com.itAcademy.ex13paintingshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class Shop implements Serializable {

    private static final long serialVersionUid = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "shop_id")
    private int idShop;

   @Column(name = "shop_name")
    private String shopName;

   @Column(name = "shop_capacity")
    private int shopCapacity;

    @OneToMany(mappedBy = "shops", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Painting painting;

    public Shop(){};

    public Shop(
            String shopName,
            int shopCapacity
    ){
        this.shopName = shopName;
        this.shopCapacity = shopCapacity;
    };

    public static long getSerialVersionUid() {
        return serialVersionUid;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

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

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }
}
