package com.example.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafka.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
