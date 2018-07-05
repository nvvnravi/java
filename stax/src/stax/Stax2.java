/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

/**
 *
 * @author Ravi.Nistala
 */
public class Stax2 {

    private static final SimpleDateFormat DOC_CREATE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssZ");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException,
            FactoryConfigurationError {

        StAXOMBuilder builder = null;
        try {

            builder = new StAXOMBuilder("C:/Users/nistr1/Desktop/test.xml");

            QName slot_name_qname = new QName("name");;
            // Step 3
            OMElement rootnode = builder.getDocumentElement();

            for (Iterator it = rootnode.getChildElements(); it.hasNext();) {
                OMElement ele = (OMElement) it.next();
                if (ele.getLocalName().equals("Slot")) {
                    String elementIdScheme = ele.getAttributeValue(slot_name_qname);
                    if ("submissionTime".equals(elementIdScheme)) {
                        for (Iterator it1 = ele.getChildElements(); it1.hasNext();) {
                            OMElement ele1 = (OMElement) it1.next();
                            if (ele1.getLocalName().equals("ValueList")) {
                                for (Iterator it2 = ele1.getChildElements(); it2.hasNext();) {
                                    OMElement ele2 = (OMElement) it2.next();
                                    if (ele2.getLocalName().equals("Value")) {
                                        //get the value
                                        System.out.println(ele2.getText());
                                        break;
                                    }

                                }
                            }
                            break;
                        }

                    }
                }
                break;
            }
        } catch (final XMLStreamException error) {

            System.out.println(error.getMessage());
        } catch (final IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
