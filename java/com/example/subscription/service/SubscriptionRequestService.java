package com.example.subscription.service;

import com.example.subscription.model.SubscriptionRequest;
import com.example.subscription.repository.SubscriptionRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionRequestService {
    private final SubscriptionRequestRepository repository;

    public SubscriptionRequestService(SubscriptionRequestRepository repository) {
        this.repository = repository;
    }

    public List<SubscriptionRequest> getAllRequests() {
        return repository.findAll();
    }

    public List<SubscriptionRequest> getUserRequests(String email) {
        return repository.findByEmail(email);
    }

    public SubscriptionRequest createRequest(SubscriptionRequest request) {
        request.setStatus("Pending");
        return repository.save(request);
    }

    public Optional<SubscriptionRequest> updateStatus(Long id, String status, String rejectionReason) {
        Optional<SubscriptionRequest> record = repository.findById(id);
        record.ifPresent(r -> {
            r.setStatus(status);
            if (rejectionReason != null) r.setRejectionReason(rejectionReason);
            repository.save(r);
        });
        return record;
    }
}
