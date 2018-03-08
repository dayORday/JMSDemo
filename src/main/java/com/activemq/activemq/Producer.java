package com.activemq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * ${todo}...
 * ${tags}
 *
 * @author ${user}
 * @version 1.0
 * @company 洛阳艾克科技有限公司
 * @copyright (c) ${year} LuoYang ARC Co'Ltd Inc. All rights reserved.
 * @date ${date} ${time}
 * @since JDK1.8
 */
@Service("producer")
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /**消息生产者*/
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 接受从消费者哪里返回的消息
     * @param text
     */
    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text){
        //System.out.println("从out.queue返回的消息是"+text);
    }
}
