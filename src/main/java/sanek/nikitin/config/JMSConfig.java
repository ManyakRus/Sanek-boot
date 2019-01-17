/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.nikitin.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 *
 * @author Пользователь2
 */
@Configuration
@EnableJms
public class JMSConfig {
    
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
    
	@Bean
	public Queue outQueue() {
		return new ActiveMQQueue("outQueue");
	}

}
