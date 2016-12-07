package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Modelos.Gestor;
import Modelos.GestorPaciente;
import Modelos.Paciente;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPaciente extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField cedulaTF;
  private JTextField nombreTF;
  private JTextField direccionTF;
  private JTextField telefonoTF;
  private GestorPaciente gestorPaciente;
  private JTextField txtEdad;
  private JTextField txtFechaNacimiento;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      RegistrarPaciente dialog = new RegistrarPaciente();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public RegistrarPaciente() {
    
    gestorPaciente = new GestorPaciente();
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setLayout(new FlowLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    {
      cedulaTF = new JTextField();
      cedulaTF.setText("Cedula");
      contentPanel.add(cedulaTF);
      cedulaTF.setColumns(10);
    }
    {
      nombreTF = new JTextField();
      nombreTF.setText("Nombre");
      contentPanel.add(nombreTF);
      nombreTF.setColumns(10);
    }
    {
    	direccionTF = new JTextField();
    	direccionTF.setText("Direcccion");
      contentPanel.add(direccionTF);
      direccionTF.setColumns(10);
    }
    {
      telefonoTF = new JTextField();
      telefonoTF.setText("Telefono");
      contentPanel.add(telefonoTF);
      telefonoTF.setColumns(10);
    }
    {
    	txtFechaNacimiento = new JTextField();
    	txtFechaNacimiento.setText("dd/MM/YYYY");
    	contentPanel.add(txtFechaNacimiento);
    	txtFechaNacimiento.setColumns(10);
    }
    {
    	txtEdad = new JTextField();
    	txtEdad.setText("Edad");
    	contentPanel.add(txtEdad);
    	txtEdad.setColumns(10);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String cedula = cedulaTF.getText();
            String nombre = nombreTF.getText();
            String direccion = direccionTF.getText();
            String telefono = telefonoTF.getText();
            String fechaNacimiento = txtFechaNacimiento.getText();
            String edad = txtEdad.getText();
            
            
            try {
<<<<<<< HEAD
              Paciente paciente = new Paciente(cedula,nombre, direccion, telefono,fechaNacimiento,Integer.parseInt(edad));
              gestorPaciente.agregar(paciente);
              JOptionPane.showMessageDialog(null, "El paciente se ha registrado de manera satisfactoria");
            } catch (Exception e1) {
              JOptionPane.showMessageDialog(null, "Hubo un error en registrar paciente"+e1);
=======
              Paciente paciente = new Paciente(cedula, nombre, direccion, telefono, fechaNacimiento, Integer.parseInt(edad));
              gestorPaciente.agregar(paciente);
              JOptionPane.showMessageDialog(null, "El paciente se ha registrado de manera satisfactoria");
            } catch (Exception e1) {
              JOptionPane.showMessageDialog(null, e1.getMessage());
>>>>>>> 23b6219d2d4531913cfe2701380d21229e70e40f
              e1.printStackTrace();
            }
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
