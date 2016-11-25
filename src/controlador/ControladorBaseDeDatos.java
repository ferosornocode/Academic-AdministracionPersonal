/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AdministracionBaseDeDatos;
import modelo.Empleado;

/**
 *
 * @author Ventura
 */
public class ControladorBaseDeDatos {
    public boolean guardarEmpleadoControlador(Empleado empleado)
    {
        boolean resultado=false;
        AdministracionBaseDeDatos admin = 
                new AdministracionBaseDeDatos();
        resultado = admin.guardarEmpleado(empleado);
        return resultado;
    }
}
