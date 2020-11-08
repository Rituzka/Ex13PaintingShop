package com.itAcademy.ex13paintingshop.service;

import com.itAcademy.ex13paintingshop.exceptions.ResourceNotFoundException;
import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.repository.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ShopService {

    @Autowired
    IShopRepository shopRepository;


    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }


    public Shop getShopById(long id) {
        Optional<Shop> shopDB = shopRepository.findById(id);

        if(shopDB.isPresent())
            return shopDB.get();
        else
            throw new ResourceNotFoundException("Shop not found");
    }


    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }


    public void updateShop(Long shopId, Shop shopRequest) {
       shopRepository.findById(shopId).map(shop -> {

           shop.setShopName(shopRequest.getShopName());
           shop.setShopCapacity(shopRequest.getShopCapacity());
           return shopRepository.save(shop);
       }).orElseThrow(() -> new ResourceNotFoundException("Shop not found"));
    }


    public void deleteShop(long id) {
        Optional<Shop> shopDB = shopRepository.findById(id);

        if (shopDB.isPresent())
            shopRepository.delete(shopDB.get());
        else
            throw new ResourceNotFoundException("Shop not found");

    }
}
