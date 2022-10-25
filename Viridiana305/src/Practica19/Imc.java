package Practica19;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Imc {

	private JFrame frame;
	private JLabel lblIMC;
	private JLabel lblGrado;
	private JLabel lblImagen;
	private JSlider slPeso;
	private JSpinner spnAltura;
	int cNaranja, cAzul, cMorado, cRojo, cVerde, cAmarillo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imc window = new Imc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Imc() {
		initialize();
	}
     
	public void imc() {
		double peso = slPeso.getValue();
		double altura = Double.parseDouble(spnAltura.getValue().toString());
		double imc = peso / (altura * altura);
		lblIMC.setText("" + redondear(imc));
		lblGrado.setOpaque(true);
		
		if(imc<=18.49) {
			lblGrado.setBackground(Color.orange);
		}else if(imc >=18.50 && imc<=24.99){
			lblGrado.setBackground(Color.blue);	
		}else if(imc >=25 && imc<=29.99) {
			lblGrado.setBackground(Color.magenta);
		}else if(imc >=30 && imc<=34.99) {
			lblGrado.setBackground(Color.red);
		}else if(imc >=35 && imc<=39.99) {
			lblGrado.setBackground(Color.green);
		}else if(imc >=40) {
			lblGrado.setBackground(Color.orange);
		}
		
	}
	public double redondear(double imc) {
		return Math.round(imc*100.0)/100.0;
	}

	public void imagendeimc() {
		Image imcimagen = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenimc/imc.jfif"));
		int ancho = lblImagen.getWidth();
		int alto = lblImagen.getWidth();
		lblImagen.setIcon(new ImageIcon(imcimagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 581);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("IMC");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("IMC");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 40));
		lblNewLabel.setBounds(309, 0, 53, 56);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Peso:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_1.setBounds(22, 77, 53, 32);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_1_1.setBounds(22, 134, 111, 32);
		frame.getContentPane().add(lblNewLabel_1_1);

		lblImagen = new JLabel("");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setBounds(388, 62, 343, 408);
		frame.getContentPane().add(lblImagen);
		imagendeimc();

		JLabel lblNewLabel_1_2 = new JLabel("TU IMC ES:");
		lblNewLabel_1_2.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_1_2.setBounds(22, 352, 111, 32);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("GRADO:");
		lblNewLabel_1_3.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblNewLabel_1_3.setBounds(24, 420, 74, 32);
		frame.getContentPane().add(lblNewLabel_1_3);

		lblIMC = new JLabel("");
		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMC.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblIMC.setBounds(138, 352, 166, 40);
		frame.getContentPane().add(lblIMC);

		lblGrado = new JLabel("");
		lblGrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblGrado.setBounds(138, 412, 166, 40);
		frame.getContentPane().add(lblGrado);

		slPeso = new JSlider();
		slPeso.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				imc();
			}
		});

		spnAltura = new JSpinner();
		spnAltura.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				imc();
			}
		});
		spnAltura.setModel(new SpinnerNumberModel(1, 1.00, 2.00, .1));
		spnAltura.setFont(new Font("Tahoma", Font.BOLD, 17));
		spnAltura.setBounds(85, 134, 293, 37);
		frame.getContentPane().add(spnAltura);

		slPeso.setValue(0);
		slPeso.setSnapToTicks(true);
		slPeso.setPaintTrack(false);
		slPeso.setPaintTicks(true);
		slPeso.setPaintLabels(true);
		slPeso.setMinorTickSpacing(10);
		slPeso.setMinimum(20);
		slPeso.setMaximum(150);
		slPeso.setMajorTickSpacing(50);
		slPeso.setBounds(85, 51, 293, 71);
		frame.getContentPane().add(slPeso);

	}
}
