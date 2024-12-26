package com.wfm.workforcemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wfm.workforcemanager.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{

}
