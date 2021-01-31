package com.whrcbank.fabricsdkrestapi.service;

import com.github.samyuan1990.FabricJavaPool.FabricConnectionPoolFactory;
import com.github.samyuan1990.FabricJavaPool.config.FabricJavaPoolConfig;
import com.github.samyuan1990.FabricJavaPool.api.FabricConnection;
import com.whrcbank.fabricsdkrestapi.entity.Response;
import com.whrcbank.fabricsdkrestapi.pojo.SignOffPojo;
import com.whrcbank.fabricsdkrestapi.pojo.SignRecordPojo;
import com.whrcbank.fabricsdkrestapi.properties.SDKConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SDKService {

    public static GenericObjectPool<FabricConnection> pool = null;
    FabricJavaPoolConfig config = null;
    private FabricConnection fabricConnection = null;

    @Resource
    private SDKConfigProperties sdkConfigProperties;

    @PostConstruct
    public void init() throws Exception {
//        FabricJavaPoolConfig.setConfigFile(sdkConfigProperties.getPoolPath());
//        config = new FabricJavaPoolConfig();
//        System.out.println(config.toString());
//        pool = FabricConnectionPoolFactory.getSDKPool(config.getUser(), config.getChannelName());
//        fabricConnection = pool.borrowObject();
    }

    public Response sign(SignRecordPojo signRecordPojo) throws Exception {
        String res = fabricConnection.invoke("whrcbank", "signing", signRecordPojo.getSignRecordJson()).getResult();
        return Response.success(res);
    }

    public Response signMultiThread(SignRecordPojo signRecordPojo) throws Exception {
        List<String> records = signRecordPojo.getSignRecordsJson();
        List<CompletableFuture<Void>> list = new ArrayList<>();
        int remain = records.size();
        if (remain == 0){
            return Response.fail(1, "empty args", null);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (records.size() - 1) / 100 + 1; i++){
            int step = Math.min(remain, 100);
            for (int j = 0; j < step; j++){
                int finalJ = j;
                int finalI = i;
                CompletableFuture<Void> completableFuture =  CompletableFuture.supplyAsync(() ->{
                    try {
                        result.add(fabricConnection.invoke("whrcbank", "signing", records.get(finalJ +100* finalI)).getResult());
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    return null;
                });
                list.add(completableFuture);
                CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
                try {
                    combinedFuture.get();
                }catch (Exception e){
                    //e.printStackTrace();
                }
            }
            remain -= 100;
        }
        return Response.success(result);
    }

    public Response signOff(SignOffPojo signOffPojo) throws Exception {
        String res = fabricConnection.invoke("whrcbank", "signOff", signOffPojo.getSignOffJson()).getResult();
        return Response.success(res);
    }

    public Response checkEcif(SignRecordPojo signRecordPojo) throws Exception {
        String res = fabricConnection.invoke("whrcbank", "checkEcif", signRecordPojo.getSignRecordJson()).getResult();
        return Response.success(res);
    }

    public Response checkEcifMultiThread(SignRecordPojo signRecordPojo) throws Exception{
        List<String> records = signRecordPojo.getSignRecordsJson();
        List<CompletableFuture<Void>> list = new ArrayList<>();
        int remain = records.size();
        if (remain == 0){
            return Response.fail(1, "empty args", null);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (records.size() - 1) / 100 + 1; i++){
            int step = Math.min(remain, 100);
            for (int j = 0; j < step; j++){
                int finalJ = j;
                int finalI = i;
                CompletableFuture<Void> completableFuture =  CompletableFuture.supplyAsync(() ->{
                    try {
                        result.add(fabricConnection.invoke("whrcbank", "checkEcif", records.get(finalJ +100* finalI)).getResult());
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    return null;
                });
                list.add(completableFuture);
                CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
                try {
                    combinedFuture.get();
                }catch (Exception e){
                    //e.printStackTrace();
                }
            }
            remain -= 100;
        }
        return Response.success(result);
    }

    public Response checkBatchEcif(SignRecordPojo signRecordPojo) throws Exception {
        System.out.println(signRecordPojo.getSignRecordsJson().toString());
        String res = fabricConnection.invoke("whrcbank", "checkBatchEcif", signRecordPojo.getSignRecordsJson().toString()).getResult();
        return Response.success(res);
    }

    public Response getContractIDsByCustID(String customID) throws Exception {
        String res = fabricConnection.query("whrcbank", "getContractIDsByCustID", customID).getResult();
        return Response.success(res);
    }

    public Response getContractsByCustID(String customID) throws Exception {
        String res = fabricConnection.query("whrcbank", "getContractsByCustID", customID).getResult();
        return Response.success(res);
    }
}
