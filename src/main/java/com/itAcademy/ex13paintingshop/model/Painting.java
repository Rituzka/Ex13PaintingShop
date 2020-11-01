package com.itAcademy.ex13paintingshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "paintingshops")
public class Painting implements Serializable {
    private static final long Uid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "painting_id")
    private int idShop;

    @Column(name = "painting_name")
    private String name;

    @Column(name = "painting_price")
    private float price;

    @Column(name = "date_arrival")
    private Date arrivalDate;

    @Column(name = "author")
    private String author;


    public Painting(){}

    public Painting(
            int idShop,
            String name,
            float price,
            Date arrivalDate,
            String author){

        this.idShop = idShop;
        this.name = name;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.author = author;

    }

    public static long getUid() {
        return Uid;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
