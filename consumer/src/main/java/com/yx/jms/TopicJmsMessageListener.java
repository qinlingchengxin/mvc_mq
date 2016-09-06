package com.yx.jms;

import com.yx.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component("topicJmsMessageListener")
public class TopicJmsMessageListener implements MessageListener {

    @Autowired
    private AtomicInteger counter = null;

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                String msg = tm.getText();
                System.out.println("消息客户端正在接受主题消息,接受到的消息是:" + msg);
                counter.incrementAndGet();
            } else if (message instanceof ObjectMessage) {
                ObjectMessage om = (ObjectMessage) message;
                User user = (User) om.getObject();
                System.out.println(user);
                counter.incrementAndGet();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
