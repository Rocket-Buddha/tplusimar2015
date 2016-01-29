package com.github.rb.tplusimar2015.empleados.gui.impl;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.github.rb.tplusimar2015.core.pojo.Empleado;
import com.github.rb.tplusimar2015.core.gui.PanelFormularioForm;
import com.github.rb.tplusimar2015.core.pojo.Rol;
import com.github.rb.tplusimar2015.core.pojo.Senority;
import javax.swing.JComboBox;

public class EmpleadoPanelFormularioForm extends PanelFormularioForm {

    /**
     *
     */
    private JTextField jtfNLegajo;
    private JTextField jtfDni;
    private JTextField jtfNombre;
    private JTextField jtfApellido;
    private JTextField jtfTelefono;
    private JTextField jtfDireccion;
    private final JComboBox<Rol> jcbRol;
    private final JComboBox<Senority> jcbSenority;

    public EmpleadoPanelFormularioForm() {

        super();
        
        this.jtfNLegajo = new JTextField(10);
        jtfNLegajo.setEnabled(false);
        this.jtfDni = new JTextField(10);
        this.jtfNombre = new JTextField(10);
        this.jtfApellido = new JTextField(10);
        this.jtfTelefono = new JTextField(10);
        this.jtfDireccion = new JTextField(10);
        this.jcbRol = new JComboBox<>(Rol.values());
        this.jcbSenority = new JComboBox<>(Senority.values());
        
        this.armarPanel();

    }

    public EmpleadoPanelFormularioForm(Empleado empleado) {

        super();
        
        this.jtfNLegajo = new JTextField(10);
        jtfNLegajo.setEnabled(false);
        this.jtfDni = new JTextField(10);
        this.jtfNombre = new JTextField(10);
        this.jtfApellido = new JTextField(10);
        this.jtfTelefono = new JTextField(10);
        this.jtfDireccion = new JTextField(10);
        this.jcbRol = new JComboBox<>(Rol.values());
        this.jcbSenority = new JComboBox<>(Senority.values());
        

        this.cargarDatosIniciales(empleado);
        this.armarPanel();
    }

    private void cargarDatosIniciales(Empleado empleado) {
        
        this.jtfNLegajo.setText(String.valueOf(empleado.getLegajo()));
        this.jtfDni.setText(String.valueOf(empleado.getDni()));
        this.jtfNombre.setText(empleado.getNombre());
        this.jtfApellido.setText(empleado.getApellido());
        this.jtfTelefono.setText(empleado.getTelefono());
        this.jtfDireccion.setText(empleado.getDireccion());
        this.jcbRol.setSelectedItem(empleado.getRol());
        this.jcbSenority.setSelectedItem(empleado.getSenority());
        
    }

    private void armarPanel() {

        //Cantidad de filas, cantidad de columnas, gap horizontal, gap vertical
        super.getContenedor().setLayout(new GridLayout(8, 2, 5, 5));
        
        super.getContenedor().add(new JLabel("Nº Legajo:"));
        super.getContenedor().add(jtfNLegajo);
        super.getContenedor().add(new JLabel("DNI:"));
        super.getContenedor().add(jtfDni);
        super.getContenedor().add(new JLabel("Nombre:"));
        super.getContenedor().add(jtfNombre);
        super.getContenedor().add(new JLabel("Apellido:"));
        super.getContenedor().add(jtfApellido);
        super.getContenedor().add(new JLabel("Telefono:"));
        super.getContenedor().add(jtfTelefono);
        super.getContenedor().add(new JLabel("Direccion:"));
        super.getContenedor().add(jtfDireccion);
        super.getContenedor().add(new JLabel("Rol:"));
        super.getContenedor().add(jcbRol);
        super.getContenedor().add(new JLabel("Senority:"));
        super.getContenedor().add(jcbSenority);

        this.add(super.getContenedor());

    }

    public JTextField getJtfNLegajo() {
        return jtfNLegajo;
    }

    public JTextField getJtfDni() {
        return jtfDni;
    }

    public JTextField getJtfNombre() {
        return jtfNombre;
    }

    public JTextField getJtfApellido() {
        return jtfApellido;
    }

    public JTextField getJtfTelefono() {
        return jtfTelefono;
    }

    public JTextField getJtfDireccion() {
        return jtfDireccion;
    }

    public JComboBox<Rol> getJcbRol() {
        return jcbRol;
    }

    public JComboBox<Senority> getJcbSenority() {
        return jcbSenority;
    }

    

 

}
