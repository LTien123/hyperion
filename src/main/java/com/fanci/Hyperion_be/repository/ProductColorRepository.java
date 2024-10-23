package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.ProductColor;
import com.fanci.Hyperion_be.entity.ProductHandlebar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

    @Query("select a from ProductColor a where a.id =?1")
    Optional<ProductColor> findByProductColorId(Long id);

}
