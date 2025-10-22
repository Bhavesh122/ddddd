package com1.yourcompany.domainmanagement.service;

import com1.yourcompany.domainmanagement.model.Domain;
import com1.yourcompany.domainmanagement.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    public List<Domain> getAllDomains() {
        return domainRepository.findAll();
    }

    public Domain addDomain(Domain domain) {
        domain.setId(UUID.randomUUID().toString());
        return domainRepository.save(domain);
    }
}
