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
import javax.swing.JLabel;

public class RegistrarDoctor extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField nombreTF;
  private JTextField especialidadTF;
  private JTextField telefonoTF;
  private GestorDoctor gestorDoctor = new GestorDoctor();
  MainView window = new MainView();
  public Validate validate = new Validate();
  private static RegistrarDoctor dialog;
  
 

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      dialog = new RegistrarDoctor();
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
      nombreTF.setBounds(37, 41, 116, 22);
      contentPanel.add(nombreTF);
      nombreTF.setColumns(10);
    }
    {
      especialidadTF = new JTextField();
      especialidadTF.setBounds(156, 41, 116, 22);
      contentPanel.add(especialidadTF);
      especialidadTF.setColumns(10);
    }
    {
      telefonoTF = new JTextField();
      telefonoTF.setBounds(277, 41, 116, 22);
      contentPanel.add(telefonoTF);
      telefonoTF.setColumns(10);
    }
    {
      JButton okButton = new JButton("OK");
      okButton.setBounds(143, 193, 116, 25);
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
    		
    		 
    		MainView view = new MainView();
    		
    		view.setVisible(true);
    		
    		dialog.dispose();
    		
    	}
    });
   
    btnNewButton.setBounds(316, 193, 71, 25);
    contentPanel.add(btnNewButton);
    
    JLabel lblNombre = new JLabel("Nombre");
    lblNombre.setBounds(37, 12, 56, 16);
    contentPanel.add(lblNombre);
    
    JLabel lblEspecialidad = new JLabel("Especialidad");
    lblEspecialidad.setBounds(156, 12, 116, 16);
    contentPanel.add(lblEspecialidad);
    
    JLabel lblNewLabel = new JLabel("Telefono");
    lblNewLabel.setBounds(284, 12, 56, 16);
    contentPanel.add(lblNewLabel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }
  }
}
