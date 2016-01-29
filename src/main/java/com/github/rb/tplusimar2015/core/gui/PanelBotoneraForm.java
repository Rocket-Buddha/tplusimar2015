package com.github.rb.tplusimar2015.core.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class PanelBotoneraForm extends JPanel {

	private static final long serialVersionUID = -9122943147257570742L;

	private JButton jbAceptar;
	private JButton jbCancelar;

	public PanelBotoneraForm() {

		this.jbAceptar = new JButton("Aceptar");
		this.jbCancelar = new JButton("Cancelar");

		this.armarPanel();

	}

	private void armarPanel() {

		this.setLayout(new FlowLayout());
		this.add(jbAceptar);
		this.add(jbCancelar);
	}

	public JButton getJbAceptar() {
		return jbAceptar;
	}

	public void setJbAceptar(JButton jbAceptar) {
		this.jbAceptar = jbAceptar;
	}

	public JButton getJbCancelar() {
		return jbCancelar;
	}

	public void setJbCancelar(JButton jbCancelar) {
		this.jbCancelar = jbCancelar;
	}

}
