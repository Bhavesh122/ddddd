package com1.yourcompany.domainmanagement.controller;

import com1.yourcompany.domainmanagement.model.Domain;
import com1.yourcompany.domainmanagement.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domains")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @GetMapping
    public List<Domain> getAllDomains() {
        return domainService.getAllDomains();
    }

    @PostMapping
    public Domain addDomain(@RequestBody Domain domain) {
        return domainService.addDomain(domain);
    }
}
