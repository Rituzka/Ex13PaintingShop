package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Painting;
import com.itAcademy.ex13paintingshop.service.PaintingService;
import com.itAcademy.ex13paintingshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/shops")
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    @Autowired
    ShopService shopService;

    //get all paintings
    @GetMapping("/paintings")
    public List<Painting> getAllPaintingsByShopId(){
        return paintingService.getAllPaintings();
    }

    //find a painting by the id
    @GetMapping("/paintings/{id}")
    public Painting getPaintingById(@PathVariable(name = "id" ) Long id){
        return paintingService.getPaintingById(id);
    }

   // add a Painting to a Shop
    @PostMapping("/{shopId}/paintings")
    public void addPainting(@PathVariable(value = "shopId") Long shopId,
                            @RequestBody Painting painting){
        paintingService.addPaintingToAShop(shopId, painting);
    }

    //update a painting by id
    @PutMapping("paintings/{id}")
    public HttpStatus updatePaintingById(@PathVariable(name = "id") Long paintingId,
                               @RequestBody Painting painting){
        paintingService.updatePaintingById(paintingId, painting);
        return HttpStatus.OK;
    }


    @DeleteMapping("paintings/{id}")
    public ResponseEntity<?> deletePaintingById(@PathVariable(name = "id") Long paintingId){
        paintingService.deletePainting(paintingId);
        return ResponseEntity.ok().build();
    }
}
