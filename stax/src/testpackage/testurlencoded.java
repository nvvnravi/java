/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author Ravi.Nistala
 */
public class testurlencoded {
    
    public static void main (String[] args) throws Exception {
        String url1=URLEncoder.encode("useless test data (small).txt","UTF-8");//.replace("+", "%20");
        String url2=URLDecoder.decode("useless%20test%20data%20(small).txt", "UTF-8");
        String s2="useless%20test%20data%20(small).txt";
        System.out.println("URLEncoder.encode : "+url1);
        System.out.println("URLDecoder.decode : "+url2);
        if("useless test data (small).txt".equals(url2)){
            System.out.println("true");
        }else System.out.println("false");
        
        buildFromDomainCXFormatted("5cfe5f4f31604fa^^^&1.3.6.1.4.1.21367.2005.3.7&ISO");
        buildFromDomainCXFormatted("5cfe5f4f31604fa^^^&amp;1.3.6.1.4.1.21367.2005.3.7&amp;ISO");
        
        
        String test="the man is lazy";
        System.out.println(test.indexOf("is"));
        System.out.println(test.substring(test.indexOf("is")));
        
    }
    
    
     private static void buildFromDomainCXFormatted(String domainCXFormatted) {
        // 5cfe5f4f31604fa^^^&1.3.6.1.4.1.21367.2005.3.7&ISO
        String parts[] = domainCXFormatted.split("\\^");
        if (parts.length >= 4) {
            //this.identifier = parts[0];
 System.out.println(parts.length);
            // Assigning authority.
            String[] aa=null;
if(domainCXFormatted.indexOf("&amp;") >= 0)  {
     aa= parts[3].split("\\&amp;");
}else{
     aa= parts[3].split("\\&");
}
            if (aa.length > 0) {
                System.out.println(aa[0]);
            }
            if (aa.length > 1) {
               System.out.println(aa[1]);
            }
            if (aa.length > 2) {
               System.out.println(aa[2]);
            }
        }
    }
}
