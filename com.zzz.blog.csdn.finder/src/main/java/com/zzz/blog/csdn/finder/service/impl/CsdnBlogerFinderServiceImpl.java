package com.zzz.blog.csdn.finder.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.zzz.blog.csdn.finder.dto.CsdnBlogerCrawlerResponse;
import com.zzz.blog.csdn.finder.service.BlogerFinderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CsdnBlogerFinderServiceImpl")
public class CsdnBlogerFinderServiceImpl implements BlogerFinderService<CsdnBlogerCrawlerResponse> {
    private  static  final int MAX_PAGE = 100;
    @Override
    public List<CsdnBlogerCrawlerResponse> getSubsciribeList(String blogerId) {
        HttpResponse  response = null;
        String bodyJson = "";
        String url = "https://blog.csdn.net/community/home-api/v1/get-follow-list?page=%s&size=20&noMore=false&blogUsername=qq_17030015";
        for(int i =2 ;i<=2;i++){
            url = String.format (url,i+"");
            response=HttpRequest.get (url).timeout (60000).execute (false);
            if(response!=null && response.isOk ()){
                bodyJson = response.body ();
                System.out.println (bodyJson);

            }
            else{
                break;
            }
        }

        return null;
    }

}
