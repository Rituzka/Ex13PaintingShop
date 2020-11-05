package com.itAcademy.ex13paintingshop.controller;

import com.itAcademy.ex13paintingshop.model.Painting;
import com.itAcademy.ex13paintingshop.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController("api/v1/shops/paintings")
public class PaintingController {

    @Autowired
    PaintingService paintingService;

    //get all paintings
    @GetMapping
    public List<Painting> getAllPaintings(){
        return paintingService.getAllPaintings();
    }

    //get painting by id
    @GetMapping(path = "/{id}")
    public Painting getPaintingById(@PathVariable(name = "id" ) long id){
        return paintingService.getPaintingById(id);
    }

    //add a new painting
    @PostMapping
    public void addPainting(@RequestBody Painting painting){
        paintingService.addPainting(painting);
    }

    //update a painting
    @PutMapping("/{id}")
    public void updatePainting(@PathVariable(name = "id") long id ,@RequestBody Painting painting){
        painting.setId(id);
        paintingService.updatePainting(painting);
    }

    //Delete one Painting by id
    @DeleteMapping("/{id}")
    public HttpStatus deletePainting(@PathVariable(name = "id") long id){
        paintingService.deletePainting(id);
        return HttpStatus.OK;
    }
}
