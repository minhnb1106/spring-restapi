package com.minhnb.spring.restapi.repository;

import com.minhnb.spring.restapi.entity.Account;
import com.minhnb.spring.restapi.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, UUID> {

    Optional<Payroll> findByAccount(Account account);

}
