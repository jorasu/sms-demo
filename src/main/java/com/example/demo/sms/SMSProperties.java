package com.example.demo.sms;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
@Component
@ConfigurationProperties(prefix = "sms.send")
@ConditionalOnProperty(prefix = "sms.send", value = "account")
public class SMSProperties {
    @NotNull
    private String wsHost;
    @NotNull
    private int wsPort;
    @NotNull
    private String cmHost;
    @NotNull
    private int cmPort;
    @NotNull
    private String account;
    @NotNull
    private String loginPassword;
    @NotNull
    private String sendPassword;
    @NotNull
    private String lztzMsg;

    public String getWsHost() {
        return wsHost;
    }

    public void setWsHost(String wsHost) {
        this.wsHost = wsHost;
    }

    public int getWsPort() {
        return wsPort;
    }

    public void setWsPort(int wsPort) {
        this.wsPort = wsPort;
    }

    public String getCmHost() {
        return cmHost;
    }

    public void setCmHost(String cmHost) {
        this.cmHost = cmHost;
    }

    public int getCmPort() {
        return cmPort;
    }

    public void setCmPort(int cmPort) {
        this.cmPort = cmPort;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getSendPassword() {
        return sendPassword;
    }

    public void setSendPassword(String sendPassword) {
        this.sendPassword = sendPassword;
    }

    public String getLztzMsg() {
        return lztzMsg;
    }

    public void setLztzMsg(String lztzMsg) {
        this.lztzMsg = lztzMsg;
    }

}
