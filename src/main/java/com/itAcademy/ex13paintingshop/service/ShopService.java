package com.itAcademy.ex13paintingshop.service;

import com.itAcademy.ex13paintingshop.exceptions.ResourceNotFoundException;
import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.repository.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ShopService {

    @Autowired
    IShopRepository repository;


    public List<Shop> getAllShops() {
        return repository.findAll();
    }


    public Shop getShopById(int id) {
        Optional<Shop> shopDB = repository.findById(id);

        if(shopDB.isPresent())
            return shopDB.get();
        else
            throw new ResourceNotFoundException("Shop not found");
    }


    public void addShop(Shop shop) {
        repository.save(shop);
    }


    public void updateShop(Shop shop) {
        Optional<Shop> shopDB = repository.findById(shop.getIdShop());

        if(shopDB.isPresent()) {
            Shop shopToUpdate = shopDB.get();
            shopToUpdate.setIdShop(shop.getIdShop());
            shopToUpdate.setShopName(shop.getShopName());
            shopToUpdate.setShopCapacity(shop.getShopCapacity());

        } else
            throw new ResourceNotFoundException("Shop not found");

    }


    public void deleteShop(int id) {
        Optional<Shop> shopDB = repository.findById(id);

        if (shopDB.isPresent())
            repository.delete(shopDB.get());
        else
            throw new ResourceNotFoundException("Shop not found");

    }
}
