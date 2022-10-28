package PracticasSegundoParcial305;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

public class Temperatura {

	private JFrame frmTemperatura;
	private JLabel lblValor;
	private JSlider slValor;
	private JComboBox cboDe;
	private JComboBox cboA;
	private JLabel lblConversion;
	double Cantidad = 0;
	double conversion = 0;
	String de = "C°";
	String a = "C°";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura window = new Temperatura();
					window.frmTemperatura.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Temperatura() {
		initialize();
		slValor.setFocusTraversalKeysEnabled(true);
		;
		lblConversion.setText("" + conversion);
	}

	public void Convertir() {
		switch (de) {
		case "C°":
			if (a.equals("K°")) {
				conversion = Cantidad + 273.15;
			} else if (a.equals("F°")) {
				conversion = ((9 * Cantidad) / 5) + 32;
			} else {
				conversion = Cantidad;
			}
			break;
		case "K°":
			if (a.equals("F°")) {
				conversion =((9*(Cantidad-273.15))/5)+32;
			} else if (a.equals("C°")) {
				conversion =  Cantidad-273.15;
			} else {
				conversion = Cantidad;
			}
			break;
		case "F°":
			if (a.equals("C°")) {
				conversion = (5 * Cantidad - 32) / 9;
			} else if (a.equals("K°")) {
				conversion = (((5 * (Cantidad - 32)) / 9)) + 273.15;
			} else {
				conversion = Cantidad;
			}
			break;
		}
		lblConversion.setText(Cantidad + " " + de + " -> " + conversion + " " + a);
	}

	private void initialize() {
		frmTemperatura = new JFrame();
		frmTemperatura.setBounds(100, 100, 467, 415);
		frmTemperatura.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frmTemperatura.setTitle("TEMPERATURA");
		frmTemperatura.setLocationRelativeTo(null);
		frmTemperatura.setResizable(false);		
		frmTemperatura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTemperatura.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblNewLabel.setBounds(21, 11, 53, 38);
		frmTemperatura.getContentPane().add(lblNewLabel);

		slValor = new JSlider();
		slValor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Cantidad = slValor.getValue();
				lblValor.setText("" + Cantidad);
				Convertir();
			}
		});
		slValor.setBounds(31, 48, 266, 38);
		frmTemperatura.getContentPane().add(slValor);

		lblValor = new JLabel("");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValor.setBounds(322, 48, 46, 51);
		frmTemperatura.getContentPane().add(lblValor);

		JLabel lblNewLabel_1 = new JLabel("De:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(21, 97, 71, 38);
		frmTemperatura.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("A:");
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 40));
		lblNewLabel_1_1.setBounds(209, 97, 71, 38);
		frmTemperatura.getContentPane().add(lblNewLabel_1_1);

		cboDe = new JComboBox();
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cboDe.getSelectedItem().toString();
				Convertir();
			}
		});
		cboDe.setModel(new DefaultComboBoxModel(new String[] {"C°", "K°", "F°"}));
		cboDe.setBounds(31, 146, 139, 27);
		frmTemperatura.getContentPane().add(cboDe);

		cboA = new JComboBox();
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cboA.getSelectedItem().toString();
				Convertir();
			}
		});
		cboA.setModel(new DefaultComboBoxModel(new String[] { "C°", "K°", "F°" }));
		cboA.setBounds(241, 146, 139, 27);
		frmTemperatura.getContentPane().add(cboA);

		lblConversion = new JLabel("");
		lblConversion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversion.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblConversion.setBounds(31, 203, 348, 51);
		frmTemperatura.getContentPane().add(lblConversion);
		Convertir();
	}
}
