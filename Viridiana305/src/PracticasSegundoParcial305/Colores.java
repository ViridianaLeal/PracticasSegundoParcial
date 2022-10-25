package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Colores {

	public JFrame frame;	
	private JRadioButton radRojo;
	private JRadioButton radAzul;
	private JRadioButton radVerde;
	private JRadioButton radAmarillo;
	private JLabel lblColores;
	ButtonGroup grupo = new ButtonGroup();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Colores window = new Colores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Colores() {
		initialize();
		grupo.add(radRojo);
		grupo.add(radAzul);
		grupo.add(radVerde);
		grupo.add(radAmarillo);
	}
	
	public void	cambiarColor(){
		if(radRojo.isSelected())lblColores.setBackground(Color.red); 
		if(radAzul.isSelected())lblColores.setBackground(Color.blue); 
		if(radVerde.isSelected())lblColores.setBackground(Color.green); 
		if(radAmarillo.isSelected())lblColores.setBackground(Color.yellow); 
			
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 336, 299);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("COLORES");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblColores = new JLabel("");
		lblColores.setOpaque(true);
		lblColores.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblColores.setBounds(130, 31, 155, 197);
		frame.getContentPane().add(lblColores);
		
		radRojo = new JRadioButton("Rojo");
		radRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		radRojo.setBounds(31, 43, 80, 23);
		frame.getContentPane().add(radRojo);
		
		radAzul = new JRadioButton("Azul");
		radAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		radAzul.setBounds(31, 93, 71, 23);
		frame.getContentPane().add(radAzul);
		
		radVerde = new JRadioButton("Verde");
		radVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		radVerde.setBounds(31, 142, 80, 23);
		frame.getContentPane().add(radVerde);
		
		radAmarillo = new JRadioButton("Amarillo");
		radAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		radAmarillo.setBounds(31, 197, 80, 23);
		frame.getContentPane().add(radAmarillo);
	}
}
