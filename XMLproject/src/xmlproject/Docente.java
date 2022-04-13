/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlproject;

/**
 *
 * @author erqui
 */
public class Docente {
    String Nombre,Username, password,id;

    public Docente(String id, String Nombre, String Username, String password) {
        this.Nombre = Nombre;
        this.Username = Username;
        this.password = password;
        this.id=id;
    }

      public boolean insertarDocente(String id, String Nombre, String Username, String password) {
        Docente personap = new Docente (id, Nombre, Username, password);
        ConexionBD cbd = new ConexionBD();
        boolean b = cbd.insertarD(personap);
        return b;
    }

   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
         return ""+ Nombre +" "+   Username + " " + password;
    }
 
    
    
}

