package com.demo.test.utils;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 *
 * @author Jack
 * @date 2019/05/30  14:50:12
 */
public class MDUtils {

    private static final Logger logger = LoggerFactory.getLogger(MDUtils.class);

    /**
     * 加密
     *
     * @param origin      要被加密的字符串
     * @param charsetname 加密字符,如UTF-8
     * @date 2019/05/30  14:50:12
     */
    public static String MD5EncodeForHex(String origin, String charsetname)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return MD5EncodeForHex(origin.getBytes(charsetname));
    }

    public static String MD5EncodeForHex(byte[] origin) throws NoSuchAlgorithmException {
        return Hex.encodeHexString(digest("MD5", origin));
    }

    /**
     * 指定加密算法
     *
     * @throws NoSuchAlgorithmException
     * @date 2019/05/30  14:50:12
     */
    private static byte[] digest(String algorithm, byte[] source) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance(algorithm);
        return md.digest(source);
    }

    public static String encrypt(String toString) {
        return "";
    }
}