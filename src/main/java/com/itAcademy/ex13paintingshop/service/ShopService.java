package com.itAcademy.ex13paintingshop.service;

import com.itAcademy.ex13paintingshop.exceptions.ResourceNotFoundException;
import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.repository.IShopRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ShopService {

    private final IShopRepository shopRepository;

    public ShopService(IShopRepository shopRepository) {
        this.shopRepository = shopRepository;

    }

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


    public void updateShop(Shop shop) {
        Optional<Shop> shopDB = shopRepository.findById(shop.getId());

        if(shopDB.isPresent()) {
            Shop shopToUpdate = shopDB.get();
            shopToUpdate.setId(shop.getId());
            shopToUpdate.setShopName(shop.getShopName());
            shopToUpdate.setShopCapacity(shop.getShopCapacity());

        } else
            throw new ResourceNotFoundException("Shop not found");

    }


    public void deleteShop(long id) {
        Optional<Shop> shopDB = shopRepository.findById(id);

        if (shopDB.isPresent())
            shopRepository.delete(shopDB.get());
        else
            throw new ResourceNotFoundException("Shop not found");

    }
}
