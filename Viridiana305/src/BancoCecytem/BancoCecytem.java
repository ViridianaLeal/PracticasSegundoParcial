package BancoCecytem;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import PracticasSegundoParcial305.Fecha;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class BancoCecytem {

	private JFrame frame;
	private JLabel lblLogo;
	private JTable tblMovimientos;
	private JTextField txtNombreCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtDireccionCliente;
	private JButton btnAgregarCliente;
	private JTextField txtMontoIncial;
	private JTextField txtMontomovimiento;
	private JComboBox cboCuentaCliente;
	private JButton btnAgregarCuenta;
	private JComboBox cboTipocuenta;
	private JButton btnAgregarTipoCuenta;
	private JLabel lblNombreCliente;
	private JLabel lblTelefonoCliente;
	private JLabel lblDireccionCliente;
	private JLabel lblTipoCuentaCliente;
	private JLabel lblMontoCliente;
	JScrollPane scroll = new javax.swing.JScrollPane();
	DefaultTableModel modelMovs = new DefaultTableModel();
	private JLabel lblSaldo;
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private JComboBox cboConsultaCliente;
	private JComboBox cboConsultaTipoCuenta;
	private JComboBox cbotipomovimiento;
	private JButton btnAgregarMovimiento;
	ArrayList<String> listaTipoCuenta = new ArrayList<String>();
	Cliente cliente;
	Cuenta cuenta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoCecytem window = new BancoCecytem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BancoCecytem() {
		initialize();
		modelMovs.addColumn("CUENTA");
		modelMovs.addColumn("FECHA");
		modelMovs.addColumn("TIPO");
		modelMovs.addColumn("MONTO");
		tblMovimientos.setModel(modelMovs);
		scroll.setFont(new Font("Agency FB", Font.PLAIN, 26));
		scroll.setViewportView(tblMovimientos);

	}

	public void llenarCombosTipoCuenta() {
		Object tipos[] = new Object[listaTipoCuenta.size()];
		int i = 0;
		for (String tipo : listaTipoCuenta) {
			tipos[i] = tipo;
			i++;
		}
		cboTipocuenta.setModel(new DefaultComboBoxModel(tipos));

	}

	public void llenarCombosCliente() {
		Object clientes[] = new Object[listaClientes.size()];
		int i = 0;
		for (Cliente c : listaClientes) {
			clientes[i] = c.getNombre();
			i++;
		}
		cboCuentaCliente.setModel(new DefaultComboBoxModel(clientes));
		cboConsultaCliente.setModel(new DefaultComboBoxModel(clientes));
	}

	public String aMoneda(double cantidad) {
		cantidad = Math.round(cantidad * 100.0) / 100.0;
		DecimalFormat formato = new DecimalFormat("$ #,###.### MXN");
		return formato.format(cantidad);

	}

	public void verDatos() {
		cliente = listaClientes.get(cboConsultaCliente.getSelectedIndex());
		lblNombreCliente.setText(cliente.getNombre());
		lblTelefonoCliente.setText(cliente.getTelefono());
		lblDireccionCliente.setText(cliente.getDireccion());

		if (cliente.getMiscuentas().size() > 0) {
			cuenta = cliente.getMiscuentas().get(cboConsultaTipoCuenta.getSelectedIndex());
			lblTipoCuentaCliente.setText(cuenta.getTipocuenta());
			lblMontoCliente.setText(aMoneda(cuenta.getMontoinicial()));
		} else {
			lblTipoCuentaCliente.setText("NO HAY CUENTA");
			lblMontoCliente.setText("NO HAY CUENTA");
		}
	}

	public void verMovimientos() {
		cliente = listaClientes.get(cboConsultaCliente.getSelectedIndex());
		cuenta = cliente.getMiscuentas().get(cboConsultaTipoCuenta.getSelectedIndex());
		double saldo = 0;
		while (modelMovs.getRowCount() > 0) {
			modelMovs.removeRow(0);
		}
		for (Movimiento m : cuenta.getMismovimientos()) {
			Object mov[] = new Object[4];
			mov[0] = cuenta.getTipocuenta();
			mov[1] = m.getFechamovimiento();
			mov[2] = m.getTipomovimiento();
			mov[3] = aMoneda(m.getMonto());
			saldo += m.getMonto();
			modelMovs.addRow(mov);
		}
		tblMovimientos.setModel(modelMovs);
		lblSaldo.setText(aMoneda(saldo));
	}

	public void refrescarComboCuentas() {
		cliente = listaClientes.get(cboConsultaCliente.getSelectedIndex());
		int i = 0;
		ArrayList<String> cuentas = new ArrayList<String>();
		for (Cuenta c : cliente.getMiscuentas()) {
			cuentas.add(c.getTipocuenta());

		}
		cboConsultaTipoCuenta.setModel(new DefaultComboBoxModel(cuentas.toArray()));
	}

	public void borrarFormCuenta() {
		cboCuentaCliente.setSelectedIndex(0);
		cboTipocuenta.setSelectedIndex(0);
		txtMontoIncial.setText("");
	}

	public void borrarFormCliente() {
		txtNombreCliente.setText("");
		txtTelefonoCliente.setText("");
		txtDireccionCliente.setText("");
	}

	public void imagen() {
		Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Cecytem.jpg"));
		int ancho = lblLogo.getWidth();
		int alto = lblLogo.getWidth();
		lblLogo.setIcon(new ImageIcon(logo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.setBounds(100, 100, 801, 661);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("BANCO CECYTEM");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblLogo = new JLabel("New label");
		lblLogo.setBounds(22, 63, 171, 167);
		frame.getContentPane().add(lblLogo);
		imagen();

		JLabel lblNewLabel = new JLabel("BANCO ");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(317, 11, 190, 48);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nuevo cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(203, 63, 272, 235);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(71, 30, 174, 20);
		panel.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 32, 54, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Teléfono");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 63, 54, 14);
		panel.add(lblNewLabel_1_1);

		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.setColumns(10);
		txtTelefonoCliente.setBounds(71, 61, 174, 20);
		panel.add(txtTelefonoCliente);

		JLabel lblNewLabel_1_2 = new JLabel("Dirección");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 104, 69, 14);
		panel.add(lblNewLabel_1_2);

		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setColumns(10);
		txtDireccionCliente.setBounds(71, 102, 174, 20);
		panel.add(txtDireccionCliente);

		btnAgregarCliente = new JButton("Agregar cliente");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				c.setNombre(txtNombreCliente.getText());
				c.setTelefono(txtTelefonoCliente.getText());
				c.setDireccion(txtDireccionCliente.getText());
				listaClientes.add(c);
				llenarCombosCliente();
				borrarFormCliente();
			}
		});
		btnAgregarCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarCliente.setBounds(61, 156, 139, 23);
		panel.add(btnAgregarCliente);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nueva cuenta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(485, 63, 290, 235);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("Cliente");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 33, 54, 14);
		panel_1.add(lblNewLabel_1_3);

		cboCuentaCliente = new JComboBox();
		cboCuentaCliente.setBounds(83, 30, 134, 22);
		panel_1.add(cboCuentaCliente);

		JLabel lblNewLabel_1_4 = new JLabel("Tipo cuenta");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 68, 90, 14);
		panel_1.add(lblNewLabel_1_4);

		cboTipocuenta = new JComboBox();
		cboTipocuenta.setBounds(83, 65, 134, 22);
		panel_1.add(cboTipocuenta);

		btnAgregarTipoCuenta = new JButton("+");
		btnAgregarTipoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoCuenta = JOptionPane.showInputDialog(frame, "TIPO CUENTA");
				listaTipoCuenta.add(tipoCuenta);
				llenarCombosTipoCuenta();
			}
		});
		btnAgregarTipoCuenta.setBounds(227, 65, 41, 22);
		panel_1.add(btnAgregarTipoCuenta);

		JLabel lblNewLabel_1_2_1 = new JLabel("Monto");
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(22, 117, 54, 14);
		panel_1.add(lblNewLabel_1_2_1);

		txtMontoIncial = new JTextField();
		txtMontoIncial.setColumns(10);
		txtMontoIncial.setBounds(83, 115, 174, 20);
		panel_1.add(txtMontoIncial);

		btnAgregarCuenta = new JButton("Agregar cuenta");
		btnAgregarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = listaClientes.get(cboCuentaCliente.getSelectedIndex());
				Cuenta cuenta = new Cuenta();
				cuenta.setTipocuenta(listaTipoCuenta.get(cboTipocuenta.getSelectedIndex()));
				cuenta.setMontoinicial(Double.parseDouble(txtMontoIncial.getText()));
				cliente.addCuenta(cuenta);

				Movimiento m = new Movimiento();
				m.setFechamovimiento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				m.setTipomovimiento("APERTURA");
				m.setMonto(Double.parseDouble(txtMontoIncial.getText()));
				cuenta.addMovimiento(m);
				borrarFormCuenta();
				refrescarComboCuentas();
				verMovimientos();
				verDatos();
			}
		});

		btnAgregarCuenta.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarCuenta.setBounds(78, 163, 139, 23);
		panel_1.add(btnAgregarCuenta);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Movimientos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(42, 309, 717, 86);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		cboConsultaCliente = new JComboBox();
		cboConsultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarComboCuentas();
				verMovimientos();
				verDatos();
			}
		});
		cboConsultaCliente.setBounds(10, 46, 113, 32);
		panel_2.add(cboConsultaCliente);

		JLabel lblNewLabel_1_3_1 = new JLabel("Cliente");
		lblNewLabel_1_3_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_3_1.setBounds(10, 26, 54, 14);
		panel_2.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Tipo cuenta");
		lblNewLabel_1_3_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_3_1_1.setBounds(135, 26, 72, 14);
		panel_2.add(lblNewLabel_1_3_1_1);

		cboConsultaTipoCuenta = new JComboBox();
		cboConsultaTipoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verDatos();
				verMovimientos();
			}
		});
		cboConsultaTipoCuenta.setBounds(135, 46, 113, 32);
		panel_2.add(cboConsultaTipoCuenta);

		JLabel lblNewLabel_1_3_1_2 = new JLabel("Tipo movimiento");
		lblNewLabel_1_3_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_3_1_2.setBounds(254, 26, 113, 14);
		panel_2.add(lblNewLabel_1_3_1_2);

		cbotipomovimiento = new JComboBox();
		cbotipomovimiento.setModel(new DefaultComboBoxModel(new String[] { "Deposito", "Retiro" }));
		cbotipomovimiento.setBounds(254, 46, 113, 32);
		panel_2.add(cbotipomovimiento);

		JLabel lblNewLabel_1_5 = new JLabel("Monto");
		lblNewLabel_1_5.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(380, 26, 54, 14);
		panel_2.add(lblNewLabel_1_5);

		txtMontomovimiento = new JTextField();
		txtMontomovimiento.setColumns(10);
		txtMontomovimiento.setBounds(377, 46, 148, 32);
		panel_2.add(txtMontomovimiento);

		btnAgregarMovimiento = new JButton("Agregar movimiento");
		btnAgregarMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente = listaClientes.get(cboConsultaCliente.getSelectedIndex());
				cuenta = cliente.getMiscuentas().get(cboConsultaTipoCuenta.getSelectedIndex());
				Movimiento m = new Movimiento();
				m.setFechamovimiento(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				m.setTipomovimiento(cbotipomovimiento.getSelectedItem().toString());
				double monto = Double.parseDouble(txtMontomovimiento.getText().toString());
				monto = m.getTipomovimiento().equals("Deposito") ? monto : (monto * -1);
				m.setMonto(monto);
				cuenta.addMovimiento(m);
				verMovimientos();
			}
		});
		btnAgregarMovimiento.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarMovimiento.setBounds(534, 35, 153, 23);
		panel_2.add(btnAgregarMovimiento);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Datos de cuenta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 406, 267, 205);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		lblNombreCliente = new JLabel("");
		lblNombreCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreCliente.setBounds(98, 32, 136, 14);
		panel_3.add(lblNombreCliente);

		lblTelefonoCliente = new JLabel("");
		lblTelefonoCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelefonoCliente.setBounds(98, 59, 136, 14);
		panel_3.add(lblTelefonoCliente);

		lblDireccionCliente = new JLabel("");
		lblDireccionCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDireccionCliente.setBounds(98, 90, 136, 14);
		panel_3.add(lblDireccionCliente);

		lblTipoCuentaCliente = new JLabel("");
		lblTipoCuentaCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipoCuentaCliente.setBounds(98, 116, 136, 14);
		panel_3.add(lblTipoCuentaCliente);

		lblMontoCliente = new JLabel("");
		lblMontoCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMontoCliente.setBounds(98, 141, 136, 14);
		panel_3.add(lblMontoCliente);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 32, 78, 14);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Teléfono");
		lblNewLabel_2_1.setBounds(10, 59, 78, 14);
		panel_3.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Dirección");
		lblNewLabel_2_2.setBounds(10, 90, 69, 14);
		panel_3.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Tipo cuenta");
		lblNewLabel_2_3.setBounds(10, 116, 78, 14);
		panel_3.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Monto inicial");
		lblNewLabel_2_4.setBounds(10, 141, 78, 14);
		panel_3.add(lblNewLabel_2_4);

		JLabel lblNewLabel_3 = new JLabel("Saldo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(437, 572, 200, 50);
		frame.getContentPane().add(lblNewLabel_3);

		lblSaldo = new JLabel("$100,000.00 MXN");
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSaldo.setBounds(524, 572, 200, 50);
		frame.getContentPane().add(lblSaldo);

		tblMovimientos = new JTable();
		scroll.setBounds(287, 413, 488, 158);
		frame.getContentPane().add(scroll);
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
