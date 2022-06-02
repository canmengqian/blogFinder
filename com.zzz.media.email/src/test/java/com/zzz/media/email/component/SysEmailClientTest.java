package com.zzz.media.email.component;

import com.zzz.media.email.component.email.SysEmailClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.Arrays;

@SpringBootTest
public class SysEmailClientTest {

    @Resource
    SysEmailClient client;

    @Test
    public void sendTextContent() throws MessagingException {
        client.sendTextContent("2570389155@qq.com", "2570389155@qq.com", "测试邮件", "这是一封测试邮件");
    }

    @Test
    public void sendTextContentMulti() throws MessagingException {
        client.sendTextContent("2570389155@qq.com", Arrays.asList("1205983855@qq.com", "2570389155@qq.com"), "测试邮件", "这是一封测试邮件");
    }
}