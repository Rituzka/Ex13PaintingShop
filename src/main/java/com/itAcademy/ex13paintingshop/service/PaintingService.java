package com.itAcademy.ex13paintingshop.service;

import com.itAcademy.ex13paintingshop.exceptions.ResourceNotFoundException;
import com.itAcademy.ex13paintingshop.model.Painting;
import com.itAcademy.ex13paintingshop.model.Shop;
import com.itAcademy.ex13paintingshop.repository.IPaintingRepository;
import com.itAcademy.ex13paintingshop.repository.IShopRepository;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaintingService {

    private final IPaintingRepository paintingRepository;
    private final IShopRepository shopRepository;

    public PaintingService(IPaintingRepository paintingRepository, IShopRepository shopRepository) {
        this.paintingRepository = paintingRepository;
        this.shopRepository = shopRepository;
    }

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
    // Dummy data
    @PostConstruct
    public void populateTestData() {
        List<Shop> shops = shopRepository.findAll();

        if (shopRepository.count() == 0) {
            shops.add(new Shop("White Collar 1", 254));
            shops.add(new Shop("White Collar 2", 396));
            shops.add(new Shop("White Collar 3", 157));
        }

        if (paintingRepository.count() == 0) {
            Random r = new Random(0);
            paintingRepository.saveAll(
                    Stream.of("Gabrielle", "Robinson", "Haugen",
                            "Koen", "Macdonald", "Karlsson", "Gustavsson", "Svensson",
                            "Stewart", "Corinne", "Ryann", "Jackson", "Kelly",
                            "Walker")

                            .map(name -> {
                                Painting painting = new Painting();
                                painting.setPaintingName(name);
                                painting.setPaintingPrice(r.nextFloat() * 100);
                                painting.setArrivalDate("12/10/2020");
                                painting.setAuthor(name + "ius");
                                painting.setShop(shops.get(r.nextInt(shops.size())));
                                return painting;
                            }).collect(Collectors.toList()));

        }
    }

}
