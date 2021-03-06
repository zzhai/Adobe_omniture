package com.adobe.omniture.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
  
import sun.misc.BASE64Encoder;
  
public class GatewayUtils {
  private static SecureRandom rand = new SecureRandom();
   
  private static byte[] toSHA1(byte[] data) throws NoSuchAlgorithmException {
    MessageDigest md = null;
    md = MessageDigest.getInstance("SHA-1");
    return md.digest(data);
  }
   
  public static String generateWSSEHeader(String clientId, String clientSecret) throws IOException, NoSuchAlgorithmException {
    BASE64Encoder b64 = new BASE64Encoder();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    StringBuffer wsseHeader = new StringBuffer();
    String created = dateFormatter.format(new Date());
    ByteArrayOutputStream digest = new ByteArrayOutputStream(40);   
    byte[] nonce = new byte[20];
     
    rand.nextBytes(nonce);
     
    digest.write(nonce);
    digest.write(created.getBytes());
    digest.write(clientSecret.getBytes());
  
    wsseHeader.append("UsernameToken Username=\"");
    wsseHeader.append(clientId);
    wsseHeader.append("\", PasswordDigest=\"");
    wsseHeader.append(b64.encode(toSHA1(digest.toByteArray())));
    wsseHeader.append("\", Nonce=\"");
    wsseHeader.append(b64.encode(nonce));
    wsseHeader.append("\", Created=\"");
    wsseHeader.append(created);
    wsseHeader.append("\"");
     
    return wsseHeader.toString();
  }
  
}
