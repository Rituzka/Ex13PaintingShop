package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Painting;
import com.itAcademy.ex13paintingshop.service.PaintingService;
import com.itAcademy.ex13paintingshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    @Autowired
    ShopService shopService;

    //get all paintings
    @GetMapping("/shops/paintings")
    public List<Painting> getAllPaintingsByShopId(){
        return paintingService.getAllPaintings();
    }


    //find a painting by the id
    @GetMapping(path = "/{id}")
    public Painting getPaintingById(@PathVariable(name = "id" ) Long id){
        return paintingService.getPaintingById(id);
    }

   // add a Painting to a Shop
    @PostMapping("/shops/{shopId}/paintings")
    public void addPainting(@PathVariable(value = "shopId") Long shopId,
                            @RequestBody Painting painting){
        paintingService.addPaintingToAShop(shopId, painting);
    }

    //update a painting by id
    @PutMapping("/shops/{paintingId}/paintings")
    public void updatePaintingById(@PathVariable(name = "paintingId") Long paintingId,
                               @RequestBody Painting painting){
        paintingService.updatePaintingById(paintingId, painting);
    }


    @DeleteMapping("/shops/{paintingId}/paintings")
    public HttpStatus deletePaintingById(@PathVariable(name = "paintingId") Long paintingId){
        paintingService.deletePainting(paintingId);
        return HttpStatus.OK;
    }
}
