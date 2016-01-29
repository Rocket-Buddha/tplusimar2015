package com.github.rb.tplusimar2015.core.gui.impl;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.github.rb.tplusimar2015.core.impl.MainController;
import com.github.rb.tplusimar2015.utils.Grafico;

public class PrincipalVentana extends JFrame {

	private static final long serialVersionUID = -8462808633616762084L;
	private PrincipalMenuOpciones menuOpciones;
	private static PrincipalVentana INSTANCE;

	public static PrincipalVentana getInstance(MainController mainController) {
		if (INSTANCE == null)
			createInstance(mainController);
		return INSTANCE;

	}

	private static void createInstance(MainController controlador) {
		
		if (INSTANCE == null) {
			synchronized (PrincipalVentana.class) {
				
				if (INSTANCE == null) {
						INSTANCE = new PrincipalVentana(controlador);
					
				}
			}
		}
	}

	private PrincipalVentana(MainController controllador){
			this.menuOpciones = new PrincipalMenuOpciones(controllador);
			this.armarVentana();
			this.mostraVentana();
		
	}

	private void armarVentana() {
		this.setBounds(0, 0, Grafico.obtenerAnchoPantalla() / 2,
				Grafico.obtenerAltoPantalla() / 2);
		this.setJMenuBar(menuOpciones);

	}

	private void mostraVentana() {
		// Muestra la ventana principal.
		this.setVisible(true);
	}
		
	public void mostrarError(String error) {
	
			JOptionPane.showMessageDialog(this,
				    error,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
	}
	
}
