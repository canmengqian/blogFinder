package com.zzz.media.email.component.email;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @description 简单邮件发送
 * @date 2022/6/2
 */
@Service
public interface SimpleEmailClient {

    void sendTextContent(String from, String to, String subject, String content) throws MessagingException;

    void sendTextContent(String from, List<String> to, String subject, String content) throws MessagingException;

    void sendMultiMail(String from, String to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException;

    void sendMultiMail(String from, List<String> to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException;


}
