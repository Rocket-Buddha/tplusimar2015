package com.github.rb.tplusimar2015.core.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class PanelBotoneraList extends JPanel {



	private JButton jbAlta;
	private JButton jbActualizar;
	private JButton jbEliminar;

	public PanelBotoneraList() {

		this.jbAlta = new JButton("Alta");
		this.jbActualizar = new JButton("Actualizar");
		this.jbEliminar = new JButton("Eliminar");

		this.armarPanel();
	}

	private void armarPanel() {

		this.setLayout(new FlowLayout());
		this.add(jbAlta);
		this.add(jbActualizar);
		this.add(jbEliminar);
	}

	public JButton getJbAlta() {
		return jbAlta;
	}

	public void setJbAlta(JButton jbAlta) {
		this.jbAlta = jbAlta;
	}

	public JButton getJbActualizar() {
		return jbActualizar;
	}

	public void setJbActualizar(JButton jbActualizar) {
		this.jbActualizar = jbActualizar;
	}

	public JButton getJbEliminar() {
		return jbEliminar;
	}

	public void setJbEliminar(JButton jbEliminar) {
		this.jbEliminar = jbEliminar;
	}

}
