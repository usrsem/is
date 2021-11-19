package com.univer.informationsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.univer.informationsecurity.domain.Customer;
import java.util.UUID;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByUsername(String username);
}
