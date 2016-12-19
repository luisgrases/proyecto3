package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.Validate;

import Modelos.Doctor;

import Modelos.GestorDoctor;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarDoctor extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField nombreTF;
  private JTextField especialidadTF;
  private JTextField telefonoTF;
  private GestorDoctor gestorDoctor = new GestorDoctor();
  MainView window = new MainView();
  public Validate validate = new Validate();
  
 

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
    
        
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      nombreTF = new JTextField();
      nombreTF.setBounds(37, 10, 116, 22);
      nombreTF.setText("Nombre");
      contentPanel.add(nombreTF);
      nombreTF.setColumns(10);
    }
    {
      especialidadTF = new JTextField();
      especialidadTF.setBounds(158, 10, 116, 22);
      especialidadTF.setText("Especialidad");
      contentPanel.add(especialidadTF);
      especialidadTF.setColumns(10);
    }
    {
      telefonoTF = new JTextField();
      telefonoTF.setBounds(279, 10, 116, 22);
      telefonoTF.setText("Telefono");
      contentPanel.add(telefonoTF);
      telefonoTF.setColumns(10);
    }
    {
      JButton okButton = new JButton("OK");
      okButton.setBounds(300, 193, 49, 25);
      contentPanel.add(okButton);
      okButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          
          String nombre = nombreTF.getText();
          String especialidad = especialidadTF.getText();
          String telefono = telefonoTF.getText();
          
          try {
            gestorDoctor.registrarDoctor(nombre, especialidad, telefono);
            JOptionPane.showMessageDialog(null, "El doctor se ha creado satisfactoriamente");
          
          } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Hubo un error al registrar el doctor"+e1);
            e1.printStackTrace();
          }
        }
      });
      okButton.setActionCommand("OK");
      getRootPane().setDefaultButton(okButton);
    }
    
    JButton btnNewButton = new JButton("Atras");
    btnNewButton.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		 
    		 
    		 
    		
    	}
    });
   
    btnNewButton.setBounds(361, 193, 71, 25);
    contentPanel.add(btnNewButton);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }
  }
}
