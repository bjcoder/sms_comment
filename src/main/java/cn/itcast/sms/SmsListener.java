package cn.itcast.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by a2363196581 on 2018/3/26.
 */
@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String,String> map)  {
        try {
            SendSmsResponse sendSms = smsUtil.sendSms(map.get("mobile"), map.get("template_code"), map.get("sign_name"), map.get("param"));
            System.out.println(sendSms.getBizId());
            System.out.println(sendSms.getCode());
            System.out.println(sendSms.getMessage());
            System.out.println(sendSms.getRequestId());
        }catch (Exception e){

        }

    }
}
