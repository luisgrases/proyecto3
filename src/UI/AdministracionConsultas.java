package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministracionConsultas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */public static AdministracionConsultas frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AdministracionConsultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministracionConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar Consulta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrarConsulta view;
				try {
					view = new RegistrarConsulta();
					view.setVisible(true);
					
					frame.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.setBounds(40, 83, 163, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista Consultas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarConsultas view = new ListarConsultas();
				view.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(215, 83, 138, 25);
		contentPane.add(btnNewButton_1);
	}
}
