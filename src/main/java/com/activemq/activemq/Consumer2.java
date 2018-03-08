package com.activemq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * ${todo}...
 * ${tags}
 * 消费者2
 * @author ${user}
 * @version 1.0
 * @company 洛阳艾克科技有限公司
 * @copyright (c) ${year} LuoYang ARC Co'Ltd Inc. All rights reserved.
 * @date ${date} ${time}
 * @since JDK1.8
 */

@Component
public class Consumer2 {
    /**监听队列 接受消息*/
    @JmsListener(destination = "mytest.queue")
    /**消费者消息以后，的反馈消息，返回另一个队列，然后实现cycle机制*/
    @SendTo("out.queue")
    public String reveiceQueue (String text){
 //       System.out.println("------Consumer2接受到的消息是-----:"+text);
        return "返回的信息是："+text;
    }

    @JmsListener(destination = "mytest.topic",containerFactory = "topicListenerFactory")
    public void reveiceTopic(String text){
        //System.out.println("Consumer2接受到的topic信息: "+text);
    }
}
