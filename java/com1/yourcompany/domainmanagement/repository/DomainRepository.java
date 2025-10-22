package com1.yourcompany.domainmanagement.repository;

import com1.yourcompany.domainmanagement.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, String> {
}
