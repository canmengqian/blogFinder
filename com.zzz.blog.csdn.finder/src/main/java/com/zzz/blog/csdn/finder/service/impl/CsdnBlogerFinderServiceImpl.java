package com.zzz.blog.csdn.finder.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzz.blog.csdn.finder.dto.BlogerInfoDTO;
import com.zzz.blog.csdn.finder.dto.Response;
import com.zzz.blog.csdn.finder.service.BlogerFinderService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service("CsdnBlogerFinderServiceImpl")
public class CsdnBlogerFinderServiceImpl implements BlogerFinderService<BlogerInfoDTO> {
    private final static ObjectMapper jsonMapper = new ObjectMapper ();
    private static final int MAX_PAGE = 100;

    private String DEST_FILE = "d://bloger.txt";

    @Override
    public List<BlogerInfoDTO> getSubsciribeList(String blogerId) throws JsonProcessingException {
        List<BlogerInfoDTO> all= new ArrayList<> ();
        HttpResponse response = null;
        String bodyJson = "";
        for (int i = 1; i <= MAX_PAGE; i++) {
            String url = "https://blog.csdn.net/community/home-api/v1/get-follow-list?page=%s&size=20&noMore=false&blogUsername=qq_17030015";
            url = String.format (url, i + "");
            response = HttpRequest.get (url).timeout (60000).execute (false);
            Response<BlogerInfoDTO> responseBlog = null;
            if (response != null && response.isOk ()) {
                bodyJson = response.body ();
            }
            if (CharSequenceUtil.isNotEmpty (bodyJson)) {
                responseBlog = jsonMapper.readValue (bodyJson, new TypeReference<Response<BlogerInfoDTO>> () {
                });
            }
            if (responseBlog == null) {
                break;
            }
            if (CollUtil.isEmpty (responseBlog.getData ().getList ())) {
                break;
            } else {
                all.addAll (responseBlog.getData ().getList ());
                FileUtil.writeLines (responseBlog.getData ().getList (), new File (DEST_FILE), Charset.defaultCharset (), false);
            }
        }

        return all;
    }

}
