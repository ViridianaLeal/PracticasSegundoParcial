package Practica17;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Practica17 {

	private JFrame frame;
	private JTable tblRegistroAlumno;
	private JTextField txtNombre;
	private JComboBox cboCarrera;
	private JComboBox cboGrupo;
	private JComboBox cboSemestre;
	private JButton btnBorrar;
	private JSpinner spnPromedio;
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	private JButton btnAgregar;
	JScrollPane scroll = new javax.swing.JScrollPane();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica17 window = new Practica17();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Practica17() {
		initialize();
		modelo.addColumn("Nombre");
		modelo.addColumn("Carrera");
		modelo.addColumn("Grupo");
		modelo.addColumn("Semestre");
		modelo.addColumn("Promedio");
		tblRegistroAlumno.setModel(modelo);
		scroll.setFont(new Font("Agency FB", Font.PLAIN, 26));
		scroll.setViewportView(tblRegistroAlumno);
		refrescartabla();

	}

	public void refrescartabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		for (Alumno alumno : listaAlumnos) {
			Object a[] = new Object[5];
			a[0] = alumno.getNombre();
			a[1] = alumno.getCarrera();
			a[2] = alumno.getGrupo();
			a[3] = alumno.getSemestre();
			a[4] = alumno.getPromedio();
			modelo.addRow(a);
		}
		tblRegistroAlumno.setModel(modelo);
   
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Agency FB", Font.PLAIN, 14));
		frame.setBounds(100, 100, 632, 382);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/gato.jpg")));
		frame.setTitle("REGISTRO DE ALUMNOS");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tblRegistroAlumno = new JTable();
		scroll.setBounds(22, 147, 563, 185);
		frame.getContentPane().add(scroll);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Carrera");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Semestre");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 86, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Grupo");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Promedio");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(22, 111, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		txtNombre = new JTextField();
		txtNombre.setBounds(78, 10, 223, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		cboCarrera = new JComboBox();
		cboCarrera.setModel(
				new DefaultComboBoxModel(new String[] { "Programación ", "Ventas", "Maquinas y Herramientas" }));
		cboCarrera.setBounds(78, 32, 223, 18);
		frame.getContentPane().add(cboCarrera);

		cboGrupo = new JComboBox();
		cboGrupo.setModel(new DefaultComboBoxModel(new String[] { "101", "102", "103", "104", "105", "106", "301",
				"302", "303", "304", "305", "306", "501", "502", "503", "504", "505", "506", "" }));
		cboGrupo.setBounds(78, 57, 223, 18);
		frame.getContentPane().add(cboGrupo);

		cboSemestre = new JComboBox();
		cboSemestre.setModel(new DefaultComboBoxModel(new String[] { "Primero", "Tercero", "Quinto" }));
		cboSemestre.setBounds(78, 82, 223, 22);
		frame.getContentPane().add(cboSemestre);

		spnPromedio = new JSpinner();
		spnPromedio.setModel(new SpinnerNumberModel(10.0, 5.0, 10.0, 0.1));
		spnPromedio.setBounds(78, 108, 223, 28);
		frame.getContentPane().add(spnPromedio);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				cboCarrera.setSelectedIndex(0);
				cboGrupo.setSelectedIndex(0);
				cboSemestre.setSelectedIndex(0);
				spnPromedio.setValue(10);
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(469, 59, 85, 41);
		frame.getContentPane().add(btnBorrar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Alumno alumno = new Alumno();
					alumno.setNombre(txtNombre.getText());
					alumno.setCarrera(cboCarrera.getSelectedItem().toString());
					alumno.setGrupo(Integer.parseInt(cboGrupo.getSelectedItem().toString()));
					alumno.setSemestre(cboSemestre.getSelectedItem().toString());
					alumno.setPromedio(Double.parseDouble(spnPromedio.getValue().toString()));
					listaAlumnos.add(alumno);
					refrescartabla();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(lblNewLabel_4, "ERROR AL AGREGAR ALUMNO");
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(355, 55, 89, 45);
		frame.getContentPane().add(btnAgregar);

	}
}
