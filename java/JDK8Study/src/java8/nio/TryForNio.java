package java8.nio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryForNio {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        /* 
         * 获取指定路径的文件内容。
         * Paths.get("文件全名")：从本项目的根路径开始拼接并尝试获取。JDK8Study/文件全名
         * Paths.get("路径名1", "路径名2", "文件全名")：从本项目的根路径开始拼接并尝试获取。JDK8Study/路径名1/路径名2/文件全名
         * Paths.get("/路径名", "文件全名")：从指定的/路径名开始拼接并尝试获取。/路径名/文件全名
         */
        String utf8 = new String(Files.readAllBytes(Paths.get("src/java8/charSet/UTF8文件")), "UTF-8");
    }

}
