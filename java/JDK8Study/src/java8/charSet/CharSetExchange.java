package java8.charSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharSetExchange {

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/java8/charSet/UTF8文件")), "UTF-8");
        System.out.println("content：" + content);
        String gbk = new String(content.getBytes("UTF-8"), "GBK");
        System.out.println("gbk：" + gbk);
        String utf8 = new String(gbk.getBytes("GBK"), "UTF-8");
        System.out.println("utf8：" + utf8);
    }

}
