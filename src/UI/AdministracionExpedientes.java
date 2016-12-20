package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministracionExpedientes extends JFrame {

	private JPanel contentPane;
	public static AdministracionExpedientes frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AdministracionExpedientes();
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
	public AdministracionExpedientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbrirExpediente = new JButton("Abrir Expediente");
		btnAbrirExpediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirExpediente view = new AbrirExpediente ();
				
				view.setVisible(true);
				
				frame.dispose();
				
			}
		});
		btnAbrirExpediente.setBounds(45, 91, 138, 25);
		contentPane.add(btnAbrirExpediente);
		
		JButton btnConsultarExpediente = new JButton("Consultar Expediente");
		btnConsultarExpediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultarExpediente view = new ConsultarExpediente();
				view.setVisible(true);
				frame.dispose();
			}
		});
		btnConsultarExpediente.setBounds(214, 91, 175, 25);
		contentPane.add(btnConsultarExpediente);
	}
}
