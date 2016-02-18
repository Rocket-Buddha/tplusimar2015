package com.github.rb.tplusimar2015.exceptions;

import com.github.rb.tplusimar2015.core.impl.MainController;

public final class ExceptionController {

    private final MainController mainController;
    private static ExceptionController INSTANCE;

    public static ExceptionController getInstance(MainController mainController) {

        synchronized (ExceptionController.class) {

            INSTANCE = (INSTANCE == null) ? new ExceptionController(mainController) : INSTANCE;
        }
        return INSTANCE;
    }

    private ExceptionController(MainController mainController) {

        this.mainController = mainController;
    }

    public void ErrorGenerico(Exception e) {

        this.mainController
                .getPrincipalVentana()
                .mostrarError("Error: "
                        + e.getMessage());
    }
}
