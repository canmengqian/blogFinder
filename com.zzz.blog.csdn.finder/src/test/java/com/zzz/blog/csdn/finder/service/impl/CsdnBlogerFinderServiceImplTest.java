package com.zzz.blog.csdn.finder.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.beetl.sql.core.db.MySqlStyle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsdnBlogerFinderServiceImplTest {

    @Test
    void getSubsciribeList() throws JsonProcessingException {
        CsdnBlogerFinderServiceImpl  service = new CsdnBlogerFinderServiceImpl ();
        service.getSubsciribeList ("");
    }
}