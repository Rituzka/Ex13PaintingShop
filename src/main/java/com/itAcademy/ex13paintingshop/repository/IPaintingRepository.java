package com.itAcademy.ex13paintingshop.repository;

import com.itAcademy.ex13paintingshop.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPaintingRepository extends JpaRepository<Painting, Long> {


    Optional<Painting> findByIdAndShopId(Long id, Long shopId);

}
