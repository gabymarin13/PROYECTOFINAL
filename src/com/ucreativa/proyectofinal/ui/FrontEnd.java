package com.ucreativa.proyectofinal.ui;

import com.ucreativa.proyectofinal.repositories.FileRepository;
import com.ucreativa.proyectofinal.services.RegistroService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String titulo){
        super(titulo);
    }

    public void build(){
        this.construccionPantalla();
        this.crearComponentes();
        super.setVisible(true);
    }

    private void construccionPantalla(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600,300);
        //super.setBounds(10,10,600,300);
        super.setLayout(new GridLayout(5,1));
    }

    private void agregarComponente(Component componente){
        super.getContentPane().add(componente);
    }

    private void crearComponentes(){

        //Labels
        JLabel lblNombre = new JLabel("Nombre: ");
        JLabel lblApellido = new JLabel("Apellido: ");
        JLabel lblCedula = new JLabel("Cédula: ");
        JLabel lblEdad = new JLabel("Edad: ");
        JLabel lblTelefono = new JLabel("Teléfono: ");
        JLabel lblCorreo = new JLabel("Correo electrónico: ");
        JLabel lblEsEmpleado = new JLabel("Empleado ");
        JLabel lblCodigo = new JLabel("Código del empleado: ");
        JLabel lblPuesto = new JLabel("Puesto del empleado: ");

        //Text fields
        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtCedula = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtCodigo = new JTextField();
        JTextField txtPuesto = new JTextField();

        //Por default se crea el JFrame con los campos de Empleado deshabilitados,
        //en caso de seleccionarse el checkbox esEmpleado, entonces se habilitan.
        lblEsEmpleado.setEnabled(true);
        lblCodigo.setEnabled(false);
        txtCodigo.setEditable(false);
        lblPuesto.setEnabled(false);
        txtPuesto.setEditable(false);


        //Creación checkbox para saber si la persona es empleado o cliente
        JCheckBox chkEmpleado = new JCheckBox();
        chkEmpleado.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(chkEmpleado.isSelected()){
                    lblCorreo.setEnabled(false);
                    txtCorreo.setEditable(false);

                    lblCodigo.setEnabled(true);
                    txtCodigo.setEditable(true);
                    lblPuesto.setEnabled(true);
                    txtPuesto.setEditable(true);
                } else {
                    lblCorreo.setEnabled(true);
                    txtCorreo.setEditable(true);

                    lblCodigo.setEnabled(false);
                    txtCodigo.setEditable(false);
                    lblPuesto.setEnabled(false);
                    txtPuesto.setEditable(false);
                }
            }
        });

        //Botones de guardar e imprimir lista
        JButton btnGuardar = new JButton("Guardar registro");
        btnGuardar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroService service = new RegistroService(new FileRepository());
                try {
                    service.guardar(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(),
                            txtTelefono.getText(),txtEdad.getText(), txtCorreo.getText(), txtCodigo.getText(),
                            txtPuesto.getText(), chkEmpleado.isSelected());

                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtCedula.setText("");
                    txtTelefono.setText("");
                    txtEdad.setText("");
                    txtCorreo.setText("");
                    txtCodigo.setText("");
                    txtPuesto.setText("");
                    chkEmpleado.setSelected(false);

                    //String reporte = String.join("\n", service.leerLista());
                    //OptionPane.showMessageDialog(((JButton)e.getSource()).getParent(),reporte);
                } catch (ErrorEdadException x) {
                    JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(), x.getMessage());
                }


            }
        });

        JButton btnImprimir = new JButton("Imprimir registros");
        btnImprimir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroService service = new RegistroService(new FileRepository());
                try{
                    String reporte = String.join("\n", service.leerLista());
                    JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(),reporte);
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(), x.getMessage());
                }

            }
        });

        //Agregar campos al UI
        this.agregarComponente(lblNombre);
        this.agregarComponente(txtNombre);
        this.agregarComponente(lblApellido);
        this.agregarComponente(txtApellido);
        this.agregarComponente(lblCedula);
        this.agregarComponente(txtCedula);
        this.agregarComponente(lblTelefono);
        this.agregarComponente(txtTelefono);
        this.agregarComponente(lblEdad);
        this.agregarComponente(txtEdad);
        this.agregarComponente(lblCorreo);
        this.agregarComponente(txtCorreo);
        this.agregarComponente(lblEsEmpleado);
        this.agregarComponente(chkEmpleado);
        this.agregarComponente(lblCodigo);
        this.agregarComponente(txtCodigo);
        this.agregarComponente(lblPuesto);
        this.agregarComponente(txtPuesto);

        this.agregarComponente(btnGuardar);
        this.agregarComponente(btnImprimir);
    }
}
