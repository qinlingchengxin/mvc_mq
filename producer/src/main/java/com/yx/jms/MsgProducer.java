package com.yx.jms;

import com.yx.bean.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component("msgProducer")
public class MsgProducer {

    @Resource
    private JmsTemplate jmsTemplate;

    //队列消息
    @Resource(name = "queue.destination")
    private Destination queueDestination;

    //主题消息
    @Resource(name = "topic.destination")
    private Destination topicDestination;

    public void sendTextMsgQueue() {
        try {
            jmsTemplate.send(queueDestination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("队列文本消息");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendObjectMsgQueue() {
        try {
            jmsTemplate.send(queueDestination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    User user = new User(1, "object_queue", 26, "china");
                    return session.createObjectMessage(user);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendTextMsgTopic() {
        try {
            jmsTemplate.send(topicDestination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("主题文本消息");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendObjectMsgTopic() {
        try {
            jmsTemplate.send(topicDestination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    User user = new User(2, "object_topic", 27, "china");
                    return session.createObjectMessage(user);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
