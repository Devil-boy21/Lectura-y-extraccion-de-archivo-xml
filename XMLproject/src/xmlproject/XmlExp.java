/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproject;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlExp {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            DOMImplementation implementation=db.getDOMImplementation();
            
            Document documento = implementation.createDocument(null, "datosexp", null);
            documento.setXmlVersion("1.0");
            
            Element docente=documento.createElement("docente");
            Element nombre=documento.createElement("Mario");

            docente.appendChild(nombre);
            /*Elemento raiz*/
            documento.getDocumentElement().appendChild(docente);
            
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("datosexp.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        
        } catch (Exception e) {
            
        }
        
    }
}
