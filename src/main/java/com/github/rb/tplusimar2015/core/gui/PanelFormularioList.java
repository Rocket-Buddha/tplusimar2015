package com.github.rb.tplusimar2015.core.gui;

import com.github.rb.tplusimar2015.core.gui.impl.TablaListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

public abstract class PanelFormularioList extends JPanel {

	
	private TablaListener tabla;
	private JScrollPane scrollPanel;

	protected PanelFormularioList(AbstractTableModel modelo){

			this.tabla = TablaListener.getInstance();
			this.tabla.setModel(modelo); // Setea modelo de la tabla
			this.scrollPanel = new JScrollPane(tabla);

			this.armarPanel();
	
	}

	private void armarPanel() {

		this.setLayout(new BorderLayout());
		this.add(this.scrollPanel, BorderLayout.CENTER);
	}

	public TablaListener getTabla() {
		return tabla;
	}

	public void setTabla(TablaListener tabla) {
		this.tabla = tabla;
	}

	public JScrollPane getScrollPanelAutos() {
		return scrollPanel;
	}

	public void setScrollPanelAutos(JScrollPane scrollPanelAutos) {
		this.scrollPanel = scrollPanelAutos;
	}

}
