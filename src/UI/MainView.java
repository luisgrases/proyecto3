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
    btnConsultarDoctor.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		ConsultarDoctor view = new ConsultarDoctor();
    		
    		view.setVisible(true);
    		
    		frame.dispose();
    		
    	}
    });	
    ;
    
    JButton btnAdministracionDeExpedientes = new JButton("Administracion de Expedientes");
    btnAdministracionDeExpedientes.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		AdministracionExpedientes view = new AdministracionExpedientes();
    		
    		view.setVisible(true);
    		
    		frame.dispose();
    		
    	}
    });	
    ;
    
    
    JButton btnAdministrarConsultas = new JButton("Administracion de consultas");
    btnAdministrarConsultas.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		AdministracionConsultas view = new AdministracionConsultas();
    		
    		view.setVisible(true);
    		
    		frame.dispose();
    		
    	}
    });	
    ;
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
    			.addGap(116)
    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
    				.addComponent(btnRegistrarDoctor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
    				.addComponent(btnConsultarDoctor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
    				.addComponent(btnAdministracionDeExpedientes, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
    				.addComponent(btnAdministrarConsultas, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
    			.addGap(109))
    );
    groupLayout.setVerticalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(42)
    			.addComponent(btnRegistrarDoctor)
    			.addGap(18)
    			.addComponent(btnConsultarDoctor)
    			.addGap(18)
    			.addComponent(btnAdministracionDeExpedientes)
    			.addGap(18)
    			.addComponent(btnAdministrarConsultas)
    			.addContainerGap(57, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }

  	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
  		frame.setVisible(b);
	}
}
