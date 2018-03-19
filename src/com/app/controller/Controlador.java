/* *****************************************************************************
 * Class: Controlador.java 
 * Date: 18/03/2018 01:25:52 AM
 * Copyright 2018 All rights reserved
 * 
 * Proyect: RestriccionesPL
 * Autor: Cristhian Eduardo Castillo Erazo - 18/03/2018 
 * *****************************************************************************
 */

package com.app.controller;

import com.app.view.PanelParametros;
import com.app.view.PanelSalida;

/**
 * Clase que representa el controlador principal de la aplicacion.  
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class Controlador 
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
    private PanelParametros pnlParametros;
    
    /**
     * Panel Salida.
     */
    private PanelSalida pnlSalida;
    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------

    /**
     * Construye el controlador principal de la aplicación.
     */
    public Controlador()
    {
    }
    
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
    
    /**
     * Conecta el panel parametros y el panel salida con el controlador.
     * @param pnlParametros Panel Parametros.
     * @param pnlSalida Panel Salida.
     */
    public void conectar(PanelParametros pnlParametros, PanelSalida pnlSalida)
    {
        this.pnlParametros = pnlParametros;
        this.pnlSalida = pnlSalida;
    }
    
    /**
     * Genera la restricciones de origen.
     * @param numeroFilas Numero de filas. numeroFilas > 0.
     * @param numeroColumnas Numero de Columnas. numeroColumnas > 0.
     */
    public void generarRestriccionesOrigen(int numeroFilas, int numeroColumnas)
    {
        pnlSalida.escribirSalida("RESTRICCIONES DE ORIGEN");
        for(int i = 0; i < numeroFilas; i ++)
        {
            String linea = "O" + (i + 1) + ") ";
            for(int j = 0; j < numeroColumnas; j++)
            {
                if(j == numeroColumnas - 1)
                    linea += "x" + (i + 1) + "" + (j + 1) + " = ";
                else
                    linea += "x" + (i + 1) + "" + (j + 1) + " + ";
            }
            pnlSalida.escribirSalida(linea);
        }
    }
    
    /**
     * Genera las retricciones de destino.
     * @param numeroFilas Numero de filas. numeroFilas > 0.
     * @param numeroColumnas Numero de columnas. numeroColumnas > 0.
     */
    public void generarRestriccionesDestion(int numeroFilas, int numeroColumnas)
    {
        pnlSalida.escribirSalida("RESTRICCIONES DE DESTINO");
        for(int i = 0; i < numeroFilas; i ++)
        {
            String linea = "D" + (i + 1) + ") ";
            for(int j = 0; j < numeroColumnas; j++)
            {
                if(j == numeroColumnas - 1)
                    linea += "x" + (j + 1) + "" + (i + 1) + " = ";
                else
                    linea += "x" + (j + 1) + "" + (i + 1) + " + ";
            }
            pnlSalida.escribirSalida(linea);
        }
    }
    
    /**
     * Gestiona el proceso de limpiar el buffer de salida y la entrada de
     * parametros.
     */
    public void limpiarSalida()
    {
        this.pnlSalida.limpiarBuffer();
        this.pnlParametros.limpiarParametros();
    }
}
