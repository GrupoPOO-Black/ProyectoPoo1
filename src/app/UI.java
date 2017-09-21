package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import javax.swing.text.*;

import datos.Hora;
import datos.Horario;

import java.util.concurrent.TimeUnit;

public class UI {

	private JFrame frmAdministracinDeSalas;
	private JTextField EA_name;
	private JTextField EA_id;
	private JTextField EA_email;
	private JTextField EA_phone;
	private JTextField EC_id;
	private JTextField SA_place;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmAdministracinDeSalas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministracinDeSalas = new JFrame();
		frmAdministracinDeSalas.setType(Type.UTILITY);
		frmAdministracinDeSalas.setTitle("Administración de salas");
		frmAdministracinDeSalas.setResizable(false);
		frmAdministracinDeSalas.setBounds(100, 100, 506, 337);
		frmAdministracinDeSalas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdministracinDeSalas.setJMenuBar(menuBar);
		
		JMenu mnEstudiantes = new JMenu("Estudiante");
		menuBar.add(mnEstudiantes);
		
		JMenuItem mntmRegistrarEstudiante = new JMenuItem("Registrar");
		
		mnEstudiantes.add(mntmRegistrarEstudiante);
		
		JMenuItem mntmConsultarEstudiante = new JMenuItem("Consultar");
		
		mnEstudiantes.add(mntmConsultarEstudiante);
		
		JMenu mnSala = new JMenu("Sala");
		menuBar.add(mnSala);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		
		mnSala.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnSala.add(mntmModificar);
		
		JMenuItem mntmCalificar = new JMenuItem("Calificar");
		mnSala.add(mntmCalificar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		
		mnSala.add(mntmConsultar);
		
		JMenu mnHorario = new JMenu("Horario");
		menuBar.add(mnHorario);
		
		JMenuItem mntmAgregar_1 = new JMenuItem("Agregar");
		
		mnHorario.add(mntmAgregar_1);
		
		JMenu mnReservas = new JMenu("Reserva");
		menuBar.add(mnReservas);
		
		JMenuItem mntmNueva = new JMenuItem("Nueva");
		mnReservas.add(mntmNueva);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mnReservas.add(mntmConsultar_1);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);		
		
		JLabel lblHora = new JLabel("hora");
		menuBar.add(lblHora);
		
		String carrers[]={"Administración de Empresas","Enseñanza de la Matemática con Entornos Tecnológicos","Gestión en Turismo Sostenible","Ingeniería en Biotecnología","Ingeniería en Computación","Ingeniería en Diseño Industrial","Administración de Tecnología de Información","Ingeniería Agrícola","Ingeniería Ambiental","Ingeniería Agronegocios","Ingeniería en Computadores","Ingeniería en Construcción","Ingeniería en Electrónica","Ingeniería en Producción Industrial","Ingeniería en Seguridad Laboral e Higiene Ambiental","Ingeniería Física","Ingeniería Forestal","Ingeniería Mecatrónica","Ingeniería en Mantenimiento Industrial","Ingeniería en Materiales"};
		frmAdministracinDeSalas.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel Cards = new JPanel();
		frmAdministracinDeSalas.getContentPane().add(Cards);
		CardLayout clayout = new CardLayout(0, 0);
		Cards.setLayout(clayout);
		
		JPanel Main = new JPanel();
		Cards.add(Main, "Main");
		
