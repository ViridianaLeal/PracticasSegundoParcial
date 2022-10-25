package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AreaTriangulo {

	public JFrame frame;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JLabel lblResultado;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaTriangulo window = new AreaTriangulo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AreaTriangulo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 255);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("ÁREA DEL TRIANGULO");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setBounds(40, 44, 32, 14);
		frame.getContentPane().add(lblBase);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(40, 81, 42, 14);
		frame.getContentPane().add(lblAltura);
		
		lblResultado = new JLabel("");
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultado.setBounds(21, 143, 194, 40);
		frame.getContentPane().add(lblResultado);
		
		txtBase = new JTextField();
		txtBase.setBounds(92, 41, 123, 20);
		frame.getContentPane().add(txtBase);
		txtBase.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(92, 78, 123, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double base=Double.parseDouble(txtBase.getText().toString());
					double altura=Double.parseDouble(txtAltura.getText().toString());
					double area=(base*altura)/2;
							lblResultado.setText("El área es: " +area);
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"ERROR");
				}
			}
		});
		btnCalcular.setBounds(21, 109, 91, 23);
		frame.getContentPane().add(btnCalcular);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBase.setText("");
				txtAltura.setText("");
				lblResultado.setText("");
			}
		});
		btnBorrar.setBounds(122, 109, 93, 23);
		frame.getContentPane().add(btnBorrar);
		
		JLabel lbl = new JLabel("Área del Triángulo");
		lbl.setFont(new Font("Agency FB", Font.ITALIC, 18));
		lbl.setBounds(72, 11, 100, 20);
		frame.getContentPane().add(lbl);
	}
}
