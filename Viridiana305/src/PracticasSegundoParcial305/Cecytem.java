package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cecytem {
	

	public JFrame frame;
    JCheckBox chkUniforme,chkCredencial,chkCubrebocas;
    JLabel lblQueTrae,lblCumple;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cecytem window = new Cecytem();
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
	public Cecytem() {
		initialize();
	}
	
	public void checarAlumno() {
		String quetrae="";
		if(chkUniforme.isSelected()) {
			quetrae+="SI UNIFORME";
		}else {
			quetrae+="NO UNIFORME";
		}
		if(chkCredencial.isSelected()) {
			quetrae+="SI CREDENCIAL";
		}else {
			quetrae+="NO CREDENCIAL";
		}
		if(chkCubrebocas.isSelected()) {
			quetrae+="SI CUBREBOCAS";
		}else {
			quetrae+="NO CUBREBOCAS";
		}
		lblQueTrae.setText(quetrae);
		if(chkUniforme.isSelected()&&chkCredencial.isSelected()&&chkCubrebocas.isSelected()) {
			lblCumple.setText("SI CUMPLE PUEDE PASAR");
		}else {
			lblCumple.setText("NO CUMPLE NO PUEDE PASAR!!!!");
		}
	}
	   
	
	private void initialize() {
		frame = new JFrame();
	    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setBounds(100, 100, 450, 322);
		frame.setTitle("EJEMPLO DE CHECKBOX");		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REQUISITOS PARA ENTRAR AL  CECYTEM");
		lblNewLabel.setBounds(109, 11, 292, 38);
		frame.getContentPane().add(lblNewLabel);
		
		chkUniforme = new JCheckBox("UNIFORME");
		chkUniforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarAlumno();
			}
		});
		chkUniforme.setBounds(19, 56, 97, 23);
		frame.getContentPane().add(chkUniforme);
		
		chkCredencial = new JCheckBox("CREDENCIAL");
		chkCredencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarAlumno();
			}
		});
		chkCredencial.setBounds(19, 100, 97, 23);
		frame.getContentPane().add(chkCredencial);
		
		chkCubrebocas = new JCheckBox("CUBREBOCAS");
		chkCubrebocas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checarAlumno();
			}
		});
		chkCubrebocas.setBounds(19, 141, 97, 23);
		frame.getContentPane().add(chkCubrebocas);
		
		lblQueTrae = new JLabel("");
		lblQueTrae.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblQueTrae.setBounds(19, 178, 405, 36);
		frame.getContentPane().add(lblQueTrae);
		
		lblCumple = new JLabel("");
		lblCumple.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCumple.setBounds(52, 225, 321, 38);
		frame.getContentPane().add(lblCumple);
	}

}
