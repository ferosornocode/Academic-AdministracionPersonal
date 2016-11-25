/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ventura
 */
public class AdministracionBaseDeDatos {
    /**
     * 
     * https://www.tutorialspoint.com/jdbc/preparestatement-object-example.htm
     * @param empleado
     * @return 
     */
    public boolean guardarEmpleado(Empleado empleado)
    {
        boolean resultado = false;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/course";
        String USER = "root";
        String PASS = "admin";
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {
            Class.forName(JDBC_DRIVER); //Binding 
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "INSERT INTO persona(nombre,appaterno,apmaterno,sexo,correo,telefono,edad,sueldo) " +
            "VALUES (?,?,?,?,?,?,?,?);";
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, empleado.getNombre()); 
            stmt.setString(2, empleado.getApPaterno());
            stmt.setString(3, empleado.getApMaterno());
            stmt.setInt(4, empleado.getSexo());
            stmt.setString(5, empleado.getCorreo());
            stmt.setString(6, empleado.getTelefono());
            stmt.setInt(7, empleado.getEdad());
            stmt.setFloat(8, empleado.getSueldo());
            //-----Hasta aquí el enunciado ya está listo.
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            resultado = true;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        return resultado;
    }
}
