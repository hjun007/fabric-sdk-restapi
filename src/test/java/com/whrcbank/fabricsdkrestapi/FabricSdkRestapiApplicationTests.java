package com.whrcbank.fabricsdkrestapi;

import com.whrcbank.fabricsdkrestapi.dao.ContractRepository;
import com.whrcbank.fabricsdkrestapi.entity.Contract;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class FabricSdkRestapiApplicationTests {
    @Resource
    private ContractRepository contractRepository;

    @Test
    void contextLoads() {
//        Contract contract = new Contract();
//        contract.setContractID("1");
//        contract.setCustID("1");
//        contract = contractRepository.save(contract);
//        System.out.println(contract);
    }

}
