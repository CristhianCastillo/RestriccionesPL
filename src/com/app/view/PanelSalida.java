/* *****************************************************************************
 * Class: PanelSalida.java 
 * Date: 17/03/2018 11:58:44 PM
 * Copyright 2018 All rights reserved
 * 
 * Proyect: RestriccionesPL
 * Autor: Cristhian Eduardo Castillo Erazo - 17/03/2018 
 * *****************************************************************************
 */

package com.app.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el Panel de Salida de la aplicación.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelSalida extends JPanel
{
    // -------------------------------------------------------------------------
    //  Constants
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    //  Attributes
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------
    
    /**
     * Campo de texto que representa el buffer de salida de la aplicación.
     */
    private final JTextArea txtBufferSalida;
    
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------
    
    /**
     * Construye el Panel de salida.
     */
    public PanelSalida()
    {
        this.setBorder(new TitledBorder("Salida Restricciones"));
        this.setLayout(new BorderLayout());
        
        txtBufferSalida = new JTextArea(10,50);
        txtBufferSalida.setLineWrap(true);
        txtBufferSalida.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtBufferSalida);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      
        this.add(scroll, BorderLayout.CENTER);
    }
    
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
    
    /**
     * Escribe una linea en el buffer de salida.
     * @param salida cadena de caraceres que representan una salida.
     */
    public void escribirSalida(String salida)
    {
        txtBufferSalida.append(salida + "\n");
    }

    /**
     * Limpia el buffer de salida.
     */
    public void limpiarBuffer()
    {
        txtBufferSalida.setText("");
    }
}
