package com.egbas.CRUDpractice1.repository;

import com.egbas.CRUDpractice1.entity.Principal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrincipalRepository extends JpaRepository<Principal, Long> {
}
