/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

//import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Ravi.Nistala
 */
public class DumpPrivateKey {
    
    static public void main(String[] args)
    throws Exception {
        
        
        final String keystoreName = "keystore-1.jks";
        final String keystorePassword = "changeit";
        final String alias = "client";
        final String keyPassword ="changeit";// getKeyPassword(args,keystorePassword);
        KeyStore ks = KeyStore.getInstance("jks");
        ks.load(new FileInputStream(keystoreName), keystorePassword.toCharArray());
        Key key = ks.getKey(alias, keyPassword.toCharArray());
       
        String b64 = new BASE64Encoder().encode(key.getEncoded());
        //String b64 = new String(Base64.encodeBase64(key.getEncoded(),true));
        System.out.println("-----BEGIN PRIVATE KEY-----");
        System.out.println(b64);
        System.out.println("-----END PRIVATE KEY-----");
        
        System.out.println("-----BEGIN PRIVATE CERT-----");
        System.out.println(ks.getCertificate("client"));
        System.out.println("-----END PRIVATE CERT-----");
        
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest("password".getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println("----- hexString.toString().toUpperCase()  256  :  "+ hexString.toString().toUpperCase());
            
            
            
            
             digest = MessageDigest.getInstance("SHA-512");
            hash = digest.digest("password".getBytes("UTF-8"));
             hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println("----- hexString.toString().toUpperCase() 512   :  "+ hexString.toString().toUpperCase());
    }
    
}
