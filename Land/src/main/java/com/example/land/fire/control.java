package com.example.land.fire;

import com.example.land.oss.OSSDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/nn")
public class control {

    @GetMapping("mm")
    public String mm(HttpServletResponse response) {
        OSSDemo ossDemo = new OSSDemo();
        InputStream inputStream = ossDemo.ossMethod();

        if (null == inputStream) {
            return "啥也没有";
        }
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = inputStream.read(b)) != -1) {
                out.write(b, 0, len);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "success";
    }
}
