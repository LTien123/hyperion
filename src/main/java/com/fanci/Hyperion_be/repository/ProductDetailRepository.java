package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    @Query("select a from ProductDetail a where a.product.name = ?1 and a.isActive is true ")
    List<ProductDetail> findProductDetailByProductName(String productName);

    @Query("select a from ProductDetail  a where a.id =?1 and a.isActive is true")
    Optional<ProductDetail> findProductDetailById(Long id);

}
