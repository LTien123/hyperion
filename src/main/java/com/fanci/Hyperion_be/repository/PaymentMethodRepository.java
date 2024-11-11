package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository  extends JpaRepository<PaymentMethod, Long> {
}
