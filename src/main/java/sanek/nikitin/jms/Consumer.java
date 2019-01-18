/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sanek.nikitin.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    private String allMessages = "";

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @JmsListener(destination = "sample.queue")
    //@SendTo("outQueue")
    public void receiveQueue(String text) {
        System.out.println(text);

        allMessages = allMessages + text + "<br/>";
        
        //return text;
    }


    public String getAll() {
//        String result = "";
//        Message mess = null;
//        TextMessage tMess;
//
//        try {
//            do {
//                mess = (Message) jmsMessagingTemplate.receive(queue);
//                tMess = (TextMessage) mess;
//                result = result + tMess.getText() + "/n";
//            } while (mess != null);            
//        } catch (JMSException ex) {
//            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return allMessages;
    }

    public String getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(String allMessages) {
        this.allMessages = allMessages;
    }
    
    
    
}
