/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproject;

import java.io.File;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author erqui
 */
public class XMLproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File archivo = new File("datos.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document d=db.parse(archivo);
            d.getDocumentElement().normalize();
            
            System.out.println("elemento principal: "+ d.getDocumentElement().getNodeName());
            
            NodeList listadocentes= d.getElementsByTagName("docente");
            
            for (int i = 0; i < listadocentes.getLength(); i++) {
                Node docente=listadocentes.item(i);
                System.out.println("Docente:"+ docente.getNodeName()+i);
                if (docente.getNodeType()==Node.ELEMENT_NODE) {
                    Element element=(Element)docente;
                    
                    System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Username: "+element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("Password: "+element.getElementsByTagName("password").item(0).getTextContent());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
