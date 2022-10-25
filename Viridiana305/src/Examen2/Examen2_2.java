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

public class Examen2_2 {

	private JFrame frame;
	private JTextField txtTexto;
	private JLabel etiTexto1;
	private JLabel etiTexto2;
	private JButton btnTranspasa2;
	private JButton btnTranspasa1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2_2 window = new Examen2_2();
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
	public Examen2_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 456);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("EXAMEN 2 EJERCICIO 2");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(56, 78, 105, 20);
		frame.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
		
		etiTexto1 = new JLabel("");
		etiTexto1.setBorder(new LineBorder(new Color(0, 0, 0)));
		etiTexto1.setBounds(189, 39, 144, 38);
		frame.getContentPane().add(etiTexto1);
		
		etiTexto2 = new JLabel("");
		etiTexto2.setBorder(new LineBorder(new Color(0, 0, 0)));
		etiTexto2.setBounds(189, 96, 144, 38);
		frame.getContentPane().add(etiTexto2);
		
		btnTranspasa1 = new JButton("Transpasa 1");
		btnTranspasa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto1=txtTexto.getText();
				etiTexto1.setText(texto1);
			}
		});
		btnTranspasa1.setBounds(57, 169, 119, 23);
		frame.getContentPane().add(btnTranspasa1);
		
		btnTranspasa2 = new JButton("Transpasa 2");
		btnTranspasa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto2=txtTexto.getText();
				etiTexto2.setText(texto2);
			}
		});
		btnTranspasa2.setBounds(200, 169, 119, 23);
		frame.getContentPane().add(btnTranspasa2);
	}
}
