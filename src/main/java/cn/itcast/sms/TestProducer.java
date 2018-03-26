package cn.itcast.sms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试生产者类
 */
@RestController
public class TestProducer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@RequestMapping("/sendSms")
	public void sendSms(){
		Map map = new HashMap<>();
		map.put("mobile", "17301394670");
		map.put("template_code", "SMS_128641067");
		map.put("sign_name", "小敏商城");
		map.put("param", "{\"code\":\"777777\"}");
		jmsMessagingTemplate.convertAndSend("sms", map);
		
		
	}
}
