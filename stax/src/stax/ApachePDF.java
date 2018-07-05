/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Ravi.Nistala
 */
public class ApachePDF {
    
     public static void main (String args[]) throws IOException {
       
      //Creating PDF document object 
      PDDocument document = new PDDocument();    
       
      //Saving the document
      document.save("C:/temp/my_doc.pdf");
         
      System.out.println("PDF created");  
    
      //Closing the document  
      document.close();

   }  
    
}
