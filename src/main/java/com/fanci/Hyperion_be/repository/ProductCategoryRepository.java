package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
