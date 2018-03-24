/* *****************************************************************************
 * Class: PanelParametros.java 
 * Date: 17/03/2018 11:58:38 PM
 * Copyright 2018 All rights reserved
 * 
 * Proyect: RestriccionesPL
 * Autor: Cristhian Eduardo Castillo Erazo - 17/03/2018 
 * *****************************************************************************
 */

package com.app.view;

import com.app.controller.Controlador;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase que representa el panel para la entrada de parametros.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelParametros extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constants
    // -------------------------------------------------------------------------

    /**
     * Constante usada para Generar la metriz.
     */
    public static final String GENERAR_MATRIZ = "Generar Matriz";
    
    /**
     * Constante usada para limpiar el buffer de salida.
     */
    public static final String LIMPIAR = "Limpiar";
    // -------------------------------------------------------------------------
    //  Attributes
    // -------------------------------------------------------------------------

    /**
     * Controlador principal de la aplicación.
     */
    private final Controlador ctrl;
    // -------------------------------------------------------------------------
    //  GUI attributes
    // -------------------------------------------------------------------------

    /**
     * Agrupacion logica de RadioButtons.
     */
    private final ButtonGroup grupoRadios;
    
    /**
     * RadioBoton Origen.
     */
    private final JRadioButton rbtnOrigen;
    
    /**
     * RadioBoton Destiono.
     */
    private final JRadioButton rbtnDestion;
    
    /**
     * Etiqueta Filas.
     */
    private final JLabel lblFilas;
    
    /**
     * Etiqueta Columnas.
     */
    private final JLabel lblColumnas;
    
    /**
     * Etiqueta tipo restricción.
     */
    private JLabel lblTipoRestriccion;
    
    /**
     * Campo de texto filas.
     */
    private final JTextField txtFilas;
    
    /**
     * Campo de texto columnas.
     */
    private final JTextField txtColumnas;
    
    /**
     * Boton Generar.
     */
    private final JButton btnGenerar;
    
    /**
     * Boton limpiar.
     */
    private final JButton btnLimpiar;
    
    // -------------------------------------------------------------------------
    //  Builders
    // -------------------------------------------------------------------------

    //1189
    
    /**
     * Construye el Panel Parametros.
     * @param ctrl Controlador principal de la aplicación.
     */
    public PanelParametros(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder( new TitledBorder("Parametros de Entrada"));
        GroupLayout grupo = new GroupLayout(this);
        this.setLayout(grupo);
        
        //Creación de componentes
        grupoRadios = new ButtonGroup();
        rbtnOrigen = new JRadioButton("Origen", true);
        rbtnDestion = new JRadioButton("Destino", false);
        grupoRadios.add(rbtnOrigen);
        grupoRadios.add(rbtnDestion);
        
        lblTipoRestriccion = new JLabel("Tipo restricciones: ");
        lblFilas = new JLabel("No. Filas: ");
        lblColumnas = new JLabel("No. Columnas: ");
        
        txtFilas = new JTextField();
        txtColumnas= new JTextField();
        
        btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setActionCommand(GENERAR_MATRIZ);
        btnGenerar.addActionListener((ActionListener)this);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand(LIMPIAR);
        btnLimpiar.addActionListener((ActionListener)this);
        
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnlBotones.add(btnGenerar);
        pnlBotones.add(btnLimpiar);
        
        JPanel pnlRadios = new JPanel();
        pnlRadios.setLayout(new FlowLayout(FlowLayout.LEADING));
        pnlRadios.add(rbtnOrigen);
        pnlRadios.add(rbtnDestion);
        
        grupo.setAutoCreateContainerGaps(true);
        grupo.setAutoCreateGaps(true);
        
        //Set Horizontal
        grupo.setHorizontalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblTipoRestriccion)
                        .addComponent(lblFilas)
                        .addComponent(lblColumnas)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(pnlRadios)
                        .addComponent(txtFilas)
                        .addComponent(txtColumnas)
                        .addComponent(pnlBotones)
                )
        );
        
        
        //Set Vertical
        grupo.setVerticalGroup(grupo.createSequentialGroup()
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblTipoRestriccion)
                        .addComponent(pnlRadios)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblFilas)
                        .addComponent(txtFilas)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(lblColumnas)
                        .addComponent(txtColumnas)
                )
                
                .addGroup(grupo.createParallelGroup()
                        .addComponent(pnlBotones)
                )
        );
                
    }
    // -------------------------------------------------------------------------
    //  Functional methods
    // -------------------------------------------------------------------------
    
    /**
     * Metodo responsable de escuchar los eventos de los botones.
     * @param e Evento que genero eñ boton seleccionado. e!= null.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(GENERAR_MATRIZ))
        {
            try
            {
                String numeroFilasStr = txtFilas.getText();
                String numeroColumnasStr = txtColumnas.getText();

                if(numeroFilasStr.trim().equalsIgnoreCase(""))
                    throw new Exception("El numero de filas no puede estar vacio.");
                if(numeroColumnasStr.trim().equalsIgnoreCase(""))
                    throw new Exception("El numero de columnas no puede estar vacio.");
           
                int numeroFilas = Integer.parseInt(numeroFilasStr);
                int numeroColumnas = Integer.parseInt(numeroColumnasStr);
                
                if(numeroFilas <= 0)
                    throw new Exception("El numero de filas debe ser mayor a cero.");
                if(numeroColumnas <= 0)
                    throw new Exception("El numero de columnas debe ser mayor a cero.");
                
                if(rbtnOrigen.isSelected())
                    ctrl.generarRestriccionesOrigen(numeroFilas, numeroColumnas);
                else
                    ctrl.generarRestriccionesDestion(numeroFilas, numeroColumnas);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Generar Matriz", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(comando.equalsIgnoreCase(LIMPIAR))
        {
            this.ctrl.limpiarSalida();
        }
    }
    
    /**
     * Limpia los parametros de entrada.
     */
    public void limpiarParametros()
    {
        this.txtFilas.setText("");
        this.txtColumnas.setText("");
    }
}
