/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;


import java.io.FileInputStream;
import java.util.Properties;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.digest.config.EnvironmentStringDigesterConfig;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor; 
import org.jasypt.properties.EncryptableProperties;
import org.jasypt.salt.RandomSaltGenerator;
/**
 *
 * @author Ravi.Nistala
 */
public class encryptor {
    
    public static void main (String[] args) throws Exception {
        
        
        EnvironmentStringDigesterConfig esdc = new EnvironmentStringDigesterConfig(); 
        esdc.setAlgorithm("sha-1"); 
        esdc.setIterations(10000); 
        esdc.setSaltGenerator(new RandomSaltGenerator()); 
        
         StandardStringDigester ssd = new StandardStringDigester(); 
        ssd.setConfig(esdc); 
        
        /*
  * First, create (or ask some other component for) the adequate encryptor for
  * decrypting the values in our .properties file.
  */
 StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
 encryptor.setPassword("jasypt"); // could be got from web, env variable...
 //encryptor.setPasswordCharArray(new char[[C@2f92e0f4]);
 encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
 
 /*
  * Create our EncryptableProperties object and load it the usual way.
  */
 Properties props = new EncryptableProperties(encryptor);
 props.load(new FileInputStream("C:/Users/nistr1/Documents/NetBeansProjects/stax/src/stax/datasource.properties"));
 
 
 
 System.out.println("## to char array : " + "jasypt".toCharArray());
 char[] archar = "012jasypttest".toCharArray();
 System.out.printf("\n%s",archar);
 System.out.printf("\n%s",archar[1]);
 
 
 /*
  * To get a non-encrypted value, we just get it with getProperty...
  */
 String datasourceUsername = props.getProperty("datasource.username");
 
 System.out.println("\n ## datasourceUsername : " + datasourceUsername);
 /*
  * ...and to get an encrypted value, we do exactly the same. Decryption will
  * be transparently performed behind the scenes.
  */ 
 String datasourcePassword = props.getProperty("datasource.password");
 
 System.out.println("## datasourcePassword : " + datasourcePassword);

    }
    
}
