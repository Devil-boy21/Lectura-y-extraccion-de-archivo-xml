/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproject;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erqui
 */
public class ConexionBD {

    private static void listResult(ObjectSet<Docente> result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ObjectContainer oc;

    private void open() {
        this.oc = Db4o.openFile("Docentes.yap");
    }

    //Método para insertar una persona
    public boolean insertarD(Docente objeto) {
        try {
            this.open();
            oc.set(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("base de datos.insertarP" + e);
            return false;
        }
    }

   
}
