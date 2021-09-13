package site.waconde.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5ProduceUtil {
    /**
     * 提供md5加密编码为UTF-8的字符串，并输出16进制密文
     *
     * @param source 原文
     * @return String 16进制密文
     * @author side.wang
     * @since 2019年10月21日
     */
    public static String encrypte(String source) {
        return encrypte(source, "md5", "UTF-8", 16);
    }

    /**
     * 提供使用指定方式加密编码为UTF-8的字符串，并输出16进制密文
     *
     * @param source                原文
     * @param encrypteAlgorithmType 加密方式
     * @return String 16进制密文
     * @author side.wang
     * @since 2019年10月21日
     */
    public static String encrypte(String source, String encrypteAlgorithmType) {
        return encrypte(source, encrypteAlgorithmType, "UTF-8", 16);
    }

    /**
     * 提供使用指定方式加密指定编码格式的字符串，并输出16进制密文
     *
     * @param source                原文
     * @param encrypteAlgorithmType 加密方式
     * @param encoding              原文编码
     * @return String 16进制密文
     * @author side.wang
     * @since 2019年10月21日
     */
    public static String encrypte(String source, String encrypteAlgorithmType, String encoding) {
        return encrypte(source, encrypteAlgorithmType, encoding, 16);
    }

    /**
     * 提供使用指定方式加密指定编码格式的字符串，并输出指定进制的密文
     *
     * @param source                原文
     * @param encrypteAlgorithmType 加密方法
     * @param encoding              原文编码
     * @param radix                 密文进制
     * @return String 指定进制的密文
     * @author side.wang
     * @since 2019年10月21日
     */
    public static String encrypte(String source, String encrypteAlgorithmType, String encoding, int radix) {
        MessageDigest encrypteAlgorithm = null;
        try {
            encrypteAlgorithm = MessageDigest.getInstance(encrypteAlgorithmType);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有指定的加密算法：" + encrypteAlgorithmType);
        }
        try {
            encrypteAlgorithm.update(source.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码：" + encoding);
        }
        byte[] ciphertextByte = encrypteAlgorithm.digest();
        String ciphertext = new BigInteger(ciphertextByte).toString(radix);
        return ciphertext;
    }
}
