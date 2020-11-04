package com.itAcademy.ex13paintingshop.repository;

import com.itAcademy.ex13paintingshop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends JpaRepository<Shop, Integer> {



}
