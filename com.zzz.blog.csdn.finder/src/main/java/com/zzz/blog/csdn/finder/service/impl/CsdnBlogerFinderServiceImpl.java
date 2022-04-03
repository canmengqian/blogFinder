package com.zzz.blog.csdn.finder.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzz.blog.csdn.finder.config.prop.CsdnBlogerInfoProp;
import com.zzz.blog.csdn.finder.config.prop.CsdnRouterTopic;
import com.zzz.blog.csdn.finder.dto.BlogerInfoDTO;
import com.zzz.blog.csdn.finder.dto.Response;
import com.zzz.blog.csdn.finder.entity.CsdnBlogerInfo;


import com.zzz.blog.csdn.finder.mapper.CsdnBlogerInfoMapper;
import com.zzz.blog.csdn.finder.service.BlogerFinderService;
import com.zzz.blog.csdn.finder.vo.blog.BlogerQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("CsdnBlogerFinderServiceImpl")
@Slf4j
public class CsdnBlogerFinderServiceImpl implements BlogerFinderService<BlogerInfoDTO,CsdnBlogerInfoMapper> {

    @Resource
    CsdnBlogerInfoMapper csdnBlogerInfoMapper;

    private final static ObjectMapper jsonMapper = new ObjectMapper ();
    private static final int MAX_PAGE = 100;

    @Resource
    CsdnBlogerInfoProp csdnBlogerInfoProp;


    @Override
    public List<BlogerInfoDTO> getSubsciribeList(BlogerQuery query) throws JsonProcessingException {


        if (query.getUseSelef () == 1) {
         return   findSelfSubcribeBloger (query);
        }
        return   findOtherSubcribeBloger (query);
    }

    @Override
    public CsdnBlogerInfoMapper getMapper() {
        return csdnBlogerInfoMapper;
    }

    public List<BlogerInfoDTO> findSelfSubcribeBloger(BlogerQuery query) throws JsonProcessingException {
        csdnBlogerInfoMapper.executeUpdate ("DELETE FROM csdn_bloger_info");
        List<BlogerInfoDTO> all = new ArrayList<> ();
        HttpResponse response;
        String bodyJson = "";
        for (int i = 1; i <= MAX_PAGE; i++) {
            String url = getSubcribeUrl ();
            url = String.format (url, i + "", getSelfId ());
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
            }
        }
        List<CsdnBlogerInfo> entityes = new ArrayList<> ();
        all.forEach (b -> {
            CsdnBlogerInfo e= BeanUtil.copyProperties (b, CsdnBlogerInfo.class);
            e.setBlogerId (IdUtil.getSnowflake (1).nextIdStr ());
            e.setCdate (new Date ());
            e.setIsSelf (0);
            e.setExecSubcribeStatus (0);
            e.setUdate (new Date ());
            e.setId (b.getUsername ());
            e.setSourceId (query.getSourceType ());

            entityes.add (e);

        });
       entityes.forEach (e->{
          long hasFind= csdnBlogerInfoMapper.createLambdaQuery ().andEq (CsdnBlogerInfo::getId,e.getId ()).andEq (CsdnBlogerInfo::getSourceId,e.getSourceId ()).count ();
          if(hasFind == 0){
              csdnBlogerInfoMapper.insert (e);
          }
          else{
              log.warn ("该博客主已经抓取{},{}",e.getId (),e.getNickname ());
          }
       });
        return all;
    }

    public List<BlogerInfoDTO> findOtherSubcribeBloger(BlogerQuery query) throws JsonProcessingException {
        List<BlogerInfoDTO> all = new ArrayList<> ();
        HttpResponse response;
        String bodyJson = "";
        for (int i = 1; i <= MAX_PAGE; i++) {
            String url = getSubcribeUrl ();
            url = String.format (url, i + "", query.getBlogerId ());
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
            }
        }
        List<CsdnBlogerInfo> entityes = new ArrayList<> ();
        all.forEach (b -> {
            CsdnBlogerInfo e= BeanUtil.copyProperties (b, CsdnBlogerInfo.class);
            e.setBlogerId (IdUtil.getSnowflake (1).nextIdStr ());
            e.setCdate (new Date ());
            e.setIsSelf (0);
            e.setExecSubcribeStatus (0);
            e.setUdate (new Date ());
            e.setId (b.getUsername ());
            e.setSourceId (query.getSourceType ());

            entityes.add (e);

        });
        entityes.forEach (e->{
            long hasFind= csdnBlogerInfoMapper.createLambdaQuery ().andEq (CsdnBlogerInfo::getId,e.getId ()).andEq (CsdnBlogerInfo::getSourceId,e.getSourceId ()).count ();
            if(hasFind == 0){
                csdnBlogerInfoMapper.insert (e);
            }
            else{
                log.warn ("该博客主已经抓取{},{}",e.getId (),e.getNickname ());
            }
        });
        log.info ("总共抓取了{}条订阅者信息,博客主ID{}",entityes.size (),query.getBlogerId ());
      CsdnBlogerInfo blogerInfo=  csdnBlogerInfoMapper.createLambdaQuery ().andEq (CsdnBlogerInfo::getId,query.getBlogerId ()).single ();
        if(blogerInfo!=null){
            blogerInfo.setExecSubcribeStatus (1);
            blogerInfo.setExeDatetime (new Date ());
            csdnBlogerInfoMapper.updateById (blogerInfo);
        }
        return all;
    }


    private String getSelfId() {
        return csdnBlogerInfoProp.getSelfid ();
    }

    private String getSubcribeUrl() {
        return csdnBlogerInfoProp.getTopic ().stream ().filter (t -> "subcribe".equals (t.getTopicname ().toLowerCase (Locale.ROOT))).map (CsdnRouterTopic::getUrl).findAny ().get ();
    }
}
