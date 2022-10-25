package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.nio.file.attribute.DosFileAttributes;
import java.awt.event.ActionEvent;

public class Practica16 {

	private JFrame frame;
	private JToggleButton once;
	private JToggleButton diez;
	private JToggleButton nueve;
	private JToggleButton ocho;
	private JToggleButton siete;
	private JToggleButton seis;
	private JToggleButton cinco;
	private JToggleButton cuatro;
	private JToggleButton tres;
	private JToggleButton dos;
	private JToggleButton uno;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblDecimal;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica16 window = new Practica16();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Practica16() {
		initialize();
	}
  
	int binario[]=new int [11];
	
	public void calcularDecimal() {
		int decimal=0;
		for(int i=0;i< binario.length;i++) {
			decimal+=binario[i]*Math.pow(2, i);
		}
		lblDecimal.setText(""+decimal);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 382);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("BINARIO A DECIMAL  ");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1024");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 36, 46, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("256");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(122, 39, 46, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("128");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(178, 35, 46, 44);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("512");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(66, 28, 46, 58);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("64");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(244, 39, 29, 36);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("32");
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(290, 32, 46, 51);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("4");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(456, 43, 46, 29);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("16");
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(357, 35, 46, 44);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("8");
		lblNewLabel_8.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(386, 43, 60, 29);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("2");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_9.setBounds(512, 43, 26, 29);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("1");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblNewLabel_10.setBounds(562, 43, 26, 29);
		frame.getContentPane().add(lblNewLabel_10);
		
		once = new JToggleButton("0");
		once.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[10]=once.isSelected()?1:0;
				once.setText(""+binario[10]);
				calcularDecimal();
			}
		});
		once.setFont(new Font("Agency FB", Font.PLAIN, 30));
		once.setBounds(10, 90, 46, 44);
		frame.getContentPane().add(once);
		
		diez = new JToggleButton("0");
		diez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[9]=diez.isSelected()?1:0;
				diez.setText(""+binario[9]);
				calcularDecimal();
			}
		});
		diez.setFont(new Font("Agency FB", Font.PLAIN, 30));
		diez.setBounds(66, 90, 46, 44);
		frame.getContentPane().add(diez);
		
		nueve = new JToggleButton("0");
		nueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[8]=nueve.isSelected()?1:0;
				nueve.setText(""+binario[8]);
				calcularDecimal();
			}
		});
		nueve.setFont(new Font("Agency FB", Font.PLAIN, 30));
		nueve.setBounds(122, 90, 46, 44);
		frame.getContentPane().add(nueve);
		
		ocho = new JToggleButton("0");
		ocho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[7]=ocho.isSelected()?1:0;
				ocho.setText(""+binario[7]);
				calcularDecimal();
			}
		});
		ocho.setFont(new Font("Agency FB", Font.PLAIN, 30));
		ocho.setBounds(178, 90, 46, 44);
		frame.getContentPane().add(ocho);
		
		siete = new JToggleButton("0");
		siete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[6]=siete.isSelected()?1:0;
				siete.setText(""+binario[6]);
				calcularDecimal();
			}
		});
		siete.setFont(new Font("Agency FB", Font.PLAIN, 30));
		siete.setBounds(234, 90, 46, 44);
		frame.getContentPane().add(siete);
		
		seis = new JToggleButton("0");
		seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[5]=seis.isSelected()?1:0;
				seis.setText(""+binario[5]);
				calcularDecimal();
			}
		});
		seis.setFont(new Font("Agency FB", Font.PLAIN, 30));
		seis.setBounds(290, 90, 46, 44);
		frame.getContentPane().add(seis);
		
		cinco = new JToggleButton("0");
		cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[4]=cinco.isSelected()?1:0;
				cinco.setText(""+binario[4]);
				calcularDecimal();
			}
		});
		cinco.setFont(new Font("Agency FB", Font.PLAIN, 30));
		cinco.setBounds(346, 90, 46, 44);
		frame.getContentPane().add(cinco);
		
		cuatro = new JToggleButton("0");
		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[3]=cuatro.isSelected()?1:0;
				cuatro.setText(""+binario[3]);
				calcularDecimal();
			}
		});
		cuatro.setFont(new Font("Agency FB", Font.PLAIN, 30));
		cuatro.setBounds(400, 90, 46, 44);
		frame.getContentPane().add(cuatro);
		
		tres = new JToggleButton("0");
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[2]=tres.isSelected()?1:0;
				tres.setText(""+binario[0]);
				calcularDecimal();
			}
		});
		tres.setFont(new Font("Agency FB", Font.PLAIN, 30));
		tres.setBounds(454, 90, 46, 44);
		frame.getContentPane().add(tres);
		
		dos = new JToggleButton("0");
		dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[1]=dos.isSelected()?1:0;
				dos.setText(""+binario[1]);
				calcularDecimal();
			}
		});
		dos.setFont(new Font("Agency FB", Font.PLAIN, 30));
		dos.setBounds(510, 90, 46, 44);
		frame.getContentPane().add(dos);
		
		uno = new JToggleButton("0");
		uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binario[0]=uno.isSelected()?1:0;
				uno.setText(""+binario[0]);
				calcularDecimal();
			}
		});
		uno.setFont(new Font("Agency FB", Font.PLAIN, 30));
		uno.setBounds(560, 90, 46, 44);
		frame.getContentPane().add(uno);
		
		lblNewLabel_11 = new JLabel("BINARIO");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel_11.setBounds(199, 11, 176, 36);
		frame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("DECIMAL");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Agency FB", Font.BOLD, 35));
		lblNewLabel_12.setBounds(199, 145, 176, 36);
		frame.getContentPane().add(lblNewLabel_12);
		
		lblDecimal = new JLabel("0");
		lblDecimal.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblDecimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecimal.setBounds(145, 192, 301, 116);
		frame.getContentPane().add(lblDecimal);
	}
}
