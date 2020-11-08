package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/api/v1/shops")
public class ShopController {

    @Autowired
    ShopService service;


    //get all the shops
    @GetMapping
    public List<Shop> getAllShops() {
        return service.getAllShops();
    }
  /*

    @GetMapping(path = "/{id}")
    public Shop getShopById(@PathVariable(name = "id" ) long id){
        return service.getShopById(id);
    }


    @PostMapping
    public void addShop(@RequestBody Shop shop){
        service.addShop(shop);
    }


    @PutMapping("/{id}")
    public void updateShop(@PathVariable(name = "id") long id ,@RequestBody Shop shop){
        shop.setId(id);
        service.updateShop(shop);
    }


    @DeleteMapping("/{id}")
    public HttpStatus deleteShop(@PathVariable(name = "id") long id){
        service.deleteShop(id);
        return HttpStatus.OK;
    }
*/

}