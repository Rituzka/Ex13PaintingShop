package com.itAcademy.ex13paintingshop.repository;

import com.itAcademy.ex13paintingshop.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaintingRepository extends JpaRepository<Painting, Integer> {


}
