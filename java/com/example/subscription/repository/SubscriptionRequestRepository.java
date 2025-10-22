package com.example.subscription.repository;

import com.example.subscription.model.SubscriptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionRequestRepository extends JpaRepository<SubscriptionRequest, Long> {
    List<SubscriptionRequest> findByEmail(String email);
}
