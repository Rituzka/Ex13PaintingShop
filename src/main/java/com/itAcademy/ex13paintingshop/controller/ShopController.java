package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/api/v1/")
public class ShopController {
    
    @Autowired
    ShopServiceImpl service;
    
    //get all the shops
    @GetMapping("/shops")
    public List<Shop> getAllShops(){
        return service.getAllShops();
    }
    
    //get a shop by id
    @GetMapping(path = "/shops/{id}")
    public Shop getShopById(@PathVariable(name = "id" ) int id){
        return service.getShopById(id);
    }

    //add a shop
    @PostMapping("/shops")
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }

    //update a shop
    @PutMapping("/shops/{id}")
    public void updateShop(@PathVariable(name = "id") int id ,@RequestBody Shop shop){
        shop.setIdShop(id);
        service.updateShop(shop);
    }

    //Delete one shop by id
    @DeleteMapping("/shops/{id}")
    public HttpStatus deleteShop(@PathVariable(name = "id") int id){
        service.deleteShop(id);
        return HttpStatus.OK;
    }





}
