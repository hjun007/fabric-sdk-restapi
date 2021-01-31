package com.whrcbank.fabricsdkrestapi.dao;

import com.whrcbank.fabricsdkrestapi.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
    Contract findByCustomIDAndContractID(String customId, String contractId);
    Contract findByContractID(String contractId);
    List<Contract> findAllByCustomID(String customId);
}
