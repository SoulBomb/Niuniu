package com.example.land.fire;

import com.example.land.file.FileDemo;
import com.example.land.oss.OSSDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
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
    public String ll() {
        return "ok";
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
