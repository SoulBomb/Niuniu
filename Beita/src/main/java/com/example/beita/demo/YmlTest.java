package com.example.beita.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/nn")
public class YmlTest {

    @Resource
    public YmlVO ymlVO;

    @Resource
    public ThirdPlatformProperties t;

    @GetMapping("/mm")
    public Object ymlBack() {
//        Map<String, String> result = ymlVO.getHost();
//        System.out.println(result.get(1));
        String appId = t.getQinghai().getAppId();
        System.out.println(appId);
        return appId;
    }

}
