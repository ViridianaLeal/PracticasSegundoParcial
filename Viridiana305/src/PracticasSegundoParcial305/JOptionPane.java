package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOptionPane {

	public JFrame frame;
	private JLabel lblMensaje;
	private JLabel lblMensaje_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane window = new JOptionPane();
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
	public JOptionPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 391, 318);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("TIPOS DE OPTIONPANE");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMensaje = new JButton("MENSAJE");
		btnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.JOptionPane.showMessageDialog(null, "MENSAJE 1");
				javax.swing.JOptionPane.showMessageDialog(null, "MENSAJE 2", "TIPO MESSAGE", 2);
			}
		});
		btnMensaje.setBounds(10, 35, 174, 47);
		frame.getContentPane().add(btnMensaje);
		
		JButton btnInput = new JButton("INPUT");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje=javax.swing.JOptionPane.showInputDialog("INTRODUCE MENSAJE"); 
				lblMensaje.setText(mensaje);
			}
		});
		btnInput.setBounds(10, 103, 174, 47);
		frame.getContentPane().add(btnInput);
		
		JButton btnConfi = new JButton("CONFIRMACIÓN");
		btnConfi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion=javax.swing.JOptionPane.showConfirmDialog(null, "¿ESTÁS SEGUR@?");
				System.out.println(opcion);
				if(opcion==0)lblMensaje_1.setText("SI");
				if(opcion==1)lblMensaje_1.setText("NO");
				if(opcion==2)lblMensaje_1.setText("CANCELAR");
			}
		});
		btnConfi.setBounds(10, 172, 174, 47);
		frame.getContentPane().add(btnConfi);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMensaje.setBounds(206, 103, 162, 47);
		frame.getContentPane().add(lblMensaje);
		
		JButton btnNewButton_3 = new JButton("BORRAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensaje.setText("");
				lblMensaje_1.setText("");
			}
		});
		btnNewButton_3.setBounds(145, 246, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		lblMensaje_1 = new JLabel("");
		lblMensaje_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMensaje_1.setBounds(206, 172, 162, 47);
		frame.getContentPane().add(lblMensaje_1);
	}

	protected static String showInputDialog(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
