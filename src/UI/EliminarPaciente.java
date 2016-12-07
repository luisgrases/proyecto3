package UI;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.GestorPaciente;

import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EliminarPaciente extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private GestorPaciente gestorPaciente;
  JComboBox comboBox ;
  private ArrayList ids = new ArrayList();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      EliminarPaciente dialog = new EliminarPaciente();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public EliminarPaciente() {
    
    gestorPaciente = new GestorPaciente();
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    JLabel lblEspecifiqueElId = new JLabel("Especifique la cedula del paciente a eliminar");
    
    comboBox = new JComboBox();
    try {
		ids=gestorPaciente.buscarIds();
		
		for(int i=0;i<ids.size();i++){
			
			comboBox.addItem(ids.get(i));
			
		}
	} catch (Exception e2) {
		
		e2.printStackTrace();
	}
    
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
    	gl_contentPanel.createParallelGroup(Alignment.TRAILING)
    		.addGroup(gl_contentPanel.createSequentialGroup()
    			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_contentPanel.createSequentialGroup()
    					.addGap(96)
    					.addComponent(lblEspecifiqueElId))
    				.addGroup(gl_contentPanel.createSequentialGroup()
    					.addGap(133)
    					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
    			.addContainerGap(73, Short.MAX_VALUE))
    );
    gl_contentPanel.setVerticalGroup(
    	gl_contentPanel.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPanel.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(lblEspecifiqueElId)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap(144, Short.MAX_VALUE))
    );
    contentPanel.setLayout(gl_contentPanel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            String id = (String) comboBox.getSelectedItem();
            try {
              gestorPaciente.borrar(id);
              JOptionPane.showMessageDialog(null, "borrado");
              dispose();
              
            } catch (Exception e1) {
              JOptionPane.showMessageDialog(null, e1.getMessage());
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
