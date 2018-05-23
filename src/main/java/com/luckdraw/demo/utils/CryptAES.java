package com.luckdraw.demo.utils;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;


/**
 * Created by zhq on 16/4/7.
 */
public class CryptAES {
    private static Logger log = Logger.getLogger(CryptAES.class);
    private static final String AESTYPE ="AES/ECB/PKCS5Padding";
    private static final String KEY ="dfe996vkwgTf7wBl";

    public static String AES_Encrypt(String plainText) {
        byte[] encrypt = null;
        String result=null;
        try{
            Key key = generateKey(KEY);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
            result =  new String(Base64.encode(encrypt));
        }catch(Exception e){
            log.error("加密失败", e);
        }
//        return new String(Base64.encodeBase64(encrypt));
        return result;
    }

    public static String AES_Decrypt(String encryptData) {
        byte[] decrypt = null;
        try{
            Key key = generateKey(KEY);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.decode(encryptData));
        }catch(Exception e){
            log.error("解密失败", e);
        }
        return new String(decrypt).trim();
    }


    private static Key generateKey(String key)throws Exception {
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        }catch(Exception e){
            log.error("获得key失败", e);
            throw e;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = new String(encrypt("nihao","dfe996vkwgTf7wBl"),"utf-8");
        System.out.print(a);
    }

    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者

            kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
            // 128位的key生产者
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行

            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥

            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
            // null。

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥

            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
