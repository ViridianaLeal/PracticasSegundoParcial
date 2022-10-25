package Examenes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import Practica17.Alumno;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Examen {

	private JFrame frame;
	private JTable tbProductos;
	private JTextField txtDescripcion;
	private JComboBox cboProducto;
	private JComboBox cboPrecio;
	private JSpinner spnExistencia;
	private JTextField txtFecha;
	private JButton btnBorrar;
	ArrayList<Productos> listaProductos = new ArrayList<Productos>();
	private JButton btnAgregar;
	DefaultTableModel modelo = new DefaultTableModel();
	JScrollPane scroll = new javax.swing.JScrollPane();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen window = new Examen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Examen() {
		initialize();
		modelo.addColumn("Fecha");
		modelo.addColumn("Producto");
		modelo.addColumn("Existencia");
		modelo.addColumn("Precio");
		modelo.addColumn("Descripción del producto");
		tbProductos.setModel(modelo);
		scroll.setFont(new Font("Agency FB", Font.PLAIN, 26));
		scroll.setViewportView(tbProductos);
		refrescartabla();
	}

	public void refrescartabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		for (Productos productos : listaProductos) {
			Object a[] = new Object[5];
			a[0] = productos.getFecha();
			a[1] = productos.getProducto();
			a[2] = productos.getExistencia();
			a[3] = "$ " + productos.getPrecio();
			a[4] = productos.getDescripcion();
			modelo.addRow(a);
		}
		tbProductos.setModel(modelo);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Agency FB", Font.PLAIN, 14));
		frame.setBounds(100, 100, 632, 382);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("INVENTARIO ");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tbProductos = new JTable();
		scroll.setBounds(24, 169, 573, 163);
		frame.getContentPane().add(scroll);

		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setBounds(24, 40, 66, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(24, 90, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setBounds(24, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Existencia");
		lblNewLabel_3.setBounds(23, 65, 75, 14);
		frame.getContentPane().add(lblNewLabel_3);

		cboProducto = new JComboBox();
		cboProducto.setModel(new DefaultComboBoxModel(new String[] { "Lapiz", "Zacapuntas", "Goma", "Pluma roja",
				"Pluma negra", "Pluma azul ", "Paquete de plumas de colores", "Plumones", "Regla", "Compas",
				"Puntillas", "Transportador", "Lapicera" }));
		cboProducto.setBounds(108, 36, 100, 22);
		frame.getContentPane().add(cboProducto);

		cboPrecio = new JComboBox();
		cboPrecio.setModel(new DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "30", "35", "40", "45",
				"50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100" }));
		cboPrecio.setBounds(105, 86, 103, 22);
		frame.getContentPane().add(cboPrecio);

		spnExistencia = new JSpinner();
		spnExistencia.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnExistencia.setBounds(108, 62, 100, 20);
		frame.getContentPane().add(spnExistencia);

		txtFecha = new JTextField();
		txtFecha.setBounds(80, 8, 128, 20);
		frame.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Descripción del producto");
		lblNewLabel_4.setBounds(23, 125, 185, 14);
		frame.getContentPane().add(lblNewLabel_4);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(200, 115, 245, 35);
		frame.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Productos productos = new Productos();
					productos.setFecha(txtFecha.getText());
					productos.setProducto(cboProducto.getSelectedItem().toString());
					productos.setExistencia(Integer.parseInt(spnExistencia.getValue().toString()));
					productos.setPrecio(Integer.parseInt(cboPrecio.getSelectedItem().toString()));
					productos.setDescripcion(txtDescripcion.getText());
					listaProductos.add(productos);
					refrescartabla();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR PRODUCTOS");
				}
			}
		});
		btnAgregar.setBounds(407, 46, 89, 23);
		frame.getContentPane().add(btnAgregar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFecha.setText("");
				cboPrecio.setSelectedIndex(0);
				spnExistencia.setValue(0);
				cboProducto.setSelectedIndex(0);
				txtDescripcion.setText("");
			}
		});
		btnBorrar.setBounds(506, 46, 89, 23);
		frame.getContentPane().add(btnBorrar);
	}
}
