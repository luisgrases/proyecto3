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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class ListarConsultas extends JDialog {

  private final JPanel contentPanel = new JPanel();
  private JList listaConsultas;
  private GestorConsulta gestorConsulta;
  private GestorExpediente gestorExpediente;
  DefaultListModel model;
  private static ListarConsultas dialog;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      dialog = new ListarConsultas();
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
          Vector<String> consultas = gestorExpediente.listarConsultas((String)expedienteSeleccionado.get("identificacion"));
          model.removeAllElements();
          for(String fechaConsulta : consultas){
            model.addElement(fechaConsulta);  
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
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String fechaSeleccionada = (String)listaConsultas.getSelectedValue();
            TreeMap datosConsulta;
            try {
              datosConsulta = gestorExpediente.getConsultaPorFecha(fechaSeleccionada);
              JOptionPane.showMessageDialog(null, datosConsulta);
            } catch (SQLException e1) {
              JOptionPane.showMessageDialog(null, e1.getMessage());
              e1.printStackTrace();
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
    	  JButton cancelButton = new JButton("Atras");
          cancelButton.setActionCommand("Atras");
          buttonPane.add(cancelButton);
          cancelButton.addMouseListener(new MouseAdapter() {
          	@Override
          	public void mouseClicked(MouseEvent e) {
          		
          		 
          		MainView view = new MainView();
          		
          		view.setVisible(true);
          		
          		dialog.dispose();
          		
          	}
          });
      }
    }
  }
}
