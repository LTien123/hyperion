package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidTokenRepository extends JpaRepository<InvalidToken, String> {
}
