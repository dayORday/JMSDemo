package com.activemq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ${todo}...
 * ${tags}
 *  消息消费者
 * @author ${user}
 * @version 1.0
 * @company 洛阳艾克科技有限公司
 * @copyright (c) ${year} LuoYang ARC Co'Ltd Inc. All rights reserved.
 * @date ${date} ${time}
 * @since JDK1.8
 */

/**
 * 消费者1
 */
@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    private static int count =1;
    /**
     * 消费者 使用jmslistener监听目标队列中是否有消息，如果有着取出消
     * @param text
     */
    @JmsListener(destination = "mytest.queue",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text) {
        //System.out.println(Thread.currentThread().getName()+ " queue ** Consumer收到的报文为:"+text);
    }

    /**
     * 接受topic的信息
     * @param text
     */
    @JmsListener(destination = "mytest.topic",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text){
        System.out.println(Thread.currentThread().getName()+"  ** Consumer收到的topic信息为："+text+" ("+(count++)+")");
    }
}
