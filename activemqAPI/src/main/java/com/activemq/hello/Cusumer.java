package com.activemq.hello;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;

/**
 * 消息发送方
 * 
 * @author CHENCHAO
 *
 */
public class Cusumer {

	public static void main(String[] args) throws JMSException {
		// 1.创建链接工厂 参数用户名 ，密码 ，默认端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://127.0.0.1:61616");
		// 2.利用连接工厂拿到连接
		Connection connection = connectionFactory.createConnection();
		// 3.利用connection来启动连接
		connection.start();
		// 4.利用Connection对象来创建Session 参数1 是否配置事务，参数配置2为签收模式，一般我们设为
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 5.通过Session创建Destination对象，指定客户端产生消息目标对象
		Destination destination = session.createQueue("q1");
		// 6.我们可以使用MessageProducer的setDeliay
		MessageConsumer   messageConsumer= session.createConsumer(destination);
		// 7.设置消息持久化信息
	//	messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// 8.创建对象，并发送数据
	//	TextMessage textMessage = session.createTextMessage();
		
	  TextMessage message = (TextMessage) messageConsumer.receive();
	   System.out.println(message.getText());
	  
		// 9.关掉connection
		if(connection !=null) {
			connection.close();
		}
	}

}