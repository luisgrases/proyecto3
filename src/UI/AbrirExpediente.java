package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.Expediente;
import Modelos.GestorExpediente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbrirExpediente extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField fechaAperturaTF;
  private JTextField cedulaPacienteTF;
  private JTextField nombrePacienteTF;
  private JTextField direccionPacienteTF;
  private JTextField telefonoPacienteTF;
  private JTextField fechaNacimientoTF;
  private GestorExpediente gestorExpediente;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      AbrirExpediente dialog = new AbrirExpediente();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public AbrirExpediente() {
    
    gestorExpediente = new GestorExpediente();
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblNewLabel_1 = new JLabel("Nombre Paciente");
      lblNewLabel_1.setBounds(19, 105, 151, 16);
      contentPanel.add(lblNewLabel_1);
    }
    {
      JLabel lblFechaApertura = new JLabel("Fecha Apertura");
      lblFechaApertura.setBounds(19, 49, 151, 16);
      contentPanel.add(lblFechaApertura);
    }
    {
      JLabel lblCedulaPaciente = new JLabel("Cedula paciente");
      lblCedulaPaciente.setBounds(19, 77, 131, 16);
      contentPanel.add(lblCedulaPaciente);
    }
    {
      JLabel lblDireccionPaciente = new JLabel("Direccion paciente");
      lblDireccionPaciente.setBounds(19, 133, 131, 16);
      contentPanel.add(lblDireccionPaciente);
    }
    {
      JLabel lblTelefonoPaciente = new JLabel("Telefono paciente");
      lblTelefonoPaciente.setBounds(19, 161, 131, 16);
      contentPanel.add(lblTelefonoPaciente);
    }
    {
      JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
      lblFechaNacimiento.setBounds(19, 189, 131, 16);
      contentPanel.add(lblFechaNacimiento);
    }
    {
      fechaAperturaTF = new JTextField();
      fechaAperturaTF.setColumns(10);
      fechaAperturaTF.setBounds(224, 43, 134, 28);
      contentPanel.add(fechaAperturaTF);
    }
    {
      cedulaPacienteTF = new JTextField();
      cedulaPacienteTF.setColumns(10);
      cedulaPacienteTF.setBounds(224, 71, 134, 28);
      contentPanel.add(cedulaPacienteTF);
    }
    {
      nombrePacienteTF = new JTextField();
      nombrePacienteTF.setColumns(10);
      nombrePacienteTF.setBounds(224, 99, 134, 28);
      contentPanel.add(nombrePacienteTF);
    }
    {
      direccionPacienteTF = new JTextField();
      direccionPacienteTF.setColumns(10);
      direccionPacienteTF.setBounds(224, 127, 134, 28);
      contentPanel.add(direccionPacienteTF);
    }
    {
      telefonoPacienteTF = new JTextField();
      telefonoPacienteTF.setColumns(10);
      telefonoPacienteTF.setBounds(224, 155, 134, 28);
      contentPanel.add(telefonoPacienteTF);
    }
    {
      fechaNacimientoTF = new JTextField();
      fechaNacimientoTF.setColumns(10);
      fechaNacimientoTF.setBounds(224, 183, 134, 28);
      contentPanel.add(fechaNacimientoTF);
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
            String fechaApertura = fechaAperturaTF.getText(); 
            String cedulaPaciente = cedulaPacienteTF.getText();
            String nombrePaciente = nombrePacienteTF.getText();
            String direccionPaciente = direccionPacienteTF.getText();
            String telefonoPaciente = telefonoPacienteTF.getText();
            String fechaNacimientoPaciente = fechaNacimientoTF.getText();
            
            Expediente nuevoExpediente = new Expediente(
                fechaApertura,
                cedulaPaciente,
                nombrePaciente,
                direccionPaciente,
                telefonoPaciente,
                fechaNacimientoPaciente
                );
            try {
              gestorExpediente.registrar(nuevoExpediente);
            } catch (Exception e1) {
              // TODO Auto-generated catch block
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
