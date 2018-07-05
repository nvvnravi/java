/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.FileInputStream;
import java.util.Properties;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.jasypt.salt.RandomSaltGenerator;

/**
 *
 * @author Ravi.Nistala
 */
public class BouncyCastleEncryption {
    public static void main (String[] args) throws Exception {
 StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
encryptor.setProvider(new BouncyCastleProvider());
encryptor.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
encryptor.setSaltGenerator(new RandomSaltGenerator());
encryptor.setKeyObtentionIterations(100000);
encryptor.setPasswordCharArray("The big fat cow jumped over the moon.".toCharArray());


Properties props = new EncryptableProperties(encryptor);
 props.load(new FileInputStream("C:/Users/nistr1/Documents/NetBeansProjects/stax/src/stax/datasource.properties"));
 
 /*
  * To get a non-encrypted value, we just get it with getProperty...
  */
 String datasourceUsername = props.getProperty("datasource.username");
 
 System.out.println("\n ## datasourceUsername : " + datasourceUsername);
 /*
  * ...and to get an encrypted value, we do exactly the same. Decryption will
  * be transparently performed behind the scenes.
  */ 
// String datasourcePassword = props.getProperty("datasource.password");
 
 //System.out.println("## datasourcePassword : " + datasourcePassword);
 
 System.out.println("## encrypt datatasourcePassword : " + encryptor.encrypt("Gdit1qaz(*)"));
 
  String datasourcePassword = props.getProperty("datasource.password");
 
 System.out.println("## datasourcePassword : " + datasourcePassword);
 
 System.out.println("## decrypted string : " + encryptor.decrypt("vdxRSA5EnhsxQu/AAJWItGCcICHIwAbdInDP/OwMK4k="));
 
 
 
 
    }
}
