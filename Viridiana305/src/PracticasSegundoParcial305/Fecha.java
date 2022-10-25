package PracticasSegundoParcial305;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Fecha {

	private JFrame frame;
	private JComboBox cboDia;
	private JComboBox cboMes;
	private JLabel lblFechas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fecha window = new Fecha();
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
	public Fecha() {
		initialize();
	}
	public void fechas() {
		lblFechas.setText(cboDia.getSelectedItem().toString()+" de " +cboMes.getSelectedItem().toString());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 271);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("Combo Box");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Día");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 17));
		lblNewLabel.setBounds(37, 27, 33, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 15));
		lblFecha.setBounds(37, 123, 68, 20);
		frame.getContentPane().add(lblFecha);
		
		lblFechas = new JLabel("");
		lblFechas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFechas.setBounds(37, 154, 345, 58);
		frame.getContentPane().add(lblFechas);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Agency FB", Font.PLAIN, 17));
		lblMes.setBounds(37, 78, 33, 26);
		frame.getContentPane().add(lblMes);
		
		cboDia = new JComboBox();
		cboDia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fechas();
				
			}
		});
		cboDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cboDia.setBounds(82, 27, 68, 26);
		frame.getContentPane().add(cboDia);
		
		cboMes = new JComboBox();
		cboMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				fechas();
				
			}
		});
		cboMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cboMes.setBounds(82, 83, 68, 26);
		frame.getContentPane().add(cboMes);
	}

}
