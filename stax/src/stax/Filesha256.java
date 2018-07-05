/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jonelo.jacksum.JacksumAPI;
import jonelo.jacksum.algorithm.AbstractChecksum;

/**
 *
 * @author Ravi.Nistala
 */
public class Filesha256 {
    
     public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, IOException, Exception {
          AbstractChecksum checksum = null;
          AbstractChecksum checksum1 = null;
   try {
     // select an algorithm (md5 in this case)
     checksum = JacksumAPI.getChecksumInstance("sha-256");     
     checksum1 = JacksumAPI.getChecksumInstance("sha-256");     
   } catch (NoSuchAlgorithmException nsae) {
     // message that algorithm doesn't exist
   } 
   
   checksum.readFile("C:\\rps-1\\coverLetter.pdf"); // ...
   System.out.println("1"+checksum);
   File f = new File("C:\\rps-1\\coverLetter.pdf");
   
   // updates the checksum with the content of a file
  InputStream in = new FileInputStream(f);   
   hashFile(in,"sha-256");
  // CloseShieldInputStream cs= new CloseShieldInputStream(in);
  //BufferedInputStream bis  = new BufferedInputStream(cs);;
  // System.out.println("2"+in);
  
// InputStream i2=IOUtils.toBufferedInputStream(in); 
   //checksum1.readFile(in); // ...
   
  //  BufferedInputStream bis = new BufferedInputStream(in);
    
  //InputStream input = new BufferedInputStream(new FileInputStream("C:\\rps-1\\MySQLPassword.txt"));
  /**
  InputStream input = new BufferedInputStream(new FileInputStream("C:\\rps-1\\coverLetter.pdf"));
byte[] buffer = new byte[8192];

try {
    for (int length = 0; (length = input.read(buffer)) != -1;) {
        System.out.write(buffer, 0, length);
    }
} finally {
    input.close();
}
  
  
ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//byte[] buffer = new byte[1024];
int len;
while ((len = in.read(buffer)) > -1 ) {
      byteArrayOutputStream.write(buffer, 0, len);
}
//System.out.println("byteArrayOutputStream : "+byteArrayOutputStream.toString());
InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray()); 
 //System.out.println("3"+inputStream);
 



    checksum1.readFile(input); // ...
    //checksum1.readFile(is); // ...
    byteArrayOutputStream.flush();
    byteArrayOutputStream.close();
    in.close();
   //System.out.println(checksum1);
   
    //cs.close();
    */
}    
 

private static String convertByteArrayToHexString(byte[] arrayBytes) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < arrayBytes.length; i++) {
        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                .substring(1));
    }
    System.out.println(stringBuffer.toString());
    return stringBuffer.toString();
}


private static String hashFile(InputStream file, String algorithm)
        throws Exception {
    try  {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
 
        byte[] bytesBuffer = new byte[1024];
        int bytesRead = -1;
 
        while ((bytesRead = file.read(bytesBuffer)) != -1) {
            digest.update(bytesBuffer, 0, bytesRead);
        }
 
        byte[] hashedBytes = digest.digest();
 
        return convertByteArrayToHexString(hashedBytes);
    } catch (NoSuchAlgorithmException | IOException ex) {
        throw new Exception(
                "Could not generate hash from file", ex);
    }
}
     
}
