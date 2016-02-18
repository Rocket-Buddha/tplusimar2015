package com.github.rb.tplusimar2015.core.gui;

import com.github.rb.tplusimar2015.core.gui.impl.TablaListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

public abstract class PanelFormularioList extends JPanel {

    private final TablaListener tabla;
    private final JScrollPane scrollPanel;

    protected PanelFormularioList(AbstractTableModel modelo) {

        this.tabla = TablaListener.getInstance();
        this.tabla.setModel(modelo);
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

    public JScrollPane getScrollPanelAutos() {
        return scrollPanel;
    }
}
