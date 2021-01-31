package com.whrcbank.fabricsdkrestapi.service;

import com.whrcbank.fabricsdkrestapi.dao.ContractRepository;
import com.whrcbank.fabricsdkrestapi.dao.CustomToContractIdsRepository;
import com.whrcbank.fabricsdkrestapi.entity.Contract;
import com.whrcbank.fabricsdkrestapi.entity.CustomToContractIds;
import com.whrcbank.fabricsdkrestapi.entity.Response;
import com.whrcbank.fabricsdkrestapi.pojo.SignOffMysqlPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class MysqlService {
    @Resource
    private ContractRepository contractRepository;

    @Resource
    private CustomToContractIdsRepository customToContractIdsRepository;

    public Response sign(Contract contract){
        try {
            String customId = contract.getCustomID();
            String contractId = contract.getContractID();
            Contract tmp = contractRepository.findByContractID(contractId);
            if (tmp != null){
                log.info("contractId already exist");
                return Response.fail(1, "contractId already exist", null);
            }
            contract = contractRepository.save(contract);

            CustomToContractIds customToContractIds =
                    customToContractIdsRepository.findByCustomIdAndContractId(customId, contractId);

            if (customToContractIds != null){
                log.warn("DB error customToContractIds exist");
                return Response.success(contract);
            }

            customToContractIds = new CustomToContractIds();
            customToContractIds.setCustomId(customId);
            customToContractIds.setContractId(contractId);
            customToContractIdsRepository.save(customToContractIds);

            return Response.success(contract);
        }catch (Exception e){
            return Response.fail(1, "DB error", null);
        }
    }

    public Response signOff(SignOffMysqlPojo signOffMysqlPojo){
        try {
            String customId = signOffMysqlPojo.getCustomID();
            String contractId = signOffMysqlPojo.getContractID();

            CustomToContractIds customToContractIds =
                    customToContractIdsRepository.findByCustomIdAndContractId(customId, contractId);

            if (customToContractIds == null){
                log.info("already signOff");
                return Response.fail(1, contractId + "already signOff", null);
            }

            Contract contract = contractRepository.findByCustomIDAndContractID(customId, contractId);
            if (contract == null){
                log.warn("DB error contract not exist");
                return Response.fail(1, "DB error contract not exist", null);
            }

            contract.setSignStat(signOffMysqlPojo.getSignStat());
            contract.setSignStatDesc(signOffMysqlPojo.getSignStatDesc());
            contract.setSignOffDate(signOffMysqlPojo.getSignOffDate());
            contract.setExpiredDate(signOffMysqlPojo.getExpiredDate());
            contract.setLastUpdateSys(signOffMysqlPojo.getLastUpdateSys());
            contract.setLastUpdateUser(signOffMysqlPojo.getLastUpdateUser());
            contract.setLastUpdateTime(signOffMysqlPojo.getLastUpdateTime());
            contract = contractRepository.save(contract);

            customToContractIdsRepository.delete(customToContractIds);

            return Response.success(contract);
        }catch (Exception e){
            return Response.fail(1, "DB error", null);
        }
    }

    public Response checkEcif(Contract contract){
        try {
            String customId = contract.getCustomID();
            String contractId = contract.getContractID();
            Contract contract2 = contractRepository.findByContractID(contractId);

            CustomToContractIds customToContractIds =
                    customToContractIdsRepository.findByCustomIdAndContractId(customId, contractId);
            if (customToContractIds == null){
                if (contract2 == null){
                    return sign(contract);
                }
                customToContractIds = new CustomToContractIds();
                customToContractIds.setCustomId(customId);
                customToContractIds.setContractId(contractId);
                customToContractIdsRepository.save(customToContractIds);
            }

            contract = contractRepository.save(contract);
            return Response.success(contract);
        }catch (Exception e){
            return Response.fail(1, "DB error", null);
        }
    }

    public Response getAllByCustomId(String customId){
        List<CustomToContractIds> customToContractIds = customToContractIdsRepository.findAllByCustomId(customId);
        List<Contract> contracts = contractRepository.findAllByCustomID(customId);

        Set<String> v = new HashSet<>();
        List<Contract> ret = new ArrayList<>();
        for (CustomToContractIds customToContractIds1 : customToContractIds){
            v.add(customToContractIds1.getContractId());
        }

        for (Contract contract : contracts){
            if (v.contains(contract.getContractID())){
                ret.add(contract);
            }
        }
        return Response.success(ret);
    }
}
