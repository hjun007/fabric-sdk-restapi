package com.whrcbank.fabricsdkrestapi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "sdk")
public class SDKConfigProperties {
    private String poolPath;

    public String getPoolPath() {
        return poolPath;
    }

    public void setPoolPath(String poolPath) {
        this.poolPath = poolPath;
    }
}
