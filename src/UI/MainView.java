package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainView window = new MainView();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MainView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
	  
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton btnRegistrarDoctor = new JButton("Registrar Doctor");
    btnRegistrarDoctor.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		RegistrarDoctor view = new RegistrarDoctor();
    		
    		view.setVisible(true);
    		
    		frame.dispose();
    		
    	}
    });
   
    	
    	
		
    ;
    
    
    
    JButton btnConsultarDoctor = new JButton("Consultar Doctor");
    
    JButton btnAdministracionDeExpedientes = new JButton("Administracion de Expedientes");
    
    JButton btnAdministrarConsultas = new JButton("Registrar Consulta");
    btnAdministrarConsultas.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    
    JButton btnNewButton = new JButton("Buscar Consulta");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(19)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(6)
              .addComponent(btnNewButton))
            .addComponent(btnAdministrarConsultas)
            .addComponent(btnAdministracionDeExpedientes)
            .addComponent(btnConsultarDoctor, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRegistrarDoctor))
          .addContainerGap(192, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(26)
          .addComponent(btnRegistrarDoctor)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnConsultarDoctor)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnAdministracionDeExpedientes)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnAdministrarConsultas)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnNewButton)
          .addContainerGap(77, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
