package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.List;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelos.Consulta;
import Modelos.Doctor;
import Modelos.Expediente;
import Modelos.GestorDoctor;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ConsultarDoctor extends JDialog {
  private GestorDoctor gestorDoctor = new GestorDoctor() ;
  private JPanel buttonPane;
  private JTextField idTF;
  JList list;
  private static ConsultarDoctor dialog;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      dialog = new ConsultarDoctor();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public ConsultarDoctor() {
    
    Vector<TreeMap> datosDoctores;
    try {
    	
      datosDoctores = gestorDoctor.listarDoctores();
      list = new JList(datosDoctores.toArray());
    
    } catch (Exception e1) {
    	
      System.out.println("No se encontraron doctores");
      e1.printStackTrace();
    
    }
    
    
    setBounds(100, 100, 474, 322);
    {
      buttonPane = new JPanel();
      buttonPane.setBounds(0, 239, 450, 39);
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      {
        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            TreeMap doctorSeleccionado = (TreeMap)list.getSelectedValue();
            TreeMap datosDoctor;
            try {
              datosDoctor = gestorDoctor.buscarDoctor((String)doctorSeleccionado.get("id"));
              JOptionPane.showMessageDialog(null,
                  "Id: " + datosDoctor.get("id")+ "\n" +
                  "Nombre: " + datosDoctor.get("nombre") + "\n" +
                  "Especialidad: " + datosDoctor.get("especialidad") + "\n" +
                  "Telefono: " + datosDoctor.get("telefono")
                  );
            } catch (SQLException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            } catch (Exception e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
            
          }
        });
        
        mostrarButton.setActionCommand("OK");
        buttonPane.add(mostrarButton);
        getRootPane().setDefaultButton(mostrarButton);
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
    
    idTF = new JTextField();
    idTF.setBounds(27, 22, 134, 28);
    idTF.setText("ID");
    idTF.setColumns(10);
    getContentPane().setLayout(null);
    getContentPane().add(buttonPane);
    getContentPane().add(idTF);
    {
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(24, 62, 323, 165);
      getContentPane().add(scrollPane);
      {
        scrollPane.setViewportView(list);
      }
    }
    {
      JButton buscarPorIdBtn = new JButton("Buscar por id");
      buscarPorIdBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String id = idTF.getText();
          try {
            TreeMap datosDoctor = gestorDoctor.buscarDoctor(id);
            JOptionPane.showMessageDialog(null,
                "Id: " + datosDoctor.get("id")+ "\n" +
                "Nombre: " + datosDoctor.get("nombre") + "\n" +
                "Especialidad: " + datosDoctor.get("especialidad") + "\n" +
                "Telefono: " + datosDoctor.get("telefono")
                );
          } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "El doctor no esta registrado "+"\n"+e1);
            e1.printStackTrace();
          }
          
        }
      });
      buscarPorIdBtn.setBounds(173, 23, 117, 29);
      getContentPane().add(buscarPorIdBtn);
    }
  }
  
}
