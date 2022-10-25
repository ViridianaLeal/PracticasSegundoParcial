package PracticasSegundoParcial305;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class IdiomaF {

	private JFrame frame;
	private JTextArea txtTexto;
	private JTextArea txtTraduccion;
	private JButton btbBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdiomaF window = new IdiomaF();
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
	public IdiomaF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 406);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.png")));
		frame.setTitle("IDIOMA DE LA F");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTexto = new JTextArea();
		txtTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto=txtTexto.getText().toString();
				texto=texto.replace("a", "afa");
				texto=texto.replace("A", "AFA");
				texto=texto.replace("e", "efe");
				texto=texto.replace("i", "ifi");
				texto=texto.replace("o", "ofo");
				texto=texto.replace("u", "ufu");
				txtTraduccion.setText(texto);
				
				
			}
		});
		txtTexto.setBounds(20, 49, 174, 264);
		frame.getContentPane().add(txtTexto);
		
		txtTraduccion = new JTextArea();
		txtTraduccion.setEditable(false);
		txtTraduccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		txtTraduccion.setBounds(217, 49, 191, 264);
		frame.getContentPane().add(txtTraduccion);
		
		btbBorrar = new JButton("Borrar");
		btbBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTexto.setText("");
				txtTraduccion.setText("");
			}
		});
		btbBorrar.setBounds(156, 324, 89, 23);
		frame.getContentPane().add(btbBorrar);
		
		JLabel lblNewLabel = new JLabel("IDIOMA DE LA F");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(166, 11, 139, 27);
		frame.getContentPane().add(lblNewLabel);
	}
}
