package UI;

import java.awt.BorderLayout;
import Modelos.*;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ListarConsultas extends JDialog {

  private final JPanel contentPanel = new JPanel();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      ListarConsultas dialog = new ListarConsultas();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public ListarConsultas() {
    
    Vector<Consulta> consultas = new Vector<Consulta>();
    try {
      consultas = GestorConsulta.listar();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    JList list = new JList(consultas.toArray());
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
          .addContainerGap())
    );
    gl_contentPanel.setVerticalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap()
          .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
    );
    
    scrollPane.setViewportView(list);
    contentPanel.setLayout(gl_contentPanel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Mostrar");
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
