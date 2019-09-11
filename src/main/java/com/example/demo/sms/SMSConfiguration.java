package com.example.demo.sms;

import com.esms.PostMsg;
import com.esms.common.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
@ConditionalOnProperty(prefix = "sms.send", value = "account")
public class SMSConfiguration {
    @Autowired
    private SMSProperties smsProperties;

    @Bean("ztbdAccount")
    @ConditionalOnProperty(prefix = "sms.send", value = "account")
    @ConditionalOnBean(SMSProperties.class)
    public Account getAccount() {
        return new Account(smsProperties.getAccount(), smsProperties.getSendPassword());
    }

    @Bean("ztbdPostMsg")
    @ConditionalOnProperty(prefix = "sms.send", value = "account")
    @ConditionalOnBean(SMSProperties.class)
    public PostMsg getPostMsg() {
        PostMsg pm = new PostMsg();

        pm.getCmHost().setHost(smsProperties.getCmHost(), smsProperties.getCmPort());
        pm.getWsHost().setHost(smsProperties.getWsHost(), smsProperties.getWsPort());

        return pm;
    }
}
