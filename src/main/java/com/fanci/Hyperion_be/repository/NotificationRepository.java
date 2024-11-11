package com.fanci.Hyperion_be.repository;

import com.fanci.Hyperion_be.entity.Notification;
import com.fanci.Hyperion_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
