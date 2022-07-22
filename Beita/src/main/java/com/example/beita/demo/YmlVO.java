package com.example.beita.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "ymltest")
@Slf4j
public class YmlVO {
    private String todo;
    private Map<String, String> host;
}
