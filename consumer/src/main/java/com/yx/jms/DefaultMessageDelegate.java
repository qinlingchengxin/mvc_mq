package com.yx.jms;

import java.io.Serializable;
import java.util.Map;

/**
 * 默认消息监听器
 */
public class DefaultMessageDelegate implements MessageDelegate {

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void handleMessage(Map message) {
        System.out.println(message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println(message);
    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println(message);
    }

}
