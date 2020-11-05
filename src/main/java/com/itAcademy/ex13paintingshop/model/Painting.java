package com.itAcademy.ex13paintingshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "paintings")
public class Painting extends AbstractEntity implements Serializable {

    @Column(name = "painting_name")
    private String paintingName;

    @Column(name = "painting_price")
    private float paintingPrice;

    @Column(name = "date_arrival")
    private Date arrivalDate;

    @Column(name = "author")
    private String author;


    public Painting(){}

    public Painting(
            String paintingName,
            float paitingPrice,
            Date arrivalDate,
            String author){

        this.paintingName = paintingName;
        this.paintingPrice = paitingPrice;
        this.arrivalDate = arrivalDate;
        this.author = author;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
