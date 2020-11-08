package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    ShopService service;


    //get all the shops
    @GetMapping
    public List<Shop> getAllShops() {
        return service.getAllShops();
    }

    //get a shop by id
    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable(name = "id" ) long id){
        return service.getShopById(id);
    }

    //create a new shop
    @PostMapping
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }

    //update a shop
    @PutMapping("/{id}")
    public HttpStatus updateShop(@PathVariable(name = "id") Long id, @RequestBody Shop shop){
          service.updateShop(id, shop);
          return HttpStatus.OK;
    }

    //delete a shop
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable(name = "id") long id){
        service.deleteShop(id);
        return ResponseEntity.ok().build();
    }
}