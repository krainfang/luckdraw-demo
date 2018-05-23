package com.luckdraw.demo.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64 {
	 /**    
     * BASE64解密   
   * @param key          
     * @return          
     * @throws Exception
     */              
    public static byte[] decode(String key) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(key);
    }               
                  
    /**         
     * BASE64加密   
   * @param key          
     * @return          
     * @throws Exception
     */              
    public static String encode(byte[] key)  {
        return (new BASE64Encoder()).encodeBuffer(key);
    }  
}
