package com.janlenart.springshop.bo.repository;

import com.janlenart.springshop.bo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
