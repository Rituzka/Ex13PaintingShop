package com.itAcademy.ex13paintingshop.service;


import com.itAcademy.ex13paintingshop.model.Shop;

import java.util.List;

public interface IShopService  {

    //get all shops
    List<Shop> getAllShops();

    //get one shop
    Shop getShopById(int id);

    //insert new shop
    void addShop (Shop shop);

    //update data from a shop
    void updateShop (Shop shop);

    //delete a Shop from list
    void deleteShop(int id);


}
