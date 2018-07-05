/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.apache.commons.io.IOUtils;
import org.jaxen.JaxenException;

/**
 *
 * @author Ravi.Nistala
 */
public class Stax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
            XMLStreamException, FactoryConfigurationError {
        // TODO code application logic here
        // First create a new XMLInputFactory
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        inputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);

        //inputFactory.setProperty("javax.xml.stream.isCoalescing", True)
        // Setup a new eventReader
        //InputStream in = new FileInputStream("C:/Ravi_Nistala/IHS/Direct/ccdas/CCDA_cerner.xml");
        InputStream in = new FileInputStream("C:/Ravi_Nistala/IHS/Direct/ccdas/dv-ccda.xml");
        
        
        StAXOMBuilder builder = null;
        try {
            byte[] bytes = IOUtils.toByteArray(in);
                builder = new StAXOMBuilder(new ByteArrayInputStream(bytes));
        
        
         AXIOMXPath xPath = new AXIOMXPath("/ClinicalDocument/effectiveTime/@value");
         String comments = (String)xPath.stringValueOf(builder.getDocumentElement());
         System.out.println("&&&&&&&"+comments);
         
         } catch (final XMLStreamException error) {
           
            System.out.println(error.getMessage());
        }
        catch (final IOException ex) {
           
            System.out.println(ex.getMessage());
        }
        catch (final JaxenException ex) {
           
            System.out.println(ex.getMessage());
        }
       // InputStream in = new FileInputStream("C:/Ravi_Nistala/IHS/Direct/ccdas/ccd_singapore.xml");
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

        String orgName = "";
        String problemList = "";
        boolean providerOrganization = false;
        boolean section = false;
        boolean code = false;
        boolean texttag = false;
        boolean tabletag = false;
        final String codeConstant = "11450-4";
        String problemOutput = "";
        //final String textStartTag = "<text>";
        //final String textEndTag = "</text>";
        
        //XMLEventWriter xw = null;
        //StringWriter sw = new StringWriter();
        //XMLOutputFactory of = XMLOutputFactory.newInstance();

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            //reach the start of an item
            if (event.isStartElement()) {

                StartElement startElement = event.asStartElement();

                if (startElement.getName().getLocalPart().equals("providerOrganization")) {
                    providerOrganization = true;

                }
                if (startElement.getName().getLocalPart().equals("name") && providerOrganization) {
                    //read name of provider organization
                    event = eventReader.nextEvent();

                    orgName = event.asCharacters().getData();
                    System.out.println("Name of Organization: "
                            + event.asCharacters().getData());
                }

                if (startElement.getName().getLocalPart().equals("section")) {
                    System.out.println("Make section true\n");
                    section = true;

                }

                if (startElement.getName().getLocalPart().equals("code") && section) {
                    // get "code" attribute value inside "<code>" tag
                    System.out.println("Code tag found!!!!\n");
                    Attribute attr = startElement
                            .getAttributeByName(new QName("code"));

                    if (attr != null && attr.getName() != null && "code".equals(attr.getName().toString())) {
                        System.out.println("Code attribute found!!!!\n");
                        if (attr.getValue() != null) {
                            System.out.println("Code attribute value : " + attr.getValue() + "\n");
                        }
                        if (codeConstant.equals(attr.getValue())) {
                            System.out.println("Code found!!!!\n");
                            code = true;
                        }
                    }
                }
                if (startElement.getName().getLocalPart().equals("text") && code && section) {
                    System.out.println("Make texttag true\n");
                    texttag = true;
                    problemOutput = problemOutput + "<text>";

                    while (eventReader.hasNext()) {
                        event = eventReader.nextEvent();

                        if (event.isEndElement() && event.asEndElement().getName().getLocalPart() == "text") {
                            System.out.println("Make text false\n");
                            section = false;
                            code = false;
                            texttag = false;
                            problemOutput = problemOutput + "</text>";
                            break;
                        } else {

                            if (event.isCharacters()) {
                                problemOutput = problemOutput + "     " + event.asCharacters().getData().trim();
                            }

                        }

                    }
                    System.out.println("problemOutput: " + problemOutput + "\n");

                }

            }

            //reach the end of provider organization
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart() == "providerOrganization") {
                    System.out.println("Make provider Organization false\n");
                    providerOrganization = false;
                }

            }

        }

    }

}
