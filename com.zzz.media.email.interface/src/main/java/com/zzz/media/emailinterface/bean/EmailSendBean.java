package com.zzz.media.emailinterface.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className EmailSendBean
 * @description TODO
 * @date 2022/5/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailSendBean {
    String title;
    String content;
    List<MultipartFile> files;
    List<EmailUser> reciver;
    EmailUser sender;
    ClientType clientType;
}
