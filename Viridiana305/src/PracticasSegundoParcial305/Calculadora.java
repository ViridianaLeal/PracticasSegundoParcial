package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora {

	public JFrame frame;
	private JLabel lblRsuma;
	private JLabel lblRresta;
	private JLabel lblRmulti;
	private JLabel lblRdivi;
	private JLabel lblRresiduo;
	private JButton btnBorrar;
	private JButton btnResiduo;
	private JButton btnDivison;
	private JButton btnMultiplicacin;
	private JButton btnResta;
	private JButton btnSuma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 327, 347);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("CALCULADORA");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnSuma = new JButton("SUMA");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 1:"));
				    int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 2:"));
				    int suma=a+b;
				    JOptionPane.showMessageDialog(null,"La suma :"+suma);
				    lblRsuma.setText("La suma es:"+suma); 
			}
		});
		btnSuma.setBounds(25, 23, 89, 29);
		frame.getContentPane().add(btnSuma);
		
		btnResta = new JButton("RESTA");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 1:"));
				    int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 2:"));
				    int resta=a-b;
				    JOptionPane.showMessageDialog(null,"La resta :"+resta);
				    lblRresta.setText("La resta es:"+resta); 
			}
		});
		btnResta.setBounds(25, 77, 89, 29);
		frame.getContentPane().add(btnResta);
		
		btnMultiplicacin = new JButton("MULTIPLICACIÓN");
		btnMultiplicacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 1:"));
				    int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 2:"));
				    int multiplicacion=a*b;
				    JOptionPane.showMessageDialog(null,"La multiplicación :"+multiplicacion);
				    lblRmulti.setText("La multiplicación es:"+multiplicacion); 
			}
		});
		btnMultiplicacin.setBounds(25, 117, 117, 29);
		frame.getContentPane().add(btnMultiplicacin);
		
		btnDivison = new JButton("DIVISÓN");
		btnDivison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 1:"));
			    int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 2:"));
			    int division=a/b;
			    JOptionPane.showMessageDialog(null,"La division :"+division);
			    lblRdivi.setText("La división es:"+division); 
			}
		});
		btnDivison.setBounds(25, 161, 89, 29);
		frame.getContentPane().add(btnDivison);
		
		btnResiduo = new JButton("RESIDUO");
		btnResiduo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 1:"));
			    int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce número 2:"));
			    int residuo=a%b;
			    JOptionPane.showMessageDialog(null,"El residuo :"+residuo);
			    lblRresiduo.setText("El residuo es:"+residuo); 
			}
		});
		btnResiduo.setBounds(25, 201, 89, 29);
		frame.getContentPane().add(btnResiduo);
		
		lblRsuma = new JLabel("");
		lblRsuma.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRsuma.setBounds(152, 23, 126, 29);
		frame.getContentPane().add(lblRsuma);
		
		lblRresta = new JLabel("");
		lblRresta.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRresta.setBounds(152, 77, 126, 36);
		frame.getContentPane().add(lblRresta);
		
		lblRmulti = new JLabel("");
		lblRmulti.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRmulti.setBounds(152, 124, 126, 29);
		frame.getContentPane().add(lblRmulti);
		
		lblRdivi = new JLabel("");
		lblRdivi.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRdivi.setBounds(152, 161, 126, 29);
		frame.getContentPane().add(lblRdivi);
		
		lblRresiduo = new JLabel("");
		lblRresiduo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRresiduo.setBounds(152, 201, 126, 29);
		frame.getContentPane().add(lblRresiduo);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    lblRsuma.setText("");
			        lblRresta.setText("");
			        lblRmulti.setText("");
			        lblRdivi.setText("");
			        lblRresiduo.setText("");
			}
		});
		btnBorrar.setBounds(103, 264, 89, 23);
		frame.getContentPane().add(btnBorrar);
	}
}

