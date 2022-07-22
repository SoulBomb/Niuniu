package com.example.beita.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaojunlv
 * @date 2022/3/2 上午10:08
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "third")
public class ThirdPlatformProperties {
    private AnfangProperties anfang=new AnfangProperties();
    private HejiaqinProperties hejiaqin=new HejiaqinProperties();
    private QinghaiProperties qinghai=new QinghaiProperties();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class AnfangProperties {
        private String baseUrl;
        private String appKey;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class HejiaqinProperties{
        private String baseUrl;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class QinghaiProperties{
        private String url;
        private String appId;
        private String appSecret;
    }
}
