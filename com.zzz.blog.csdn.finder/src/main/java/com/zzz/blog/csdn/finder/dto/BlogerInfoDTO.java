package com.zzz.blog.csdn.finder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class BlogerInfoDTO {

    String username;
    String nickname;
    String userAvatar;
    String blogUrl;
    String loginUserNameIsFollow;
    String blogExpert;
    String briefIntroduction;
    int id;
    List<BlogerInfoDTO> list;
}
