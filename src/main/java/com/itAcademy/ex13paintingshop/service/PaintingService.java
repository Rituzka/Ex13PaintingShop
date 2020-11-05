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
    private IPaintingRepository paintingRepository;

    @Autowired
    private IShopRepository shopRepository;

    public List<Painting> getAllPaintings(){
        return paintingRepository.findAll();
    }
    public Painting getPaintingById(long id) {
        Optional<Painting> paintingDB = paintingRepository.findById(id);

        if(paintingDB.isPresent())
            return paintingDB.get();
        else
            throw new ResourceNotFoundException("Painting not found");
    }


    public void addPainting(Painting painting) {
        if(painting == null)
            throw new ResourceNotFoundException("Painting is null, are you sure you put all the information required?");
        else
            paintingRepository.save(painting);
    }


    public void updatePainting(Painting painting) {
        Optional<Painting> paintingDB = paintingRepository.findById(painting.getId());

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
