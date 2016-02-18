package com.github.rb.tplusimar2015.core.gui.impl;

import javax.swing.JTable;

public final class TablaListener extends JTable {

    private static TablaListener INSTANCE;

    public static TablaListener getInstance() {

        synchronized (TablaListener.class) {

            INSTANCE = (INSTANCE == null) ? new TablaListener() : INSTANCE;
        }
        return INSTANCE;
    }

    private TablaListener() {
        super();
    }

    public final void borrarColumna(String nombreColumna, Integer indice) {

        if (nombreColumna.equals(this.getColumnName(indice))) {
            this.removeColumn(this.getColumn(indice));
        }

    }
}
