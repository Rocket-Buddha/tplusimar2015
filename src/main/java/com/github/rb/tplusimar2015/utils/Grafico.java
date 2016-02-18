package com.github.rb.tplusimar2015.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public final class Grafico {
	
	public static int obtenerAnchoPantalla(){
				GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
				return gd.getDisplayMode().getWidth();
				
	}
	
	public static int obtenerAltoPantalla(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		return gd.getDisplayMode().getHeight();
	}

}
