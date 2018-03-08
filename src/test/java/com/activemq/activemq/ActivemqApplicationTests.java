package com.activemq.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		Destination destination = new ActiveMQQueue("mytest.queue");
		Destination destination1 =new ActiveMQTopic("mytest.topic");
		for(int i=0; i<10; i++){
			producer.sendMessage(destination, "myname is chhliu!!!");
			producer.sendMessage(destination1,"*************myName is zjt**************");
		}
	}

}
