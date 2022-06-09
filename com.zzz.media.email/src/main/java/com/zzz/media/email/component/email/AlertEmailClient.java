package com.zzz.media.email.component.email;

import com.zzz.media.email.component.email.subject.TraceSubjectJoiner;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className AlertEmailClient
 * @description
 * @date 2022/6/2
 */
@Service("AlertEmailClient")
public class AlertEmailClient implements SimpleEmailClient {

    private TraceLevel level;

    private SimpleEmailClient delegatorClient;

    private static final TraceSubjectJoiner JOINER = new TraceSubjectJoiner();

    public TraceLevel getLevel() {
        return level;
    }

    public void setLevel(TraceLevel level) {
        this.level = level;
    }

    public SimpleEmailClient getDelegatorClient() {
        return delegatorClient;
    }

    public void setDelegatorClient(SimpleEmailClient delegatorClient) {
        this.delegatorClient = delegatorClient;
    }

    @Override
    public void sendTextContent(String from, String to, String subject, String content) throws MessagingException {
        sendTextContent(from, Arrays.asList(to), subject, content);
    }

    @Override
    public void sendTextContent(String from, List<String> to, String subject, String content) throws MessagingException {
        subject = joinSubject(subject);
        delegatorClient.sendTextContent(from, to, subject, content);
    }

    @Override
    public void sendMultiMail(String from, String to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException {
        sendMultiMail(from, Arrays.asList(to), subject, attachFiles);
    }

    @Override
    public void sendMultiMail(String from, List<String> to, String subject, List<MultiAttachFile> attachFiles) throws MessagingException {
        subject = joinSubject(subject);
        delegatorClient.sendMultiMail(from, to, subject, attachFiles);
    }

    private String joinSubject(String subject) {
        return JOINER.join(subject, level);
    }
}
