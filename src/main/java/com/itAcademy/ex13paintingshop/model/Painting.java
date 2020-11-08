package com.itAcademy.ex13paintingshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "paintings")
public class Painting extends AbstractEntity implements Serializable {

    @Column(name = "painting_name")
    @NotNull
    private String paintingName;

    @Column(name = "painting_price")
    @NotNull
    private float paintingPrice;

    @Column(name = "date_arrival")
    @NotNull
    private String arrivalDate;

    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Shop shop;


    public String getPaintingName() {
        return paintingName;
    }

    public void setPaintingName(String paintingName) {
        this.paintingName = paintingName;
    }

    public float getPaintingPrice() {
        return paintingPrice;
    }

    public void setPaintingPrice(float paintingPrice) {
        this.paintingPrice = paintingPrice;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}
