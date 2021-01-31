package com.whrcbank.fabricsdkrestapi;

import com.whrcbank.fabricsdkrestapi.properties.SDKConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({
        SDKConfigProperties.class
})
public class FabricSdkRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabricSdkRestapiApplication.class, args);
    }

}
