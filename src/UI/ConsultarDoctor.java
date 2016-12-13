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
import Modelos.Gestor;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ConsultarDoctor extends JDialog {
  private Gestor gestor;
  private JPanel buttonPane;
  private JTextField idTF;
  JList list;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      ConsultarDoctor dialog = new ConsultarDoctor();
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
    gestor = new Gestor();
    Vector<Doctor> doctores;
    try {
      doctores = gestor.listarDoctores();
      list = new JList(doctores.toArray());
    } catch (Exception e1) {
      System.out.println("No se encontraron doctores");
      e1.printStackTrace();
    }
    
    
    setBounds(100, 100, 450, 300);
    {
      buttonPane = new JPanel();
      buttonPane.setBounds(0, 239, 450, 39);
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      {
        JButton mostrarButton = new JButton("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Doctor doctorSeleccionado = (Doctor)list.getSelectedValue();
            JOptionPane.showMessageDialog(null,
                "Id: " + doctorSeleccionado.getId() + "\n" +
                "Nombre: " + doctorSeleccionado.getNombre() + "\n" +
                "Especialidad: " + doctorSeleccionado.getEspecialidad() + "\n" +
                "Telefono: " + doctorSeleccionado.getTelefono()
                );
          }
        });
        
        mostrarButton.setActionCommand("OK");
        buttonPane.add(mostrarButton);
        getRootPane().setDefaultButton(mostrarButton);
      }
      {
        JButton cancelButton = new JButton("Salir");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
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
            Doctor doctor = gestor.buscarDoctor(id);
            JOptionPane.showMessageDialog(null,
                "Id: " + doctor.getId() + "\n" +
                "Nombre: " + doctor.getNombre() + "\n" +
                "Especialidad: " + doctor.getEspecialidad() + "\n" +
                "Telefono: " + doctor.getTelefono()
                );
          } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          
        }
      });
      buscarPorIdBtn.setBounds(173, 23, 117, 29);
      getContentPane().add(buscarPorIdBtn);
    }
  }
  
}