		JPanel Estu_Agregar = new JPanel();
		Cards.add(Estu_Agregar, "Estu_Agregar");
		Estu_Agregar.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 12, 70, 15);
		Estu_Agregar.add(lblNombre);
		
		EA_name = new JTextField();
		EA_name.setBounds(100, 10, 240, 19);
		Estu_Agregar.add(EA_name);
		EA_name.setColumns(10);
		
		JLabel label = new JLabel("Carnet:");
		label.setBounds(12, 41, 70, 15);
		Estu_Agregar.add(label);
		
		EA_id = new JTextField();
		EA_id.setColumns(10);
		EA_id.setBounds(100, 39, 240, 19);
		Estu_Agregar.add(EA_id);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(12, 68, 70, 15);
		Estu_Agregar.add(lblCarrera);
		JComboBox EA_career = new JComboBox(carrers);
		EA_career.setModel(new DefaultComboBoxModel(new String[] {"Administración de Empresas", "Enseñanza de la Matemática con Entornos Tecnológicos", "Gestión en Turismo Sostenible", "Ingeniería en Biotecnología", "Ingeniería en Computación", "Ingeniería en Diseño Industrial", "Administración de Tecnología de Información", "Ingeniería Agrícola", "Ingeniería Ambiental", "Ingeniería Agronegocios", "Ingeniería en Computadores", "Ingeniería en Construcción", "Ingeniería en Electrónica", "Ingeniería en Producción Industrial", "Ingeniería en Seguridad Laboral e Higiene Ambiental", "Ingeniería Física", "Ingeniería Forestal", "Ingeniería Mecatrónica", "Ingeniería en Mantenimiento Industrial", "Ingeniería en Materiales"}));
		EA_career.setSelectedIndex(-1);
		EA_career.setToolTipText("");
		EA_career.setBounds(100, 63, 240, 24);
		Estu_Agregar.add(EA_career);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 97, 70, 15);
		Estu_Agregar.add(lblEmail);
		
		EA_email = new JTextField();
		EA_email.setColumns(10);
		EA_email.setBounds(100, 95, 240, 19);
		Estu_Agregar.add(EA_email);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(12, 126, 70, 15);
		Estu_Agregar.add(lblPhone);
		
		EA_phone = new JTextField();
		EA_phone.setColumns(10);
		EA_phone.setBounds(100, 124, 240, 19);
		Estu_Agregar.add(EA_phone);
		
		JLabel EA_result = new JLabel("");
		EA_result.setBounds(12, 228, 285, 15);
		Estu_Agregar.add(EA_result);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(EA_name.getText().equals("")) {
					EA_result.setText("Escriba un nombre.");
				} else {
					if(EA_id.getText().equals("")) {
						EA_result.setText("Escriba un carnet.");
					} else {
						if(EA_career.getSelectedIndex() == -1) {
							EA_result.setText("Seleccione una carrera.");
						} else {
							if(EA_email.getText().equals("")) {
								EA_result.setText("Escriba un correo.");
							} else {
								if(EA_phone.getText().equals("")) {
									EA_result.setText("Escriba un número telefónico.");
								} else {
									EA_result.setText(Estudiantes.addStudent(EA_name.getText(),EA_id.getText(),(String) EA_career.getItemAt(EA_career.getSelectedIndex()),EA_email.getText(),EA_phone.getText()));
								}
							}
						}
					}
				}
			}
		});
		btnAgregar.setBounds(377, 255, 117, 25);
		Estu_Agregar.add(btnAgregar);
		
		JPanel Estu_Consultar = new JPanel();
		Cards.add(Estu_Consultar, "Estu_Consultar");
		Estu_Consultar.setLayout(null);
		
		JLabel label_1 = new JLabel("Carnet:");
		label_1.setBounds(12, 14, 69, 15);
		Estu_Consultar.add(label_1);
		
		EC_id = new JTextField();
		EC_id.setColumns(10);
		EC_id.setBounds(100, 12, 136, 19);
		Estu_Consultar.add(EC_id);
		
		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setBounds(377, 9, 117, 25);
		Estu_Consultar.add(btnConsultar);
		
		JTextPane EC_result = new JTextPane();
		EC_result.setEditable(false);
		EC_result.setBounds(12, 41, 482, 239);
		Estu_Consultar.add(EC_result);
		
		JPanel Sala_Agregar = new JPanel();
		Cards.add(Sala_Agregar, "Sala_Agregar");
		Sala_Agregar.setLayout(null);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(12, 12, 77, 15);
		Sala_Agregar.add(lblCapacidad);
		
		JComboBox SA_capacity = new JComboBox();
		SA_capacity.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		SA_capacity.setBounds(107, 7, 197, 24);
		Sala_Agregar.add(SA_capacity);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 39, 60, 15);
		Sala_Agregar.add(lblEstado);
		
		JComboBox SA_status = new JComboBox();
		SA_status.setModel(new DefaultComboBoxModel(new String[] {"Inactiva", "En mantenimiento", "Activa"}));
		SA_status.setBounds(107, 34, 197, 24);
		Sala_Agregar.add(SA_status);
		
		JLabel lblUbicacin = new JLabel("Ubicación:");
		lblUbicacin.setBounds(12, 66, 77, 15);
		Sala_Agregar.add(lblUbicacin);
		
		SA_place = new JTextField();
		SA_place.setBounds(107, 64, 197, 19);
		Sala_Agregar.add(SA_place);
		SA_place.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(12, 93, 60, 15);
		Sala_Agregar.add(lblHorario);
		
		JComboBox SA_schedule = new JComboBox();
		
		SA_schedule.setBounds(107, 88, 197, 24);
		Sala_Agregar.add(SA_schedule);
		
		JTextPane SA_result = new JTextPane();
		SA_result.setBounds(12, 120, 292, 160);
		Sala_Agregar.add(SA_result);
		
		JButton btnAgregarSala = new JButton("Agregar Sala");
		
		btnAgregarSala.setBounds(316, 255, 178, 25);
		Sala_Agregar.add(btnAgregarSala);
		
		JPanel Sala_Consultar = new JPanel();
		Cards.add(Sala_Consultar, "Sala_Consultar");
		Sala_Consultar.setLayout(null);
		
		JLabel lblIdDeSala = new JLabel("ID de sala:");
		lblIdDeSala.setBounds(12, 17, 82, 15);
		Sala_Consultar.add(lblIdDeSala);
		
		JTextPane SC_result = new JTextPane();
		SC_result.setEditable(false);
		SC_result.setBounds(12, 44, 482, 236);
		Sala_Consultar.add(SC_result);
		
		JComboBox SC_id = new JComboBox(new String[] {""});
		
		SC_id.setBounds(112, 12, 91, 24);
		Sala_Consultar.add(SC_id);
		
		JPanel Hora_Agregar = new JPanel();
		Cards.add(Hora_Agregar, "Hora_Agregar");
		Hora_Agregar.setLayout(null);
		
		JLabel lblDa = new JLabel("Día: ");
		lblDa.setBounds(12, 17, 46, 15);
		Hora_Agregar.add(lblDa);
		
		JComboBox HA_day = new JComboBox();
		HA_day.setModel(new DefaultComboBoxModel(new String[] {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"}));
		HA_day.setBounds(76, 12, 95, 24);
		Hora_Agregar.add(HA_day);
		
		JLabel lblHora_1 = new JLabel("Hora: De:");
		lblHora_1.setBounds(12, 44, 60, 15);
		Hora_Agregar.add(lblHora_1);
		
		JComboBox HA_cbH1 = new JComboBox();
		HA_cbH1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		HA_cbH1.setBounds(76, 39, 44, 24);
		Hora_Agregar.add(HA_cbH1);
		
		JLabel label_2 = new JLabel(":");
		label_2.setBounds(123, 44, 16, 15);
		Hora_Agregar.add(label_2);
		
		JComboBox HA_cbM1 = new JComboBox();
		HA_cbM1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		HA_cbM1.setBounds(128, 39, 44, 24);
		Hora_Agregar.add(HA_cbM1);
		
		JLabel lblHasta = new JLabel("A:");
		lblHasta.setBounds(183, 44, 16, 15);
		Hora_Agregar.add(lblHasta);
		
		JComboBox HA_cbH2 = new JComboBox();
		HA_cbH2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		HA_cbH2.setBounds(199, 39, 44, 24);
		Hora_Agregar.add(HA_cbH2);
		
		JLabel label_3 = new JLabel(":");
		label_3.setBounds(246, 44, 16, 15);
		Hora_Agregar.add(label_3);
		
		JComboBox HA_cbM2 = new JComboBox();
		HA_cbM2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		HA_cbM2.setBounds(251, 39, 44, 24);
		Hora_Agregar.add(HA_cbM2);
		
		JButton btnQuitar = new JButton("Quitar");
		
		btnQuitar.setBounds(388, 12, 106, 25);
		Hora_Agregar.add(btnQuitar);
		
		JButton btnAadir = new JButton("Añadir");
		
		btnAadir.setBounds(388, 39, 106, 25);
		Hora_Agregar.add(btnAadir);
		
		JLabel lblVistaPrevia = new JLabel("Vista previa:");
		lblVistaPrevia.setBounds(12, 82, 101, 15);
		Hora_Agregar.add(lblVistaPrevia);
		
		JTextPane HA_result = new JTextPane();
		HA_result.setEditable(false);
		HA_result.setBounds(12, 109, 282, 171);
		Hora_Agregar.add(HA_result);
		
		JButton btnNuevo = new JButton("Nuevo..");
		
		btnNuevo.setBounds(388, 77, 106, 25);
		Hora_Agregar.add(btnNuevo);
		
		JButton btnCrear = new JButton("Crear");
		
		btnCrear.setBounds(388, 255, 106, 25);
		Hora_Agregar.add(btnCrear);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EC_result.setText(Estudiantes.consultStudent(EC_id.getText()) + Reservaciones.getStringFromStID(EC_id.getText()));
			}
		});
		
		
		mntmRegistrarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clayout.show(Cards, "Estu_Agregar");
			}
		});
		
		mntmConsultarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clayout.show(Cards, "Estu_Consultar");
			}
		});
		
		mntmConsultar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				SC_id.setModel(new DefaultComboBoxModel(Salas.getRoomList()));
				clayout.show(Cards, "Sala_Consultar");
			}
		});
		
		SC_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SC_result.setText(Salas.getRoomInfo((String) SC_id.getItemAt(SC_id.getSelectedIndex())).toString());
			}
		});
		
		mntmAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Horarios.tmpSchedule = new Horario();
				HA_result.setText(Horarios.tmpSchedule.toString());
				SA_result.setText(Horarios.getSchedule((String)SA_schedule.getItemAt(SA_schedule.getSelectedIndex())).toString());
				clayout.show(Cards, "Hora_Agregar");
				
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horarios.tmpSchedule = new Horario();
				HA_result.setText(Horarios.tmpSchedule.toString());
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horarios.addSchedule(Horarios.tmpSchedule);
				Horarios.tmpSchedule = new Horario();
				HA_result.setText(Horarios.tmpSchedule.toString());
			}
		});
		
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Horarios.tmpSchedule.closeDay(HA_day.getSelectedIndex());
				HA_result.setText(Horarios.tmpSchedule.toString());
			}
		});
		
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(HA_cbH1.getSelectedIndex() < HA_cbH2.getSelectedIndex()) {
					Horarios.tmpSchedule.setSchedule(HA_day.getSelectedIndex(), new Hora(HA_cbH1.getSelectedIndex(),HA_cbM1.getSelectedIndex(),HA_cbH2.getSelectedIndex(),HA_cbM2.getSelectedIndex()));
					HA_result.setText(Horarios.tmpSchedule.toString());
					return;
				}
				if(HA_cbH1.getSelectedIndex() == HA_cbH2.getSelectedIndex()) {
					if(HA_cbM1.getSelectedIndex() < HA_cbM2.getSelectedIndex()) {
						Horarios.tmpSchedule.setSchedule(HA_day.getSelectedIndex(), new Hora(HA_cbH1.getSelectedIndex(),HA_cbM1.getSelectedIndex(),HA_cbH2.getSelectedIndex(),HA_cbM2.getSelectedIndex()));
						HA_result.setText(Horarios.tmpSchedule.toString());
						return;
					}	
				}
				HA_result.setText("Hora inválida.");
				return;
			}
		});
		
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SA_schedule.setModel(new DefaultComboBoxModel(Horarios.getScheduleList()));
				clayout.show(Cards, "Sala_Agregar");
			}
		});
		
		btnAgregarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salas.addRoom(SA_capacity.getSelectedIndex() + 4, SA_status.getSelectedIndex(), Horarios.getSchedule((String)SA_schedule.getItemAt(SA_schedule.getSelectedIndex())), SA_place.getText());
				SA_result.setText("Sala agregada.");
			}
		});
		
		SA_schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SA_result.setText(Horarios.getSchedule((String)SA_schedule.getItemAt(SA_schedule.getSelectedIndex())).toString());
			}
		});
	}
}
