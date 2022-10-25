package Examen2;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Examen2_3 {

	private JFrame frame;
	private JTextField txtTexto;
	private JLabel etiTexto;
	private JButton btnVaciar;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2_3 window = new Examen2_3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Examen2_3() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 284, 182);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("EXAMEN 2 EJERCICIO 3");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTexto = new JTextField();
		txtTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String texto=txtTexto.getText();
				etiTexto.setText(texto);
			}
		});
		txtTexto.setBounds(25, 35, 86, 20);
		frame.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
		
		etiTexto = new JLabel("");
		etiTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
		etiTexto.setBounds(154, 35, 104, 17);
		frame.getContentPane().add(etiTexto);
		
		btnVaciar = new JButton("Vaciar");
		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiTexto.setText("");
				txtTexto.setText("");
			}
		});
		btnVaciar.setBounds(79, 81, 89, 23);
		frame.getContentPane().add(btnVaciar);
	}

}
