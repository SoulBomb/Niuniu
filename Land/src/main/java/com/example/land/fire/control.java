package com.example.land.fire;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.example.land.file.FileDemo;
import com.example.land.oss.OSSDemo;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StreamUtils;
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
    public String ll() throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();
//        JSONObject body = new JSONObject();
//        body.put("appId", "1551474023015591936");
//        body.put("appSecret", "62de4a66e4b0a6e6309b0e033xa5u4rjeo");
//        body.put("token", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxNzEsInVzZXJfa2V5IjoiYWFjYjJlZTMtZWFiOS00NDliLTk4MmYtZTMwOGRiNGFhZDllIiwidXNlcm5hbWUiOiJsdnNoYW9qdW4ifQ.1KG_6VoX5aeV_iA9Z0LLduQCbfARKRF2EjNyP-MQTverKE8jRPW_3901kxSm6gtQ3RdzMZ_ZqUr79aObzs9K-Q");
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), body.toJSONString());
//        Request.Builder builder = new Request.Builder();
//        builder.url("http://211.138.64.10:8089/prod-api/system/api/sys/users/auth/login").post(requestBody);
//        Map<String, String> headers = new HashMap<>(4);
//        headers.put("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxNzEsInVzZXJfa2V5IjoiYWFjYjJlZTMtZWFiOS00NDliLTk4MmYtZTMwOGRiNGFhZDllIiwidXNlcm5hbWUiOiJsdnNoYW9qdW4ifQ.1KG_6VoX5aeV_iA9Z0LLduQCbfARKRF2EjNyP-MQTverKE8jRPW_3901kxSm6gtQ3RdzMZ_ZqUr79aObzs9K-Q");
//        headers.put("requestId", "qweqw1231231");
//        if (headers != null) {
//            builder.headers(Headers.of(headers));
//        }
        Request.Builder builder = new Request.Builder();
        builder.url("http://36.133.154.67:8000/gateway/oss-file/ossNonce/NjNlMDRkM2MzZDE1NG" +
                "M5YWE5MGQwOTY2MjU1OGU4OWU3NzNhYmM2MDI2YjM0OGEzYWEyNWE3ZjM0NmUyYzUwOTZkZmQwMWE" +
                "5OTUwOGZhNzkzNGVhOGRjNWFhOGM4YmFl").get();
        Request request = builder.build();
        Call eventCall = okHttpClient.newCall(request);
        Response execute = eventCall.execute();
        System.out.println(execute);
        InputStream ii = execute.body().byteStream();

        FileOutputStream ss = new FileOutputStream("C:\\Users\\wanji\\Downloads\\tt.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(ii);
        ss.write(bytes);
        return "string";
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

    @Autowired
    private Map<String, Tt> tt = new HashMap<>();

    @Autowired
    private SpringContextUtil springContextUtil;

    @GetMapping("aa")

    public String aa() {
        ApplicationContext applicationContext = springContextUtil.getApplicationContext();
        Ad ad = (Ad) applicationContext.getBean("ad");
        System.out.println(ad.hashCode());
        tt.forEach((k, v) -> {
            if (v instanceof Ad){
                System.out.println(v.hashCode());
            }
        });
        return "success";
    }
}
