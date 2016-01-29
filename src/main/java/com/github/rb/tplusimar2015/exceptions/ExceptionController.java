package com.github.rb.tplusimar2015.exceptions;

import com.github.rb.tplusimar2015.core.impl.MainController;

public class ExceptionController {
	
	MainController mainController;
	private static ExceptionController INSTANCE;

	public static ExceptionController getInstance(MainController mainController) {
		if (INSTANCE == null)
			createInstance(mainController);
		return INSTANCE;
	}

	private static void createInstance(MainController mainController) {
		
		if (INSTANCE == null) {
			synchronized (ExceptionController.class) {
				
				if (INSTANCE == null) {
						INSTANCE = new ExceptionController(mainController);
					
				}
			}
		}
	}
	
	private ExceptionController (MainController mainController){
		
		this.mainController = mainController;
		
	}
	
	public void ErrorGenerico (Exception e){
		
		this.mainController.getPrincipalVentana().mostrarError("Error: "+e.getMessage()+". "+e.getCause().getMessage());

	}
	
	

}
