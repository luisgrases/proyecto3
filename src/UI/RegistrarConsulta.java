package UI;

import java.awt.BorderLayout;
import Modelos.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegistrarConsulta extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JTextField descripcionProblemaTF;
  private JTextField fechaRealizacionTF;
  private JTextField medicinasRecetadasTF;
  private JComboBox doctorCB;
  private JComboBox expedienteCB;
  private GestorConsulta gestorConsulta = new GestorConsulta();
  GestorDoctor gestorDoctor = new GestorDoctor();
  GestorExpediente gestorExpediente = new GestorExpediente();
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    
    
    try {
      RegistrarConsulta dialog = new RegistrarConsulta();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   * @throws Exception 
   * @throws SQLException 
   */
  public RegistrarConsulta() throws SQLException, Exception {
    Vector doctores = gestorDoctor.listarDoctores();
    Vector expedientes = gestorExpediente.listar();
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    
    JLabel lblIdDoctor = new JLabel("Doctor");
    
    JLabel lblNewLabel = new JLabel("Fecha de realizacion");
    
    JLabel lblDescripcionDelProblem = new JLabel("Descripcion del problema");
    
    JLabel lblIdExpediente = new JLabel("Expediente");
    
    JLabel lblNewLabel_1 = new JLabel("Medicinas recetadas");
    
    descripcionProblemaTF = new JTextField();
    descripcionProblemaTF.setColumns(10);
    
    fechaRealizacionTF = new JTextField();
    fechaRealizacionTF.setColumns(10);
    
    medicinasRecetadasTF = new JTextField();
    medicinasRecetadasTF.setColumns(10);
    
    doctorCB = new JComboBox(doctores);
    expedienteCB = new JComboBox(expedientes);
    
    
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
            .addComponent(lblDescripcionDelProblem)
            .addComponent(lblNewLabel_1)
            .addComponent(lblNewLabel)
            .addComponent(lblIdDoctor)
            .addComponent(lblIdExpediente))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
            .addComponent(expedienteCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(medicinasRecetadasTF)
            .addComponent(fechaRealizacionTF)
            .addComponent(descripcionProblemaTF)
            .addComponent(doctorCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addContainerGap(127, Short.MAX_VALUE))
    );
    gl_contentPanel.setVerticalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addGap(15)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblIdDoctor)
            .addComponent(doctorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblIdExpediente)
            .addComponent(expedienteCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(12)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDescripcionDelProblem)
            .addComponent(descripcionProblemaTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(fechaRealizacionTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(medicinasRecetadasTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_1))
          .addContainerGap(38, Short.MAX_VALUE))
    );
    contentPanel.setLayout(gl_contentPanel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
            String fechaRealizacion = fechaRealizacionTF.getText();
            String descripcionProblema = descripcionProblemaTF.getText();
            String medicinasRecetadas = medicinasRecetadasTF.getText();

            try {
              TreeMap datosExpediente = (TreeMap) expedienteCB.getSelectedItem();
              TreeMap doctorSeleccionado = (TreeMap) doctorCB.getSelectedItem();
              
            
             
              gestorConsulta.agregar(
                  fechaRealizacion,
                  descripcionProblema,
                  medicinasRecetadas,
                  doctorSeleccionado,
                  datosExpediente
                  );
              JOptionPane.showMessageDialog(null, "Se registro la consulta satisfactoriamente");
            } catch (Exception e1) {
              JOptionPane.showMessageDialog(null,"Error al registrar"+e1);
             
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
