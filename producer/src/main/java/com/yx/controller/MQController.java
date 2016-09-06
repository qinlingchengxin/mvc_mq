package com.yx.controller;

import com.yx.jms.MsgProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "mq")
public class MQController {

    @Resource
    private MsgProducer msgProducer;

    /**
     * 发送文本消息   队列
     *
     * @return
     */
    @RequestMapping(value = "sendTextMsgQueue")
    @ResponseBody
    public Map<String, Object> sendTextMsgQueue() {
        Map<String, Object> obj = new HashMap<String, Object>();
        msgProducer.sendTextMsgQueue();
        obj.put("msg", "success");
        return obj;
    }

    /**
     * 发送对象消息   队列
     *
     * @return
     */
    @RequestMapping(value = "sendObjectMsgQueue")
    @ResponseBody
    public Map<String, Object> sendObjectMsgQueue() {
        Map<String, Object> obj = new HashMap<String, Object>();
        msgProducer.sendObjectMsgQueue();
        obj.put("msg", "success");
        return obj;
    }

    /**
     * 发送文本消息   主题
     *
     * @return
     */
    @RequestMapping(value = "sendTextMsgTopic")
    @ResponseBody
    public Map<String, Object> sendTextMsgTopic() {
        Map<String, Object> obj = new HashMap<String, Object>();
        msgProducer.sendTextMsgTopic();
        obj.put("msg", "success");
        return obj;
    }

    /**
     * 发送对象消息   主题
     *
     * @return
     */
    @RequestMapping(value = "sendObjectMsgTopic")
    @ResponseBody
    public Map<String, Object> sendObjectMsgTopic() {
        Map<String, Object> obj = new HashMap<String, Object>();
        msgProducer.sendObjectMsgTopic();
        obj.put("msg", "success");
        return obj;
    }

}
