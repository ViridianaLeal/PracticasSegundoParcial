package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Chicharronera {

	public JFrame frame;
	private JSlider sldValorA;
	private JSlider sldValorB;
	private JSlider sldValorC;
	private JLabel lblValorC;
	private JLabel lblValorB;
	private JLabel lblValorA;
	int a=0,b=0,c=0;
	double x1=0,x2=0;
	private JLabel lblEcuacion;
	private JLabel lblResultado;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chicharronera window = new Chicharronera();
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
	public Chicharronera() {
		initialize();
	}
    public double redondear(double numero) {
    	return Math.round(numero*100.0)/100.0;
    }
	public void calcular() {
		try {
		lblEcuacion.setText(a+" xˆ2 "+b+" x "+c+" = 0 ");
		int valor=(b*b)-(4*a*c);
		if(valor>0){
			x1=(-b+Math.sqrt(valor))/(2*a);
			x2=(-b-Math.sqrt(valor))/(2*a);
			lblResultado.setText("X1="+redondear(x1)+" X2="+redondear(x2));
		}else if(valor==0) {
			x1=(-b)/(2*a);
			lblResultado.setText("X1="+redondear(x1));			
		}else if(valor<0) {
			lblResultado.setText("NO HAY SOLUCIÓN");
		}
		}catch(Exception ex) {
			
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 415);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("CHICHARRONERA");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		lblValorA = new JLabel("0");
		lblValorA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorA.setBounds(245, 39, 102, 26);
		frame.getContentPane().add(lblValorA);
		
		lblValorB = new JLabel("0");
		lblValorB.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorB.setBounds(245, 113, 102, 26);
		frame.getContentPane().add(lblValorB);
		
		lblValorC = new JLabel("0");
		lblValorC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorC.setBounds(245, 193, 102, 26);
		frame.getContentPane().add(lblValorC);
		
		lblEcuacion = new JLabel("");
		lblEcuacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEcuacion.setBounds(108, 242, 265, 33);
		frame.getContentPane().add(lblEcuacion);
		
		lblResultado = new JLabel("");
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResultado.setBounds(65, 286, 343, 66);
		frame.getContentPane().add(lblResultado);
		
		sldValorA = new JSlider();
		sldValorA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				a=sldValorA.getValue();
				lblValorA.setText(""+a);
				calcular();
			}
		});
				
		sldValorA.setValue(0);
		sldValorA.setMaximum(50);
		sldValorA.setMinimum(-50);
		sldValorA.setBounds(22, 39, 200, 26);
		frame.getContentPane().add(sldValorA);
			
		sldValorB = new JSlider();
		sldValorB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				b=sldValorB.getValue();
				lblValorB.setText(""+b);	
				calcular();
	    	}
		});
		
		sldValorB.setValue(0);
		sldValorB.setMinimum(-50);
		sldValorB.setMaximum(50);
		sldValorB.setBounds(22, 113, 200, 26);
		frame.getContentPane().add(sldValorB);
		
		sldValorC = new JSlider();
		sldValorC.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				c=sldValorC.getValue();
				lblValorC.setText(""+c);
				calcular();
			}
		});
		
		sldValorC.setValue(0);
		sldValorC.setMinimum(-50);
		sldValorC.setMaximum(50);
		sldValorC.setBounds(22, 193, 200, 26);
		frame.getContentPane().add(sldValorC);
		
		JLabel lblNewLabel = new JLabel("Valor de A");
		lblNewLabel.setBounds(22, 11, 59, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblValorDeB = new JLabel("Valor de B");
		lblValorDeB.setBounds(22, 85, 59, 26);
		frame.getContentPane().add(lblValorDeB);
		
		JLabel lblValorDeC = new JLabel("Valor de C");
		lblValorDeC.setBounds(22, 165, 59, 26);
		frame.getContentPane().add(lblValorDeC);
		
		
		
		
		
	}
}
