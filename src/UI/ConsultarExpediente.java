package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.GestorExpediente;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultarExpediente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtExpediente;
	GestorExpediente gestorExpediente = new GestorExpediente();
	String datosExpediente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarExpediente frame = new ConsultarExpediente();
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
	public ConsultarExpediente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCedula = new JTextField();
		txtCedula.setText("Cedula paciente");
		txtCedula.setBounds(113, 44, 116, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtExpediente = new JTextField();
		txtExpediente.setText("Buscar por numero de expediente");
		txtExpediente.setBounds(113, 117, 203, 22);
		contentPane.add(txtExpediente);
		txtExpediente.setColumns(10);
		
		JButton btnBuscarPorCedulaPaciente = new JButton("Buscar por cedula de paciente");
		btnBuscarPorCedulaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCedulaPaciente();
			}
		});
		btnBuscarPorCedulaPaciente.setBounds(107, 79, 228, 25);
		contentPane.add(btnBuscarPorCedulaPaciente);
		
		JButton btnBuscarPorNumeroExpediente = new JButton("Buscar por numero de expediente");
		btnBuscarPorNumeroExpediente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				buscarExpedientePaciente();
				
			}

			
		});
		btnBuscarPorNumeroExpediente.setBounds(113, 160, 253, 25);
		contentPane.add(btnBuscarPorNumeroExpediente);
	}
	
	private void buscarCedulaPaciente() {
		
		
		
		String cedula=txtCedula.getText();
		
		
		
		try {
			TreeMap datosExpediente = gestorExpediente.buscarCedulaPaciente(cedula);
			JOptionPane.showMessageDialog(null,datosExpediente.toString());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La cedula no esta registrada");
		}
		
		
		
	}
	
	private void buscarExpedientePaciente() {
		
		String numeroExpediente = txtExpediente.getText();
		
		try {
			TreeMap datosExpediente = gestorExpediente.buscarExpedientePaciente(numeroExpediente);
			
			JOptionPane.showMessageDialog(null,datosExpediente.toString());
		} catch (Exception e) {
			  
			JOptionPane.showMessageDialog(null, "El expediente no esta registrado");
		}
		
		
	}

}
