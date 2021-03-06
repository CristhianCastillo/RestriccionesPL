/* *****************************************************************************
 * Class: InterfazApp.java 
 * Date: 17/03/2018 11:58:15 PM
 * Copyright 2018 All rights reserved
 * 
 * Proyect: RestriccionesPL
 * Autor: Cristhian Eduardo Castillo Erazo - 17/03/2018 
 * *****************************************************************************
 */

package com.app.view;

import com.app.controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación.  
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class InterfazApp extends JFrame
{
    // -------------------------------------------------------------------------
    //  Constants
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    //  Attributes
    // -------------------------------------------------------------------------
    
    /**
     * Panel Parametros.
     */
    private final PanelParametros pnlParametros;
    
    /**
     * Panel Salida.
     */
    private final PanelSalida pnlSalida;
    
    /**
     * Controlador principal.
     */
    private final Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicacion.
     */
     public InterfazApp()
    {
        this.ctrl = new Controlador();
        
        this.setTitle("Restricciones PL");
        this.setLayout(new BorderLayout());
       
        pnlSalida = new PanelSalida();        
        pnlParametros = new PanelParametros(ctrl);
        
        this.getContentPane().add(pnlParametros, BorderLayout.NORTH);
        this.getContentPane().add(pnlSalida, BorderLayout.CENTER);
        
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.ctrl.conectar(pnlParametros, pnlSalida);
    }
     
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
     
     /**
      * Metodo principal de la aplicación.
      * @param args No son necesarios.
      */
     public static void main(String []args)
     {
         InterfazApp aplicacion = new InterfazApp();
         aplicacion.setVisible(true);
     }
}
