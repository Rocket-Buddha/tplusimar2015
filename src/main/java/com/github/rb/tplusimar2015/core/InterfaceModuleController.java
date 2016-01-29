package com.github.rb.tplusimar2015.core;

import com.github.rb.tplusimar2015.core.impl.MainController;

public interface InterfaceModuleController {

	
	public abstract void mostrarPanelListar();

	public abstract void mostrarPanelAlta();

	public abstract void mostrarPanelModificar(Object object);
	
	public abstract void alta(Object object);

	public abstract void baja(Object object);

	public abstract void modificar(Object object);
	
	public abstract MainController getMainController();
	
}
