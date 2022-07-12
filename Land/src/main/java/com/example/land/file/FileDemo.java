package com.example.land.file;

import cn.hutool.core.util.CharsetUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author jihl
 */
@Component
public class FileDemo {

    /**
     * 这里以压缩图片为例子
     */
    public String fileDown() {
        File fileDir = new File("D:\\tt");
        File[] files = fileDir.listFiles();
        if (files != null) {
            jdkZip(files);
        }
        return "success";
    }

    //原生jdk方法
    private void jdkZip(File[] files) {
        ZipOutputStream zip;
        try {
            //jdk中不指定路径时表示相对路径，他会保存到项目主目录当中  这里则为 Niuniu/芜湖.zip
            zip = new ZipOutputStream(new FileOutputStream(("芜湖.zip")), CharsetUtil.defaultCharset());
            for (File file : files) {
                //压缩包里创建一个空文件
                zip.putNextEntry(new ZipEntry("new" + file.getName()));
                //想压缩包中的空文件写入数据
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zip.write(buffer, 0, len);
                }
            }
            zip.flush();
            zip.closeEntry();
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //hutool工具类
    private void hutoolZip(File[] files) {
        //没有声明目录的话，创建的zip文件会保存到target\classes下
        for (File file : files) {

        }
    }
}
