package com.mq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yanyugang
 * @description
 * @date 2019-10-12 10:39
 */
@Component
public class ParamConfig {
    @Value("${fee-plat.fee-plat-group}")
    public String feePlatGroup;
    @Value("${fee-plat.fee-plat-topic}")
    public String feePlatTopic;
    @Value("${fee-plat.fee-account-tag}")
    public String feeAccountTag;
}