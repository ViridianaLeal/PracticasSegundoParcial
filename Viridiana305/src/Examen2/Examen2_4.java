package Examen2;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Examen2_4 {

	private JFrame frame;
	private JTextField txtNombre;
	private JButton btnActivar;
	private JButton btnDesactivar;
	private JButton btnAceptar;
	private JLabel txtFrase;
	private JTextField txtCiudad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2_4 window = new Examen2_4();
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
	public Examen2_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 443, 258);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("EXAMEN 2 EJERCICIO 4");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(21, 31, 162, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(21, 69, 162, 20);
		frame.getContentPane().add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtFrase = new JLabel("");
		txtFrase.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFrase.setBounds(21, 114, 394, 20);
		frame.getContentPane().add(txtFrase);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txtNombre.getText();
				String ciudad=txtCiudad.getText();
				txtFrase.setText("Usted se llama " +nombre+ " y vive en " +ciudad);
			}
		});
		btnAceptar.setBounds(178, 145, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		btnDesactivar = new JButton("Desactivar");
		btnDesactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setEnabled(false);
				txtCiudad.setEnabled(false);
			}
		});
		btnDesactivar.setBounds(21, 179, 115, 23);
		frame.getContentPane().add(btnDesactivar);
		
		btnActivar = new JButton("Activar");
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setEnabled(true);
				txtCiudad.setEnabled(true);
			}
		});
		btnActivar.setBounds(303, 179, 89, 23);
		frame.getContentPane().add(btnActivar);
	}

}
