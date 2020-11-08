package com.itAcademy.ex13paintingshop.service;

import com.itAcademy.ex13paintingshop.exceptions.ResourceNotFoundException;
import com.itAcademy.ex13paintingshop.model.Painting;
import com.itAcademy.ex13paintingshop.repository.IPaintingRepository;
import com.itAcademy.ex13paintingshop.repository.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PaintingService {

    @Autowired
    IPaintingRepository paintingRepository;

    @Autowired
    IShopRepository shopRepository;

    //get a list of all paintings
    public List<Painting> getAllPaintings(){
        return paintingRepository.findAll();
    }

   //get a painting by id
    public Painting getPaintingById(long id) {
        Optional<Painting> paintingDB = paintingRepository.findById(id);

        if(paintingDB.isPresent())
            return paintingDB.get();
        else
            throw new ResourceNotFoundException("Painting not found");
    }

    //add a painting to an specific shop
    public Painting addPaintingToAShop(Long shopId, Painting painting) {
        return shopRepository.findById(shopId).map(shop -> {
            painting.setShop(shop);
            return paintingRepository.save(painting);
        }).orElseThrow(() -> new ResourceNotFoundException("ShopId" + shopId
                + "not found"));
    }

  //update painting by id
    public void updatePaintingById(Long paintingId, Painting painting) {
        Optional<Painting> paintingDB = paintingRepository.findById(paintingId);

        if(paintingDB.isPresent()) {
            Painting paintingToUpdate = paintingDB.get();
            paintingToUpdate.setId(painting.getId());
            paintingToUpdate.setPaintingName(painting.getPaintingName());
            paintingToUpdate.setPaintingPrice(painting.getPaintingPrice());
            paintingToUpdate.setArrivalDate(painting.getArrivalDate());
            paintingToUpdate.setAuthor(painting.getAuthor());

        } else
            throw new ResourceNotFoundException("Painting not found");
    }

    public void deletePainting(long id) {
        Optional<Painting> paintingDB = paintingRepository.findById(id);

        if (paintingDB.isPresent())
            paintingRepository.delete(paintingDB.get());
        else
            throw new ResourceNotFoundException("Painting not found");
    }
}
