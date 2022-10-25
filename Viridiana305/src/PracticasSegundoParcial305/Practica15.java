package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Practica15 {

	private JFrame frame;
	private JLabel lblResultado;
	private JComboBox cboA;
	private JComboBox cboDe;
	private JSlider spnCantidad;
	private JLabel lblCantidad;
	int Cantidad = 0;
	double conversion = 0;
	String de = "EUR";
	String a = "EUR";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica15 window = new Practica15();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Practica15() {
		initialize();
	}

	public String aMoneda(double cantidad, String moneda) {
		return "$ " + Math.round(cantidad * 100.0) / 100.0 + " " + moneda;
	}

	public void convertir() {
		switch (de) {
		case "EUR":
			if (a.equals("USD")) {
				conversion = Cantidad * 0.97;
			} else if (a.equals("MXN")) {
				conversion = Cantidad * 19.37;
			} else {
				conversion = Cantidad;
			}
			break;
		case "USD":
			if (a.equals("EUR")) {
				conversion = Cantidad * 0.86;
			} else if (a.equals("MXN")) {
				conversion = Cantidad * 20.34;
			} else {
				conversion = Cantidad;
			}
			break;
		case "MXN":
			if (a.equals("EUR")) {
				conversion = Cantidad * 0.052;
			} else if (a.equals("USD")) {
				conversion = Cantidad * 0.050;
			} else {
				conversion = Cantidad;
			}
			break;
		}
		lblResultado.setText(aMoneda(Cantidad, de) + " -> " + aMoneda(conversion, a));
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 381);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("CONVERSOR ");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblCantidad = new JLabel("1");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(497, 72, 46, 14);
		frame.getContentPane().add(lblCantidad);

		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 11, 490, 26);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("DE");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(49, 113, 26, 14);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("A");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(217, 113, 26, 14);
		frame.getContentPane().add(lblNewLabel_1_2);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultado.setBounds(27, 184, 494, 119);
		frame.getContentPane().add(lblResultado);

		spnCantidad = new JSlider();
		spnCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Cantidad = spnCantidad.getValue();
				lblCantidad.setText("" + Cantidad);
				convertir();
			}
		});
		spnCantidad.setPaintTicks(true);
		spnCantidad.setValue(1);
		spnCantidad.setMajorTickSpacing(1);
		spnCantidad.setBounds(43, 48, 448, 61);
		frame.getContentPane().add(spnCantidad);
		cboDe = new JComboBox();
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cboDe.getSelectedItem().toString();
				convertir();
			}
		});
		cboDe.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "MXN" }));
		cboDe.setBounds(40, 138, 96, 22);
		frame.getContentPane().add(cboDe);

		cboA = new JComboBox();
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cboA.getSelectedItem().toString();
				convertir();
			}
		});
		cboA.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "MXN" }));
		cboA.setBounds(227, 138, 70, 22);
		frame.getContentPane().add(cboA);

	}
}
