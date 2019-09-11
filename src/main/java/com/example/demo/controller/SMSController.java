package com.example.demo.controller;

import com.esms.MessageData;
import com.example.demo.dao.SjdMapper;
import com.example.demo.sms.SMSProperties;
import com.example.demo.util.SMSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sms")
public class SMSController  {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    SMSProperties prop;

    @Autowired
    private SjdMapper sjdMapper;

    @RequestMapping(value = "/sendSMS4Lz", method = { RequestMethod.GET, RequestMethod.POST })
    public void getSjSpAj(String ywh) throws Exception {
        Map<String, String> sjd = sjdMapper.getSjdByYwh(ywh);
        List<MessageData> msgs=new ArrayList<>();
        String msgTemp = new String(prop.getLztzMsg().getBytes(StandardCharsets.ISO_8859_1),
                StandardCharsets.UTF_8);
        MessageData msg = new MessageData(sjd.get("TZRLXDH"),
                String.format(msgTemp, sjd.get("TZRXM"), ywh));
        msgs.add(msg);
        String res = SMSUtil.doSendSms(msgs);
    }
}
