package Examen3;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;

public class Tienditadeloxxo {

	private JFrame frame;
	private JLabel lbllogo;
	private JTable tblProductos;
	private JButton btnAgregar;
	private JLabel lblPrecio;
	private JLabel lblImporte;
	private JComboBox cboProducto;
	private JSpinner spnCantidad;
	String productos[] = { "Sabritas", "Coca-cola", "Magnum", "Sopa", "Café", "Galletas", "Chiclé", "Peñafiel",
			"Cigarro", "Tequila" };
	double precios[] = { 15.50, 18, 25, 15, 18, 19, 5.50, 18, 2.50, 50 };
	double precio = 0;
	int cantidad = 0;
	JScrollPane scroll = new javax.swing.JScrollPane();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Venta> listaVentas = new ArrayList<Venta>();
	private JLabel lblSubtotal;
	private JLabel lblIva;
	private JLabel lblTotal;

	public void calcularprecio() {
		precio = precios[cboProducto.getSelectedIndex()];
		cantidad = Integer.parseInt(spnCantidad.getValue().toString());
		lblPrecio.setText(aMoneda(precio));
		lblImporte.setText(aMoneda(precio * cantidad));
	}

	public String aMoneda(double precio) {
		return "$" + Math.round(precio * 100.0) / 100.0 + " MXN";

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienditadeloxxo window = new Tienditadeloxxo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tienditadeloxxo() {
		initialize();
		DefaultComboBoxModel combomodel = new DefaultComboBoxModel<>(productos);
		cboProducto.setModel(combomodel);
		modelo.addColumn("Descripción");
		modelo.addColumn("Precio U.");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Importe");
		scroll.setFont(new Font("Agency FB", Font.PLAIN, 26));
		scroll.setViewportView(tblProductos);
		actualizartabla();
		calcularprecio();

	}

	public void imagenlogos() {
		Image oxxologo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenesexamenes/oxxo.png"));
		int ancho = lbllogo.getWidth();
		int alto = lbllogo.getWidth();
		lbllogo.setIcon(new ImageIcon(oxxologo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
		Image agregarlogo = Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/imagenesexamenes/agregar.png"));
		int ancho2 = btnAgregar.getWidth();
		int alto2 = btnAgregar.getWidth();
		btnAgregar.setIcon(new ImageIcon(agregarlogo.getScaledInstance(ancho2, alto2, Image.SCALE_SMOOTH)));

	}

	public boolean buscarVenta(Venta nueva) {
		for (Venta v : listaVentas) {
			if (v.getId() == nueva.getId()) {
				int nuevaCantidad = v.getCantidad() + nueva.getCantidad();
				v.setCantidad(nuevaCantidad);
				v.setImporte(v.getPrecio() * nuevaCantidad);
				return true;
			}
		}
		return false;
	}

	public void borrar() {
		precio = 0;
		cantidad = 1;
		cboProducto.setSelectedIndex(0);
		spnCantidad.setValue(1);
		calcularprecio();
	}

	public void actualizartabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		double subtotal = 0;
		for (Venta v : listaVentas) {
			Object x[] = new Object[4];
			x[0] = v.getDescripcion();
			x[1] = aMoneda(v.getPrecio());
			x[2] = v.getCantidad();
			x[3] = aMoneda(v.getImporte());
			subtotal+=v.getImporte();
			modelo.addRow(x);
		}
		double iva = subtotal * 0.16;
		double total = subtotal + iva;
		lblSubtotal.setText(aMoneda(subtotal));
		lblIva.setText(aMoneda(iva));
		lblTotal.setText(aMoneda(total));
		tblProductos.setModel(modelo);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 697, 640);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenesexamenes/oxxo.png")));
		frame.setTitle("OXXO");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TIENDITA ");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 50));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 21, 325, 60);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Producto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 108, 116, 30);
		frame.getContentPane().add(lblNewLabel_1);

		cboProducto = new JComboBox();
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularprecio();
			}
		});
		cboProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
		cboProducto.setBounds(125, 108, 138, 30);
		frame.getContentPane().add(cboProducto);

		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 149, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		lbllogo = new JLabel("");
		lbllogo.setBounds(375, -2, 85, 101);
		frame.getContentPane().add(lbllogo);

		JLabel lblNewLabel_1_3 = new JLabel("Importe");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_3.setBounds(273, 149, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_3);

		spnCantidad = new JSpinner();
		spnCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcularprecio();
			}
		});
		spnCantidad.setModel(new SpinnerNumberModel(1, 0, 10, 1));
		spnCantidad.setFont(new Font("Tahoma", Font.BOLD, 20));
		spnCantidad.setBounds(125, 160, 138, 30);
		frame.getContentPane().add(spnCantidad);

		JLabel lblNewLabel_1_2_1 = new JLabel("Precio");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(273, 108, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("IVA");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_2_2.setBounds(336, 497, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Total");
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_2_2_1.setBounds(336, 538, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_2_2_1);

		JLabel lblNewLabel_1_2_2_3 = new JLabel("Subtotal");
		lblNewLabel_1_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_3.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblNewLabel_1_2_2_3.setBounds(346, 456, 116, 30);
		frame.getContentPane().add(lblNewLabel_1_2_2_3);

		lblPrecio = new JLabel("$0.00 MXN");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(375, 110, 115, 30);
		frame.getContentPane().add(lblPrecio);

		lblImporte = new JLabel("$0.00 MXN");
		lblImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImporte.setHorizontalTextPosition(SwingConstants.LEADING);
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImporte.setBounds(375, 151, 115, 30);
		frame.getContentPane().add(lblImporte);

		lblSubtotal = new JLabel("$0.00 MXN");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtotal.setBounds(462, 458, 115, 30);
		frame.getContentPane().add(lblSubtotal);

		lblIva = new JLabel("$0.00 MXN");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIva.setBounds(462, 499, 115, 30);
		frame.getContentPane().add(lblIva);

		lblTotal = new JLabel("$0.00 MXN");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setBounds(439, 538, 138, 30);
		frame.getContentPane().add(lblTotal);

		tblProductos = new JTable();
		scroll.setBounds(22, 201, 623, 236);
		frame.getContentPane().add(scroll);

		btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venta venta = new Venta();
				venta.setId(cboProducto.getSelectedIndex());
				venta.setDescripcion(cboProducto.getSelectedItem().toString());
				venta.setPrecio(precio);
				venta.setCantidad(cantidad);
				venta.setImporte(precio * cantidad);
				if (!buscarVenta(venta)) {
					listaVentas.add(venta);

				}
				actualizartabla();
				borrar();
			}
		});
		btnAgregar.setBounds(545, 112, 78, 67);
		frame.getContentPane().add(btnAgregar);
		imagenlogos();

	}
}
