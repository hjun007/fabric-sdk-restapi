package com.whrcbank.fabricsdkrestapi.controller;

import com.whrcbank.fabricsdkrestapi.entity.Contract;
import com.whrcbank.fabricsdkrestapi.entity.Response;
import com.whrcbank.fabricsdkrestapi.pojo.SignOffMysqlPojo;
import com.whrcbank.fabricsdkrestapi.service.MysqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "Mysql Controller")
public class MysqlController {
    @Resource
    private MysqlService mysqlService;

    @PostMapping("mysql/signing")
    @ApiOperation(value = "单笔签约", notes = "")
    public Response sign(@RequestBody Contract contract){
        return mysqlService.sign(contract);
    }

    @PostMapping("mysql/signOff")
    @ApiOperation(value = "单笔解约")
    public Response signOff(@RequestBody SignOffMysqlPojo signOffMysqlPojo){
        return mysqlService.signOff(signOffMysqlPojo);
    }

    @PostMapping("mysql/checkEcif")
    public Response checkEcif(@RequestBody Contract contract){
        return mysqlService.checkEcif(contract);
    }

    @GetMapping("mysql/findAll/{customId}")
    public Response getAllByCustomId(@PathVariable(value = "customId") String customId){
        return mysqlService.getAllByCustomId(customId);
    }
}
