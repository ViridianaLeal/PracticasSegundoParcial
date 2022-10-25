package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderColores {

	private JFrame frame;
	private JSlider sldRojo;
	private JLabel lblValorR;
	private JSlider sldVerde;
	private JLabel lblValorV;
	private JLabel lblValorA;
	private JSlider sldAzul;
	private JLabel lblColor;
	private JLabel lblRgb;
	private JLabel lblHex;
	int vRojo,vVerde,vAzul=0;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SliderColores window = new SliderColores();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SliderColores() {
		initialize();
	}
 
	public void verColor() {
		Color color=new Color(vRojo,vVerde,vAzul);
		lblColor.setOpaque(true);
		lblColor.setBackground(color);
		String hex=Integer.toHexString(vRojo)+Integer.toHexString(vVerde)+Integer.toHexString(vAzul);
		lblHex.setText("HER = "+hex);
		lblRgb.setText("EGB("+vRojo+","+vVerde+","+vAzul+")");
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 397);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("SLIDER COLORES");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rojo");
		lblNewLabel.setBounds(10, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblValorR = new JLabel("0");
		lblValorR.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValorR.setBounds(220, 47, 46, 25);
		frame.getContentPane().add(lblValorR);
		
		JLabel lblVerde = new JLabel("Verde");
		lblVerde.setBounds(10, 83, 46, 14);
		frame.getContentPane().add(lblVerde);
		
		
		
		lblValorV = new JLabel("");
		lblValorV.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValorV.setBounds(220, 109, 46, 25);
		frame.getContentPane().add(lblValorV);
		
		JLabel lblAzul = new JLabel("Azul");
		lblAzul.setBounds(10, 145, 46, 14);
		frame.getContentPane().add(lblAzul);
		
		
		
		lblValorA = new JLabel("");
		lblValorA.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValorA.setBounds(220, 171, 46, 25);
		frame.getContentPane().add(lblValorA);
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblColor.setBounds(277, 21, 217, 287);
		frame.getContentPane().add(lblColor);
		
		lblRgb = new JLabel("RGB (50, 50, 50)");
		lblRgb.setBounds(10, 218, 181, 35);
		frame.getContentPane().add(lblRgb);
		
		lblHex = new JLabel("HEX #323232");
		lblHex.setBounds(10, 264, 181, 41);
		frame.getContentPane().add(lblHex);
		

		sldRojo = new JSlider();
		sldRojo.setValue(0);
		sldRojo.setMaximum(255);
		sldRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {			
				vRojo=sldRojo.getValue();
				lblValorR.setText(""+vRojo);
				verColor();
			}
		});
		sldRojo.setBounds(10, 46, 200, 26);
		frame.getContentPane().add(sldRojo);
		
		sldVerde = new JSlider();
		sldVerde.setValue(0);
		sldVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vVerde=sldVerde.getValue();
				lblValorV.setText(""+vVerde);
				verColor();
			}
		});
		sldVerde.setMaximum(255);
		sldVerde.setBounds(10, 108, 200, 26);
		frame.getContentPane().add(sldVerde);
		
		sldAzul = new JSlider();
		sldAzul.setValue(0);
		sldAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vAzul=sldAzul.getValue();
				lblValorA.setText(""+vAzul);
				verColor();
			}
		});
		sldAzul.setMaximum(255);
		sldAzul.setBounds(10, 170, 200, 26);
		frame.getContentPane().add(sldAzul);
	}

}
