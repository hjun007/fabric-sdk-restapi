package com.whrcbank.fabricsdkrestapi.controller;

import com.whrcbank.fabricsdkrestapi.entity.Response;
import com.whrcbank.fabricsdkrestapi.pojo.SignOffPojo;
import com.whrcbank.fabricsdkrestapi.pojo.SignRecordPojo;
import com.whrcbank.fabricsdkrestapi.service.SDKService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "SDK Controller")
public class SDKController {
    @Resource
    private SDKService sdkService;

    @PostMapping("/signing")
    @ApiOperation(value = "单笔签约", notes = "参数填signRecordJson，signRecordsJson不填")
    public Response signing(@RequestBody SignRecordPojo signRecordPojo) throws Exception {
        return sdkService.sign(signRecordPojo);
    }

    @PostMapping("/signOff")
    @ApiOperation(value = "单笔解约")
    public Response signOff(@RequestBody SignOffPojo signOffPojo) throws Exception {
        return sdkService.signOff(signOffPojo);
    }

    @PostMapping("/checkEcif")
    @ApiOperation(value = "ecif单笔签约记录核对", notes = "参数填signRecordJson，signRecordsJson不填")
    public Response checkEcif(@RequestBody SignRecordPojo signRecordPojo) throws Exception {
        return sdkService.checkEcif(signRecordPojo);
    }

    @PostMapping("/checkBatchEcif")
    @ApiOperation(value = "ecif批量签约记录核对", notes = "参数填signRecordsJson，signRecordJson不填")
    public Response checkBatchEcif(@RequestBody SignRecordPojo signRecordPojo) throws Exception {
        return sdkService.checkBatchEcif(signRecordPojo);
    }

    @GetMapping("/contractIDs/{customID}")
    @ApiOperation(value = "获取customID已签约的签约号")
    public Response getContractIDsByCustomID(@PathVariable(value = "customID") String customID) throws Exception {
        return sdkService.getContractIDsByCustID(customID);
    }

    @GetMapping("/contracts/{customID}")
    @ApiOperation(value = "获取customID已签约的签约记录详细数据")
    public Response getContractsByCustomID(@PathVariable(value = "customID") String customID) throws Exception {
        return sdkService.getContractsByCustID(customID);
    }

    @PostMapping("/signMT")
    @ApiOperation(value = "多线程签约", notes = "参数填signRecordsJson，signRecordJson不填。参数中的客户号不能有相同的，签约号也不能有相同的")
    public Response signMT(@RequestBody SignRecordPojo signRecordPojo) throws Exception {
        return sdkService.signMultiThread(signRecordPojo);
    }

    @PostMapping("/checkEcifMT")
    @ApiOperation(value = "多线程ecif批量核对签约记录", notes = "参数填signRecordsJson，signRecordJson不填。参数中的客户号不能有相同的，签约号也不能有相同的")
    public Response checkEcifMT(@RequestBody SignRecordPojo signRecordPojo) throws Exception {
        return sdkService.checkEcifMultiThread(signRecordPojo);
    }

}
