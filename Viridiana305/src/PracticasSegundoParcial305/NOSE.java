package PracticasSegundoParcial305;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NOSE {

	private JFrame frame;
	private JLabel lblResultado;
	private JComboBox cboNombres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NOSE window = new NOSE();
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
	public NOSE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 358, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(40, 36, 47, 47);
		frame.getContentPane().add(lblNewLabel);
		
		cboNombres = new JComboBox();
		cboNombres.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblResultado.setText("Hola "+cboNombres.getSelectedItem().toString());
			}
		});
		cboNombres.setModel(new DefaultComboBoxModel(new String[] {"Juana", "Alessandra", "Sofia", "Vidal", "Mateo"}));
		cboNombres.setBounds(122, 42, 153, 35);
		frame.getContentPane().add(cboNombres);
		
		lblResultado = new JLabel("");
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultado.setBounds(40, 106, 238, 84);
		frame.getContentPane().add(lblResultado);
	}
}
