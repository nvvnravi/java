/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.util.Arrays;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Ravi.Nistala
 */
public class Jsouptest {
   public static void main(String args[]) {
       String s1 ="<br> retretretretreyre<br><blockquote><br>From: test3 <test3@direct.gdit.net> <br> Sent:Wed, 11 Apr 2018 18:12 <br> To:test3 <test3@direct.gdit.net> <br> Subject:Fwd:Fwd:Fwd:Message from Patient<br><br>	<br>		<link href=\"../css/preview.css\" rel=\"stylesheet\" type=\"text/css\"><br>	<br>	<br>		tryhtryhtrytrytry<br>		<blockquote><br>			From: Test2<br>			<test2 direct.gdit.net=\"direct.gdit.net\"><br>				Sent:Wed, 28 Feb 2018 14:21  To:Test2<br>				<test2 direct.gdit.net=\"direct.gdit.net\"><br>					Subject:Fwd:Fwd:Message from Patient        From: Test2<br>					<test2 direct.gdit.net=\"direct.gdit.net\"><br>						Sent:Wed, 28 Feb 2018 13:33  To:Test2<br>						<test2 direct.gdit.net=\"direct.gdit.net\"><br>							Subject:Fwd:Message from Patient<br>							<blockquote><br>								erewrewr5      This message was sent by IHS Health Information Service Provider (HISP). See<br>								<a href=\"http://www.ihs.gov\" target=\"_blank\">www.ihs.gov</a><br>								for more information.<br>							</blockquote><br>						</test2><br>					</test2><br>					This message was sent by IHS Health Information Service Provider (HISP). See<br>					<a href=\"http://www.ihs.gov\" target=\"_blank\">www.ihs.gov</a><br>					for more information.<br>				</test2><br>			</test2><br>		</blockquote><br>		<br><br>		<hr SIZE=\"1\"><br>		This message was sent by IHS Health Information Service Provider (HISP). See<br>		<a href=\"http://www.ihs.gov\" target=\"_blank\">www.ihs.gov</a><br>		for more information.<br>		<br><br>	<br><br></test3@direct.gdit.net></test3@direct.gdit.net></blockquote>";
       System.out.println("s1.length(): "+s1.length());
         //Document doc = Jsoup.parse(s1.replaceAll("<br>", ""));
         Document doc = Jsoup.parse(s1);
         //System.out.println("jsoup output - before parsing: "+doc.body().html());
for (Element element : doc.select("*")) {
                if (!element.hasText() && (element.isBlock() )) {
                //if (!element.hasText() ) {
                    element.remove();
                }
            }
            System.out.println("jsoup output: "+doc.body().html());
            System.out.println("jsoup length: "+doc.body().html().length());   
            System.out.println("=============================================");
            
            Elements type1 = doc.select("*");
            String text =type1.first().html();
            String[] textSplitResult = text.split("<br>");
            
            if (null != textSplitResult) {
                Arrays.stream(textSplitResult).peek((x) -> System.out.println(x)).count();
    
            } 
            
             System.out.println("=============================================");
             String finalBody="";
           if (null != textSplitResult) {
         for (String t : textSplitResult) {
             if(t.length()>0 && !t.trim().isEmpty()){
             System.out.println(t.trim()+"    length:"+t.length());
             finalBody=finalBody+t.trim()+"\n";
             }
         }
         
         System.out.println("=============================================");
          System.out.println("finalBody: "+finalBody);
          System.out.println("finalBody-length: "+finalBody.length());
    }
           s1="book 1 - harry potter and the sorcerer's stone.pdf";
            System.out.println("=================");
             System.out.println(s1.indexOf("'"));
           System.out.println("=================");
           System.out.println(s1.replace("'", "\\'"));
           
   }
}
