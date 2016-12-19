package UI;

import java.awt.BorderLayout;
import Modelos.*;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;


public class ListarConsultas extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JList listaConsultas;
  private GestorConsulta gestorConsulta;
  private GestorExpediente gestorExpediente;
  DefaultListModel model;

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
    
    gestorConsulta = new GestorConsulta();
    gestorExpediente = new GestorExpediente();
    model = new DefaultListModel();
    JList listaConsultas = new JList(model);
    
    Vector<TreeMap> consultas = new Vector<TreeMap>();
    Vector<TreeMap> expedientes = new Vector<TreeMap>();
    try {
      expedientes = gestorExpediente.listar();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    JList listaExpedientes = new JList(expedientes.toArray());
    
    
    listaExpedientes.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        
        TreeMap expedienteSeleccionado = (TreeMap)listaExpedientes.getSelectedValue();
        try {
          Vector<TreeMap> consultas = gestorExpediente.listarConsultas((String)expedienteSeleccionado.get("id"));
          model.removeAllElements();
          for(TreeMap consulta : consultas){
            model.addElement(consulta);  
          }
          
        } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(236, 6, 166, 223);
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(6, 6, 203, 216);
    
    scrollPane_1.setViewportView(listaExpedientes);
    contentPanel.setLayout(null);
    
    scrollPane.setViewportView(listaConsultas);
    contentPanel.add(scrollPane);
    contentPanel.add(scrollPane_1);
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
