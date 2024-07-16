package com.example.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scheduler.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
