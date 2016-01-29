package com.github.rb.tplusimar2015.core.impl;
import com.github.rb.tplusimar2015.exceptions.GUIException;
import java.util.logging.Logger;

public class Main { 


	public static void main(String[] args) throws GUIException {

	    new Main();
	    MainController.getInstance();

	}
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
}
