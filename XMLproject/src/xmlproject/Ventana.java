/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproject;

import static com.db4o.foundation.Iterators.next;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author erqui
 */
public class Ventana extends javax.swing.JFrame {

    Docente docente;
    DefaultTableModel modelo;
    ConexionBD conexionbd;
    ArrayList<Docente> resultado;

    public Ventana() {
        initComponents();
        this.setLocation(325, 200);
        this.setTitle("Ventana Docente");

        modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Username");
        modelo.addColumn("Password");

        this.tablapersona.setModel(modelo);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Generar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapersona = new javax.swing.JTable();
        exportar = new javax.swing.JButton();
        Generar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Docente");

        Generar.setText("Guardar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });

        tablapersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Uername", "Password"
            }
        ));
        jScrollPane1.setViewportView(tablapersona);

        exportar.setText("Exportar");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        Generar1.setText("Leer");
        Generar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Generar)
                        .addGap(39, 39, 39)
                        .addComponent(Generar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(exportar)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Generar)
                            .addComponent(Generar1)
                            .addComponent(exportar))
                        .addGap(145, 145, 145)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
       
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
                Element element=(Element)docente;
                 if (docente.getNodeType()==Node.ELEMENT_NODE) {
                    System.out.println("id: "+element.getAttribute("id"));
                    System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Username: "+element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("Password: "+element.getElementsByTagName("password").item(0).getTextContent());
                }
               
                String id =(element.getAttribute("id"));
                String nombres =(element.getElementsByTagName("nombre").item(0).getTextContent());
                String username =(element.getElementsByTagName("username").item(0).getTextContent());
                String password =(element.getElementsByTagName("password").item(0).getTextContent());
                
                 String[] info = new String[4];
                        info[0] = id;
                        info[1] = nombres;
                        info[2] = username;
                        info[3] = password;
                        modelo.addRow(info);
                        
                    Docente dc = new Docente(id, nombres, username, password);
                    
                    boolean p = dc.insertarDocente(id, nombres, username, password);
                if (p == true) {
                    JOptionPane.showMessageDialog(rootPane, "Datos guardados");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Algo falló al insertar");
                    }
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*try {
            String[] caja = new String[4];

            caja[0] = txtdni.getText();
            caja[1] = txtnombre.getText();
            caja[2] = Username.getText();
            caja[3] = Password.getText();

            String id = txtdni.getText();
            String nombres = txtnombre.getText();
            String username = Username.getText();
            int password = Integer.valueOf(Password.getText());

            Docente docente = new Docente ( id, nombres, username, password);

            boolean p = docente.insertarPersona(id, nombres, username, password);

            if (p == true) {
                JOptionPane.showMessageDialog(rootPane, "Datos guardados");
                this.modelo.addRow(caja);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Algo falló al insertar");
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(rootPane, "El id introducido no es un número");
        }
        */
    }//GEN-LAST:event_GenerarActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarActionPerformed

    private void Generar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Generar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generar;
    private javax.swing.JButton Generar1;
    private javax.swing.JButton exportar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablapersona;
    // End of variables declaration//GEN-END:variables

    private void seleccionarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
