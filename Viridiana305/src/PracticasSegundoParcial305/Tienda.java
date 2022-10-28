package PracticasSegundoParcial305;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Tienda {

	private JFrame frame;
	private JComboBox cboProductos;
	private JRadioButton rdbSeismeses;
	private JRadioButton rdbDocemeses;
	private JRadioButton rdbDiOchoMeses;
	private JLabel lblPrecioU;
	private JLabel lblContadop;
	private JLabel lblCreditoPago;
	private JLabel lblAbono;
	private JLabel lblImagenProducto;
	ButtonGroup grupomeses = new ButtonGroup();
	String productoscompra = "Televisión";
	int cantidad = 0;
	double precio = 0;
	private JSpinner spCantidad;
	double preciou=0;
	double precioContado=0;
	double credito=0;
	double abono=0;
	double aumento=1.07;
	double plazo=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda window = new Tienda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tienda() {
		initialize();
		productospantalla();
		grupomeses.add(rdbSeismeses);
		grupomeses.add(rdbDocemeses);
		grupomeses.add(rdbDiOchoMeses);

	}

	public void productospantalla() {
		productoscompra = cboProductos.getSelectedItem().toString();
		cantidad = Integer.parseInt(spCantidad.getValue().toString());
		Image computadora = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/compu.jpg"));
		Image televison = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tele.jpg"));
		Image celular = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/celu.jpg"));
		Image tablet = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tablet.jpg"));
		Image impresora = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/impresora.jpg"));
		Image refrigerador = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/refri.jpg"));
		Image estufa = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/estufa.jpg"));
		Image licuadora = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/licuadora.jpg"));
		Image microondas = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/micro.png"));
		Image lavadora = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/lavadora.jpg"));
		int ancho = lblImagenProducto.getWidth();
		int alto = lblImagenProducto.getWidth();

		switch (productoscompra) {
		case "Televisión":
			lblImagenProducto.setIcon(new ImageIcon(televison.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			preciou=30000;
			precioContado=cantidad*(preciou);
			credito=aumento*(cantidad*(preciou));
			abono=credito/plazo;
			lblPrecioU.setText("$"+preciou+" MXN");
			lblContadop.setText("$"+precioContado+" MXN");
			lblCreditoPago.setText("$"+credito+" MXN");
			lblAbono.setText("$"+abono+" MNX");
			
			break;

		case "Computadora":
			lblImagenProducto.setIcon(new ImageIcon(computadora.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Celular":
			lblImagenProducto.setIcon(new ImageIcon(celular.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Impresora":
			lblImagenProducto.setIcon(new ImageIcon(impresora.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Refrigerador":
			lblImagenProducto.setIcon(new ImageIcon(refrigerador.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Estufa":
			lblImagenProducto.setIcon(new ImageIcon(estufa.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Lavadora":
			lblImagenProducto.setIcon(new ImageIcon(lavadora.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Licuadora":
			lblImagenProducto.setIcon(new ImageIcon(licuadora.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Tableta":
			lblImagenProducto.setIcon(new ImageIcon(tablet.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;

		case "Microondas":
			lblImagenProducto.setIcon(new ImageIcon(microondas.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
			break;
		}

	}
	
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 554);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("Tienda");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblNewLabel.setBounds(27, 64, 131, 28);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblCantidad.setBounds(27, 117, 131, 28);
		frame.getContentPane().add(lblCantidad);

		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblCredito.setBounds(27, 222, 131, 28);
		frame.getContentPane().add(lblCredito);

		cboProductos = new JComboBox();
		cboProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				productospantalla();
			}
		});
		cboProductos.setModel(new DefaultComboBoxModel(new String[] { "Televisión", "Computadora", "Celular",
				"Impresora", "Refrigerador", "Estufa", "Lavadora", "Licuadora", "Tableta", "Microondas" }));
		cboProductos.setBounds(111, 72, 125, 22);
		frame.getContentPane().add(cboProductos);

		spCantidad = new JSpinner();
		spCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {				
				productospantalla();
			}
		});
		spCantidad.setBounds(111, 126, 125, 20);
		frame.getContentPane().add(spCantidad);

		lblImagenProducto = new JLabel("");
		lblImagenProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenProducto.setBorder(null);
		lblImagenProducto.setBounds(299, 23, 261, 242);
		frame.getContentPane().add(lblImagenProducto);
		

		rdbSeismeses = new JRadioButton("6  meses");
		rdbSeismeses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aumento=rdbSeismeses.isSelected() ? 1.07:1.0;
				plazo=6;
				productospantalla();
				
			}
		});
		rdbSeismeses.setBounds(27, 274, 109, 23);
		frame.getContentPane().add(rdbSeismeses);

		JLabel lblPrecioUnitario = new JLabel("Precio unitario:");
		lblPrecioUnitario.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblPrecioUnitario.setBounds(255, 295, 131, 28);
		frame.getContentPane().add(lblPrecioUnitario);

		JLabel lblContado = new JLabel("Contado:");
		lblContado.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblContado.setBounds(255, 332, 131, 28);
		frame.getContentPane().add(lblContado);

		JLabel lblCredito_1 = new JLabel("Credito:");
		lblCredito_1.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblCredito_1.setBounds(255, 371, 131, 28);
		frame.getContentPane().add(lblCredito_1);

		JLabel lblAbonoMensual = new JLabel("Abono mensual:");
		lblAbonoMensual.setFont(new Font("Agency FB", Font.PLAIN, 23));
		lblAbonoMensual.setBounds(255, 410, 131, 28);
		frame.getContentPane().add(lblAbonoMensual);

		lblPrecioU = new JLabel("");
		lblPrecioU.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioU.setBounds(396, 295, 206, 26);
		frame.getContentPane().add(lblPrecioU);

		lblContadop = new JLabel("");
		lblContadop.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadop.setBounds(380, 332, 222, 26);
		frame.getContentPane().add(lblContadop);

		lblCreditoPago = new JLabel("");
		lblCreditoPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditoPago.setBounds(342, 371, 260, 26);
		frame.getContentPane().add(lblCreditoPago);

		lblAbono = new JLabel("");
		lblAbono.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbono.setBounds(380, 410, 222, 26);
		frame.getContentPane().add(lblAbono);

		rdbDocemeses = new JRadioButton("12  meses");
		rdbDocemeses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aumento=rdbDocemeses.isSelected() ? 1.1:1.0;
				plazo=12;
				productospantalla();
			}
		});
		rdbDocemeses.setBounds(27, 320, 109, 23);
		frame.getContentPane().add(rdbDocemeses);

		rdbDiOchoMeses = new JRadioButton("18  meses");
		rdbDiOchoMeses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aumento=rdbDiOchoMeses.isSelected() ? 1.25:1.0;
				plazo=18;
				productospantalla();
			}
		});
		rdbDiOchoMeses.setBounds(27, 371, 109, 23);
		frame.getContentPane().add(rdbDiOchoMeses);
	}
}
