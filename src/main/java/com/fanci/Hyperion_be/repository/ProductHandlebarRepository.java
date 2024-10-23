package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.ProductHandlebar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductHandlebarRepository extends JpaRepository<ProductHandlebar, Long> {
@Query("select a from ProductHandlebar a where a.id =?1")
Optional<ProductHandlebar> findByProductHandlebarId(Long id);
}
