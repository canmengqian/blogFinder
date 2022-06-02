package com.zzz.media.email.component.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className EmailClient
 * @description 邮件客户端
 * @date 2022/6/2
 */
@Service("SysEmailClient")
public class SysEmailClient implements SimpleEmailClient {
    @Resource
    private JavaMailSender mailSender;

    /**
     * @return
     * @Param
     * @Param from
     * @Param to
     * @Param subject
     * @Param content
     * @author zhengzz
     * @description 发送文本
     * @date 15:24 2022/6/2
     **/
    @Override
    public void sendTextContent(String from, String to, String subject, String content) throws MessagingException {
        sendTextContent(from, Arrays.asList(to), subject, content);
    }

    /**
     * @return
     * @Param
     * @Param from
     * @Param to
     * @Param subject
     * @Param content
     * @author zhengzz
     * @description TODO
     * @date 15:24 2022/6/2
     **/
    @Override
    public void sendTextContent(String from, List<String> to, String subject, String content) throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, false);
        Date now = new Date();
        helper.setFrom(from);
        helper.setTo((String[]) to.toArray());
        helper.setSentDate(now);
        helper.setSubject(subject);
        helper.setText(content);
        mailSender.send(mimeMailMessage);
    }

    @Override
    public void sendMultiMail(String from, String to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException {
        sendMultiMail(from, Arrays.asList(to), subject, attachFiles);
    }

    @Override
    public void sendMultiMail(String from, List<String> to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
        Date now = new Date();
        helper.setFrom(from);
        helper.setTo((String[]) to.toArray());
        helper.setSentDate(now);
        helper.setSubject(subject);
        for (MultiAttachFile f : attachFiles) {
            helper.addAttachment(f.getName(), f.getFile());
        }
        mailSender.send(mimeMailMessage);
    }
}
