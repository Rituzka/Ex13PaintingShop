package com.itAcademy.ex13paintingshop.repository;

import com.itAcademy.ex13paintingshop.model.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaintingRepository extends JpaRepository<Painting, Long> {

    Page<Painting> findByShopId(Long id, Pageable pageable);

    Optional<Painting> findByIdAndShopId(Long id, Long shopId);

}
