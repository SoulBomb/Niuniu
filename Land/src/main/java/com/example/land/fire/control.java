package com.example.land.fire;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.example.land.file.FileDemo;
import com.example.land.oss.OSSDemo;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class control {

    @Autowired
    public FileDemo fileDemo;

    @GetMapping("mm")
    public String oss(HttpServletResponse response) {
        OSSDemo ossDemo = new OSSDemo();
        InputStream inputStream = ossDemo.ossMethod();

        if (null == inputStream) {
            return "啥也没有";
        }
        OutputStream out;
        try {
            out = response.getOutputStream();
            int len;
            byte[] b = new byte[1024];
            while ((len = inputStream.read(b)) != -1) {
                out.write(b, 0, len);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("nn")
    public String localFile(HttpServletResponse response) {
        String result = fileDemo.fileDown();
        File file = new File("芜湖.zip");
        try {
            FileInputStream zis = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            int len;
            byte[] b = new byte[1024];
            while ((len = zis.read(b)) > 0) {
                out.write(b, 0, len);
            }
            out.flush();
            zis.close();
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("qq")
    public String ll() throws Exception{
        OkHttpClient okHttpClient = new OkHttpClient();
        JSONObject body = new JSONObject();
        body.put("appId", "1551474023015591936");
        body.put("appSecret", "62de4a66e4b0a6e6309b0e033xa5u4rjeo");
        body.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxNzEsInVzZXJfa2V5IjoiNjFmMWJhZTEtODM0ZS00NDE3L" +
                "WE4NmMtZTZjMjY0OTRmZmMwIiwidXNlcm5hbWUiOiJsdnNoYW9qdW4ifQ." +
                "-2qw3Rr3ekmxVex-QxbKEyAydLFdcaa6XlO8EDiWfYRmv_es-mZJsbeVnl7CYXrInk1lnrZzzdJjJXbMIG4Gxg");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), body.toJSONString());
        Request.Builder builder = new Request.Builder();
        builder.url("http://211.138.64.10:8089/prod-api/system/api/sys/users/auth/login").post(requestBody);
        Map<String, String> headers = new HashMap<>(4);
        headers.put("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxNzEsInVzZXJfa2V5IjoiNjFmMWJhZTEtODM0ZS00NDE3L" +
                "WE4NmMtZTZjMjY0OTRmZmMwIiwidXNlcm5hbWUiOiJsdnNoYW9qdW4ifQ." +
                "-2qw3Rr3ekmxVex-QxbKEyAydLFdcaa6XlO8EDiWfYRmv_es-mZJsbeVnl7CYXrInk1lnrZzzdJjJXbMIG4Gxg");
        headers.put("requestId", "qweqw1231231");
        if (headers != null) {
            builder.headers(Headers.of(headers));
        }
        Request request = builder.build();
        Call eventCall = okHttpClient.newCall(request);
        Response execute = eventCall.execute();
        System.out.println(execute);
        System.out.println(execute.body().source());
        return execute.body().toString();
    }


    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @GetMapping("get")
    public boolean get() {
        return useLocalCache;
    }

    @NacosInjected
    private NamingService namingService;

    @GetMapping("gets")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
