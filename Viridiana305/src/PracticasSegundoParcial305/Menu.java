package PracticasSegundoParcial305;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class Menu {

	private JFrame frame;
	Calculadora cal=new Calculadora();
	Chicharronera chicha=new Chicharronera();
	Cecytem cecy = new Cecytem();
	TablasMultiplicar ta = new TablasMultiplicar();
	JOptionPane pane = new JOptionPane();
	AreaTriangulo tri = new AreaTriangulo();
	Colores col = new Colores();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 344);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("MENÚ");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CHICHARRONERA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chicha.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(38, 226, 156, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CALCULADORA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cal.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(38, 62, 156, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("MIS PRACTICAS");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 10, 123, 41);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		JButton btnNewButton_3 = new JButton("CECYTEM");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cecy.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(38, 174, 156, 41);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("TABLAS DE MULTIPLICAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ta.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(219, 117, 186, 41);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("JOPTIONPANE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pane.frame.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(38, 114, 156, 46);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("ÁREA TRIANGULO");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tri.frame.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(219, 62, 186, 41);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnColores = new JButton("COLORES");
		btnColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colores window = new Colores();
				col.frame.setVisible(true);
			}
		});
		btnColores.setBounds(219, 174, 186, 41);
		frame.getContentPane().add(btnColores);
	}
}
