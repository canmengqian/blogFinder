package com.zzz.blog.csdn.finder.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsdnBlogerFinderServiceImplTest {

    @Test
    void getSubsciribeList() {
        CsdnBlogerFinderServiceImpl  service = new CsdnBlogerFinderServiceImpl ();
        service.getSubsciribeList ("");
    }
}