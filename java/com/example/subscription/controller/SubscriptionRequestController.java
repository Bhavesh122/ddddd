package com.example.subscription.controller;

import com.example.subscription.model.SubscriptionRequest;
import com.example.subscription.service.SubscriptionRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin(origins = "*")
public class SubscriptionRequestController {
    private final SubscriptionRequestService service;

    public SubscriptionRequestController(SubscriptionRequestService service) {
        this.service = service;
    }

    // User submits a request
    @PostMapping("/request")
    public SubscriptionRequest createRequest(@RequestBody SubscriptionRequest request) {
        return service.createRequest(request);
    }

    // Admin gets all requests
    @GetMapping("/all")
    public List<SubscriptionRequest> getAllRequests() {
        return service.getAllRequests();
    }

    // User retrieves their own requests
    @GetMapping("/user/{email}")
    public List<SubscriptionRequest> getUserRequests(@PathVariable String email) {
        return service.getUserRequests(email);
    }

    // Admin approves or rejects a request
    @PutMapping("/{id}/status")
    public Optional<SubscriptionRequest> updateStatus(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam(required = false) String rejectionReason) {
        return service.updateStatus(id, status, rejectionReason);
    }
}
