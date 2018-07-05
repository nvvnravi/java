/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Ravi.Nistala
 */
public class Stax_targetcommunity {
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
            FactoryConfigurationError {

        StAXOMBuilder builder = null;
        try {
            //Method-1- if you have a xml file
            File file = new File("C:/Users/ravi.nistala/Desktop/test.xml");
		FileInputStream fis = new FileInputStream(file);
            //OMXMLParserWrapper parser=   OMXMLBuilderFactory.createOMBuilder(fis);
            //OMElement rootnode = parser.getDocumentElement();
            
            
            //Method-1- if you have an OMElement
            String theString2 = IOUtils.toString(new FileInputStream(new File("C:/Users/ravi.nistala/Desktop/test.xml")), "UTF-8");
            OMElement documentElement = AXIOMUtil.stringToOM(theString2);
          OMXMLParserWrapper  parser=  OMXMLBuilderFactory.createStAXSOAPModelBuilder(documentElement.getXMLStreamReader());
          //OMXMLParserWrapper parser=   OMXMLBuilderFactory.createOMBuilder(documentElement.get);
           // OMElement rootnode = parser.getDocumentElement();
 
            //Method-1- if you want to use deprecated  StaXBuilder
            builder = new StAXOMBuilder("C:/Users/ravi.nistala/Desktop/test.xml");
            QName slot_name_qname = new QName("NhinTargetCommunities");;            
            //OMElement rootnode = builder.getDocumentElement();
            
            

            for (Iterator it =documentElement.getChildElements(); it.hasNext();) {
                OMElement ele = (OMElement) it.next();
                System.out.println(ele.getLocalName());                            
                for (Iterator it1 = ele.getChildElements(); it1.hasNext();) {                    
                OMElement ele1 = (OMElement) it1.next();    
                for (Iterator it2 = ele1.getChildElements(); it2.hasNext();) {
                    OMElement ele2 = (OMElement) it2.next();    
                if(ele2.getLocalName().equals("homeCommunityId")){
                    System.out.println("value is :"+ele2.getText());
                }
                }                
                }                
            }

        } catch (final XMLStreamException error) {

            System.out.println(error.getMessage());
        } catch (final IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
