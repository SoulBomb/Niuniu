package com.example.beita.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/nn")
public class YmlTest {

    @Resource
    public YmlVO ymlVO;

    @GetMapping("/mm")
    public Object ymlBack() {
        Map<Integer, String> result = ymlVO.getHost();
        System.out.println(result.get(1));
        return result;
    }

}
