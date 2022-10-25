package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablasMultiplicar {

	public JFrame frame;
	private JTextArea txaResultado;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablasMultiplicar window = new TablasMultiplicar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TablasMultiplicar() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 326, 507);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("TABLAS DE MULTIPLICAR");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JSpinner spnNumero = new JSpinner();
		spnNumero.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int numero=Integer.parseInt(spnNumero.getValue().toString());
				String tabla="";
				for(int i=1;i<=10;i++) {
					tabla+=numero+"x"+i+"="+(numero*i)+"\n";					
				}
				txaResultado.setText(tabla);
			}
		});
		spnNumero.setBounds(100, 9, 99, 32);
		frame.getContentPane().add(spnNumero);
		
		txaResultado = new JTextArea();
		txaResultado.setEditable(false);
		txaResultado.setFont(new Font("Monospaced", Font.BOLD, 24));
		txaResultado.setBounds(41, 52, 211, 341);
		frame.getContentPane().add(txaResultado);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txaResultado.setText("");
				spnNumero.setValue(0);
			}
			
		});
		btnBorrar.setBounds(101, 404, 112, 32);
		frame.getContentPane().add(btnBorrar);
	}
}
