package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.Doctor;
import Modelos.Gestor;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarDoctor extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField nombreTF;
  private JTextField especialidadTF;
  private JTextField telefonoTF;
  private Gestor gestor;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      RegistrarDoctor dialog = new RegistrarDoctor();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public RegistrarDoctor() {
    
    gestor = new Gestor();
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setLayout(new FlowLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    {
      nombreTF = new JTextField();
      nombreTF.setText("Nombre");
      contentPanel.add(nombreTF);
      nombreTF.setColumns(10);
    }
    {
      especialidadTF = new JTextField();
      especialidadTF.setText("Especialidad");
      contentPanel.add(especialidadTF);
      especialidadTF.setColumns(10);
    }
    {
      telefonoTF = new JTextField();
      telefonoTF.setText("Telefono");
      contentPanel.add(telefonoTF);
      telefonoTF.setColumns(10);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String nombre = nombreTF.getText();
            String especialidad = especialidadTF.getText();
            String telefono = telefonoTF.getText();
            
            
            try {
              Doctor doctor = new Doctor(nombre, especialidad, telefono);
              gestor.registrarDoctor(doctor);
              JOptionPane.showMessageDialog(null, "El doctor se ha creado satisfactoriamente");
            } catch (Exception e1) {
              JOptionPane.showMessageDialog(null, "Hubo un error al registrar el doctor");
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
