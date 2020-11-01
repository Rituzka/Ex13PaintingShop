package com.itAcademy.ex13paintingshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "paintings")
public class Painting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "painting_id")
    private int idPainting;

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

    @JoinColumn(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    public int getIdPainting() {
        return idPainting;
    }

    public void setIdPainting(int idPainting) {
        this.idPainting = idPainting;
    }

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
