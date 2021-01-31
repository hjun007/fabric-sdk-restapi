package com.whrcbank.fabricsdkrestapi.dao;

import com.whrcbank.fabricsdkrestapi.entity.Contract;
import com.whrcbank.fabricsdkrestapi.entity.CustomToContractIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomToContractIdsRepository extends JpaRepository<CustomToContractIds, Long> {
    List<CustomToContractIds> findAllByCustomId(String customId);
    CustomToContractIds findByCustomIdAndContractId(String customId, String contractId);
}
