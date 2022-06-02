package com.zzz.media.email.component.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MultiAttachFile
 * @description
 * @date 2022/6/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class MultiAttachFile {
    String name;
    File file;
}
