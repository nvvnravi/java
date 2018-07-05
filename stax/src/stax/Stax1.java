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
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.apache.commons.io.IOUtils;
import org.jaxen.JaxenException;

/**
 *
 * @author Ravi.Nistala
 */
public class Stax1 {
private static final SimpleDateFormat DOC_CREATE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssZ");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
            FactoryConfigurationError {

        StAXOMBuilder builder = null;
        try {

            builder = new StAXOMBuilder("C:/Ravi_Nistala/IHS/Direct/ccdas/dv-ccda-1.xml");

            // Step 3
            OMElement rootnode = builder.getDocumentElement();

            Iterator titleIter = rootnode.getChildrenWithName(new QName("title"));

            while (titleIter.hasNext()) {
                OMElement titleElement = (OMElement) titleIter.next();
                if (titleElement != null) {
                    System.out.println("titleElement = " + titleElement);

                }
            }

            Iterator targetObjectIter = rootnode.getChildrenWithName(new QName("recordTarget"));

            while (targetObjectIter.hasNext()) {
                OMElement targetObjectElement = (OMElement) targetObjectIter.next();
                if (targetObjectElement != null) {

                    Iterator patientRoleIter = targetObjectElement.getChildrenWithName(new QName("patientRole"));

                    while (patientRoleIter.hasNext()) {

                        OMElement patientRoleElement = (OMElement) patientRoleIter.next();
                        if (patientRoleElement != null) {

                            Iterator patientIterator = patientRoleElement.getChildrenWithName(new QName("patient"));  //  getChildrenWithName(new QName("patient"));
                            while (patientIterator.hasNext()) {
                                OMElement patientElement = (OMElement) patientIterator.next();
                                if (patientElement != null) {

                                    System.out.println("patientElement = " + patientElement);
                                }
                            }
                        }
                    }
                }

            }

            Iterator effectiveTimeIter = rootnode.getChildrenWithName(new QName("effectiveTime"));

            while (effectiveTimeIter.hasNext()) {
                OMElement effectiveTimeElement = (OMElement) effectiveTimeIter.next();
                if (effectiveTimeElement != null) {
                    String targetObject = effectiveTimeElement.getAttributeValue(new QName("value"));
                    System.out.println("effectiveTimeElement = " + targetObject);
                    System.out.println("effectiveTimeElement = " + DOC_CREATE_DATE_FORMAT.parse(targetObject));

                }
            }

        } catch (final XMLStreamException error) {

            System.out.println(error.getMessage());
        } catch (final IOException ex) {

            System.out.println(ex.getMessage());
        }
        catch (final ParseException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
