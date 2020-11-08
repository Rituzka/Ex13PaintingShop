package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ShopController {

    @Autowired
    ShopService service;


    //get all the shops
    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        return service.getAllShops();
    }

    //get a shop by id
    @GetMapping("shops/{id}")
    public Shop getShopById(@PathVariable(name = "id" ) long id){
        return service.getShopById(id);
    }
    //create a new shop
    @PostMapping("/shops")
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }
    //update a shop
    @PutMapping("/shops/{id}")
    public void updateShop(@PathVariable(name = "id") long id ,@RequestBody Shop shop){
        shop.setId(id);
        service.updateShop(shop);
    }
    //delete a shop
    @DeleteMapping("/shops/{id}")
    public HttpStatus deleteShop(@PathVariable(name = "id") long id){
        service.deleteShop(id);
        return HttpStatus.OK;
    }
}