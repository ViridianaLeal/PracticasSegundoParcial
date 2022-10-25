package Examen2;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Examen2_1 {

	private JFrame frame;
	private JLabel etiNombre;
	private JLabel etiCiudad;
	private JButton btnOcultarNombre;
	private JButton btnVisuNombre;
	private JButton btnOcultarCiudad;
	private JButton btnVisuCiudad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2_1 window = new Examen2_1();
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
	public Examen2_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 183);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("EXAMEN 2 EJERCICIO 1");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		etiNombre = new JLabel("Nombre");
		etiNombre.setFont(new Font("Agency FB", Font.PLAIN, 26));
		etiNombre.setBounds(53, 28, 113, 36);
		frame.getContentPane().add(etiNombre);
		
		etiCiudad = new JLabel("Ciudad");
		etiCiudad.setFont(new Font("Agency FB", Font.PLAIN, 26));
		etiCiudad.setBounds(53, 79, 113, 36);
		frame.getContentPane().add(etiCiudad);
		
		btnOcultarNombre = new JButton("Ocultar nombre");
		btnOcultarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiNombre.setVisible(false);
			}
		});
		btnOcultarNombre.setBounds(373, 24, 153, 44);
		frame.getContentPane().add(btnOcultarNombre);
		
		btnVisuNombre = new JButton("Visualizar Nombre");
		btnVisuNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiNombre.setVisible(true);
			}
		});
		btnVisuNombre.setBounds(188, 28, 153, 36);
		frame.getContentPane().add(btnVisuNombre);
		
		btnOcultarCiudad = new JButton("Ocultar Ciudad");
		btnOcultarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiCiudad.setVisible(false);
			}
		});
		btnOcultarCiudad.setBounds(373, 79, 155, 36);
		frame.getContentPane().add(btnOcultarCiudad);
		
		btnVisuCiudad = new JButton("Visualizar Ciudad ");
		btnVisuCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiCiudad.setVisible(true);
			}
		});
		btnVisuCiudad.setBounds(188, 79, 153, 36);
		frame.getContentPane().add(btnVisuCiudad);
	}
}
