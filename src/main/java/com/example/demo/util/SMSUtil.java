package com.example.demo.util;

import com.esms.MessageData;
import com.esms.PostMsg;
import com.esms.common.entity.Account;
import com.esms.common.entity.GsmsResponse;
import com.esms.common.entity.MTPack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

/**
 * MT短信通知工具类
 */
@Component
public class SMSUtil {
    private static final String BATCH_NAME = "泰州政务";

    private static PostMsg postMsg;
    private static Account account;

    @Autowired(required = false)
    public SMSUtil(PostMsg postMsg, Account account) {
        SMSUtil.postMsg = postMsg;
        SMSUtil.account = account;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static String doSendSms(List<MessageData> msgs) throws Exception {
        if (null == postMsg || null == account) {
            return "未进行短信相关配置";
        }

        if (CollectionUtils.isEmpty(msgs)) {
            return "没有传入要发送的手机号码和内容";
        }

        MTPack pack = new MTPack();
        pack.setBatchID(UUID.randomUUID());
        pack.setBatchName(BATCH_NAME);
        pack.setMsgType(MTPack.MsgType.SMS);
        pack.setBizType(1);
        pack.setDistinctFlag(false);
        pack.setSendType(MTPack.SendType.MASS);

        pack.setMsgs(msgs);

        GsmsResponse resp = postMsg.post(account, pack);

        return resp.getMessage();
    }
}
