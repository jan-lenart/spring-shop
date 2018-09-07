package com.janlenart.springshop.bo.repository;

import com.janlenart.springshop.bo.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
