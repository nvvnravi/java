/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import com.sun.xml.internal.fastinfoset.stax.StAXDocumentParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.XMLConstants;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.jaxen.JaxenException;
import org.xml.sax.SAXException;
import javax.xml.validation.Validator;

/**
 *
 * @author Ravi.Nistala
 */
public class readsubmission {
     public static void main(String[] args) throws FileNotFoundException,
            XMLStreamException, FactoryConfigurationError, JaxenException, IOException {
         OMXMLParserWrapper builder = OMXMLBuilderFactory.createStAXOMBuilder(new StAXDocumentParser(new FileInputStream("C:\\rps-1\\Submission.xml")));
          AXIOMXPath xPath = new AXIOMXPath("/PORP_IN000001UV/controlActProcess/subject/submissionUnit/componentOf1/submission/componentOf/application/component/document/text/reference/@value");
         // String comments = (String)xPath.stringValueOf(builder.getDocumentElement());
         //System.out.println("&&&&&&&"+comments);
        // System.out.println(validateXMLSchema(new String[]{"C:\\rps-1\\multicacheschemas\\PORP_IN000001UV01.xsd"},"C:\\rps-1\\multicacheschemas\\Submission.xml"));
         
        // System.out.println(validateXMLSchema(new String[]{"C:\\rps-1\\shiporder.xsd"},"C:\\rps-1\\shiporder.xml"));
         
        //  System.out.println(validateXMLSchema_Stax(new String[]{"C:\\rps-1\\multicacheschemas\\PORP_IN000001UV01.xsd"},"C:\\rps-1\\multicacheschemas\\Submission.xml"));
          System.out.println(validateXMLSchema_Stax(new String[]{"C:\\rps\\src\\main\\resources\\rps.xsd"},"C:\\rps-1\\Submission.xml"));
         //read xml file using stax
         XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
         try {
         XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream("C:\\Ravi_Nistala\\HL7-V3\\Standards\\Edition2010\\processable\\multicacheschemas\\Submission.xml"));
         while(xmlEventReader.hasNext()){
              XMLEvent event = xmlEventReader.nextEvent();
             //process(event.ge);
         }
         } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
         
     }
     
      public static boolean validateXMLSchema(String[] xsdPath, String xmlPath){
        
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final StreamSource[] xsdSources = generateStreamSourcesFromXsdPaths(xsdPath);
            Schema schema = factory.newSchema(xsdSources);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
      
      
       public static boolean validateXMLSchema_Stax(String[] xsdPath, String xmlPath) throws IOException{
        
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final StreamSource[] xsdSources = generateStreamSourcesFromXsdPaths(xsdPath);
            Schema schema = factory.newSchema(xsdSources);
            Validator validator = schema.newValidator();
             javax.xml.transform.Source xmlSource = new javax.xml.transform.stax.StAXSource(getXMLEventReader(xmlPath));
             javax.xml.transform.Result xmlResult = new javax.xml.transform.stax.StAXResult(
          XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter("C:\\rps-1\\output.xml")));
            validator.validate(xmlSource,xmlResult);
        } catch (SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        } catch (XMLStreamException ex) {
             Logger.getLogger(readsubmission.class.getName()).log(Level.SEVERE, null, ex);
         }
        return true;
    }
       
       private static XMLEventReader getXMLEventReader(String filename) {
    XMLInputFactory xmlif = null;
    XMLEventReader xmlr = null;
    try {
      xmlif = XMLInputFactory.newInstance();
      xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
      xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
      xmlif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
      xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);

      FileInputStream fis = new FileInputStream(filename);
      xmlr = xmlif.createXMLEventReader(filename, fis);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return xmlr;
  }
      
      /**
 * Generates array of StreamSource instances representing XSDs
 * associated with the file paths/names provided and use JDK 8
 * Stream API.
 *
 * This method can be commented out if using a version of
 * Java prior to JDK 8.
 *
 * @param xsdFilesPaths String representations of paths/names
 *    of XSD files.
 * @return StreamSource instances representing XSDs.
 */
private static StreamSource[] generateStreamSourcesFromXsdPaths(
   final String[] xsdFilesPaths)
{
   return Arrays.stream(xsdFilesPaths)
                .map(StreamSource::new)
                .collect(Collectors.toList())
                .toArray(new StreamSource[xsdFilesPaths.length]);
}


  private static void process(XMLStreamReader reader) {
    int eventType = reader.getEventType();
    switch (eventType) {
    case XMLStreamConstants.START_ELEMENT:
      System.out.println("Start element: " + reader.getLocalName());

      int count = reader.getAttributeCount();
      for (int i = 0; i < count; i++) {
        String name = reader.getAttributeLocalName(i);
        String value = reader.getAttributeValue(i);
        System.out.println("\tAttribute name/value: " + name + "/" + value);
      }
      break;

    case XMLStreamConstants.END_ELEMENT:
      System.out.println("End element: " + reader.getLocalName());
      break;

    case XMLStreamConstants.CHARACTERS:
      System.out.println("Text: " + reader.getText());
      break;
    default:
      break;
    }
  }
}
