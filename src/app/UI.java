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
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import javax.swing.text.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import datos.*;
import mailing.Mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class UI {

	private JFrame frmAdministracinDeSalas;
	private JTextField EA_name;
	private JTextField EA_id;
	private JTextField EA_email;
	private JTextField EA_phone;
	private JTextField EC_id;
	private JTextField SA_place;
	
	private static Date date = new Date();
	private ArrayList<String> searchtmpResources = new ArrayList<String>();
	private ArrayList<String> tmpEmails = new ArrayList<String>();
	private String[] tmpArray = new String[0];
	
	private JTextField SM_place;
	private JTextField SM_resource;
	private JTextField RB_resource;
	private JTextField RA_email;
	private JTextField RA_idnumber;
	
	private static Properties config;
	private static int lastWeek;
	
	
	private JTextField OR_studentId;

	/**
	 * Launch the application.
	 */
	public static void init() {
		
		try {
			loadProp();
			lastWeek = Integer.parseInt(config.getProperty("lastWeek"));
		} catch(Exception e) {
			config = new Properties();
			lastWeek = new GregorianCalendar().get(GregorianCalendar.WEEK_OF_YEAR);
			config.setProperty("lastWeek",Integer.toString(lastWeek));
			saveProp();
		}	
		
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
	
	private static void loadProp() {
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");

			config.load(input);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void saveProp() {
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");

			config.store(output, "");

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Horarios.tmpSchedule = new Horario();
		
		frmAdministracinDeSalas = new JFrame();
		frmAdministracinDeSalas.setType(Type.UTILITY);
		frmAdministracinDeSalas.setTitle("Administración de salas");
		frmAdministracinDeSalas.setResizable(false);
		frmAdministracinDeSalas.setBounds(100, 100, 550, 210);
		frmAdministracinDeSalas.setLocationRelativeTo(null);
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
		
		JMenu mnEstadisticas = new JMenu("Otro");
		menuBar.add(mnEstadisticas);		
		
		JMenuItem mntmReportarIncidente = new JMenuItem("Reportar incidente");
		
		mnEstadisticas.add(mntmReportarIncidente);
		
		JMenu mnAnlisisDeDatos = new JMenu("Análisis de datos");
		mnEstadisticas.add(mnAnlisisDeDatos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salas más utilizadas");
		
		mnAnlisisDeDatos.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Carreras Top 5");
		mnAnlisisDeDatos.add(mntmNewMenuItem_1);
		
		JLabel label_4 = new JLabel("    ");
		menuBar.add(label_4);
		
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
		btnAgregar.setBounds(421, 126, 117, 25);
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
		
		btnConsultar.setBounds(571, 9, 117, 25);
		Estu_Consultar.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 41, 676, 452);
		Estu_Consultar.add(scrollPane);
		
		JTextPane EC_result = new JTextPane();
		scrollPane.setViewportView(EC_result);
		EC_result.setEditable(false);
		
		JPanel Sala_Agregar = new JPanel();
		Cards.add(Sala_Agregar, "Sala_Agregar");
		Sala_Agregar.setLayout(null);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(12, 17, 91, 15);
		Sala_Agregar.add(lblCapacidad);
		
		JComboBox SA_capacity = new JComboBox();
		SA_capacity.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		SA_capacity.setBounds(107, 12, 581, 24);
		Sala_Agregar.add(SA_capacity);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(12, 44, 91, 15);
		Sala_Agregar.add(lblEstado);
		
		JComboBox SA_status = new JComboBox();
		SA_status.setModel(new DefaultComboBoxModel(new String[] {"Inactiva", "En mantenimiento", "Activa"}));
		SA_status.setBounds(107, 39, 581, 24);
		Sala_Agregar.add(SA_status);
		
		JLabel lblUbicacin = new JLabel("Ubicación:");
		lblUbicacin.setBounds(12, 71, 91, 15);
		Sala_Agregar.add(lblUbicacin);
		
		SA_place = new JTextField();
		SA_place.setBounds(107, 69, 581, 19);
		Sala_Agregar.add(SA_place);
		SA_place.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(12, 98, 91, 15);
		Sala_Agregar.add(lblHorario);
		
		JComboBox SA_schedule = new JComboBox();
		
		SA_schedule.setBounds(107, 93, 581, 24);
		Sala_Agregar.add(SA_schedule);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 125, 676, 160);
		Sala_Agregar.add(scrollPane_1);
		
		JTextPane SA_result = new JTextPane();
		scrollPane_1.setViewportView(SA_result);
		
		JButton btnAgregarSala = new JButton("Agregar Sala");
		
		btnAgregarSala.setBounds(12, 297, 676, 25);
		Sala_Agregar.add(btnAgregarSala);
		
		JPanel Sala_Modificar = new JPanel();
		Cards.add(Sala_Modificar, "Sala_Modificar");
		Sala_Modificar.setLayout(null);
		
		JLabel label_5 = new JLabel("ID de sala:");
		label_5.setBounds(12, 17, 100, 15);
		Sala_Modificar.add(label_5);
		
		JComboBox SM_room = new JComboBox(new Object[]{});
		
		SM_room.setBounds(112, 12, 150, 24);
		Sala_Modificar.add(SM_room);
		
		JLabel lblCambiarUbicacin = new JLabel("Cambiar ubicación:");
		lblCambiarUbicacin.setBounds(280, 45, 186, 15);
		Sala_Modificar.add(lblCambiarUbicacin);
		
		SM_place = new JTextField();
		SM_place.setBounds(274, 64, 288, 19);
		Sala_Modificar.add(SM_place);
		SM_place.setColumns(10);
		
		JButton SM_changePlace = new JButton("Cambiar");
		
		SM_changePlace.setBounds(574, 61, 111, 25);
		Sala_Modificar.add(SM_changePlace);
		
		JLabel lblEstado_1 = new JLabel("Estado:");
		lblEstado_1.setBounds(280, 95, 282, 15);
		Sala_Modificar.add(lblEstado_1);
		
		JComboBox SM_status = new JComboBox();
		SM_status.setModel(new DefaultComboBoxModel(new String[] {"Inactiva", "En mantenimiento", "Activa"}));
		SM_status.setBounds(274, 122, 288, 24);
		Sala_Modificar.add(SM_status);
		
		JButton SM_changeStatus = new JButton("Cambiar");
		
		SM_changeStatus.setBounds(574, 122, 111, 25);
		Sala_Modificar.add(SM_changeStatus);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(280, 158, 282, 15);
		Sala_Modificar.add(lblRecursos);
		
		JButton SM_addResource = new JButton("Agregar");
		
		SM_addResource.setBounds(574, 217, 111, 25);
		Sala_Modificar.add(SM_addResource);
		
		JList SM_resources = new JList();
		SM_resources.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SM_resources.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		SM_resources.setBounds(274, 185, 288, 95);
		Sala_Modificar.add(SM_resources);
		
		SM_resource = new JTextField();
		SM_resource.setBounds(574, 186, 114, 19);
		Sala_Modificar.add(SM_resource);
		SM_resource.setColumns(10);
		
		JButton SM_quitar = new JButton("Quitar");
		
		SM_quitar.setBounds(574, 254, 111, 25);
		Sala_Modificar.add(SM_quitar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 44, 250, 236);
		Sala_Modificar.add(scrollPane_2);
		
		JTextArea SM_result = new JTextArea();
		scrollPane_2.setViewportView(SM_result);
		SM_result.setEditable(false);
		SM_result.setText(" ");
		
		JPanel Sala_Consultar = new JPanel();
		Cards.add(Sala_Consultar, "Sala_Consultar");
		Sala_Consultar.setLayout(null);
		
		JLabel lblIdDeSala = new JLabel("ID de sala:");
		lblIdDeSala.setBounds(12, 17, 82, 15);
		Sala_Consultar.add(lblIdDeSala);
		
		JComboBox SC_id = new JComboBox(new String[] {""});
		
		SC_id.setBounds(112, 12, 91, 24);
		Sala_Consultar.add(SC_id);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 44, 676, 449);
		Sala_Consultar.add(scrollPane_3);
		
		JTextPane SC_result = new JTextPane();
		scrollPane_3.setViewportView(SC_result);
		SC_result.setEditable(false);
		
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
		
		btnQuitar.setBounds(432, 15, 106, 25);
		Hora_Agregar.add(btnQuitar);
		
		JButton btnAadir = new JButton("Añadir");
		
		btnAadir.setBounds(432, 42, 106, 25);
		Hora_Agregar.add(btnAadir);
		
		JLabel lblVistaPrevia = new JLabel("Vista previa:");
		lblVistaPrevia.setBounds(12, 82, 101, 15);
		Hora_Agregar.add(lblVistaPrevia);
		
		JTextPane HA_result = new JTextPane();
		HA_result.setEditable(false);
		HA_result.setBounds(12, 109, 282, 171);
		Hora_Agregar.add(HA_result);
		
		JButton btnNuevo = new JButton("Nuevo..");
		
		btnNuevo.setBounds(432, 80, 106, 25);
		Hora_Agregar.add(btnNuevo);
		
		JButton btnCrear = new JButton("Crear");
		
		btnCrear.setBounds(432, 258, 106, 25);
		Hora_Agregar.add(btnCrear);
		
		JPanel Rese_Agregar = new JPanel();
		Cards.add(Rese_Agregar, "Rese_Agregar");
		Rese_Agregar.setLayout(null);
		
		JLabel lblDa_1 = new JLabel("Día:");
		lblDa_1.setBounds(12, 12, 42, 15);
		Rese_Agregar.add(lblDa_1);
		
		JLabel lblHora_2 = new JLabel("Tiempo en minutos:");
		lblHora_2.setBounds(12, 39, 139, 15);
		Rese_Agregar.add(lblHora_2);
		
		JSpinner RA_day = new JSpinner();
		RA_day.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
		RA_day.setBounds(80, 10, 156, 20);
		Rese_Agregar.add(RA_day);
		
		JSpinner RA_time = new JSpinner();
		RA_time.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		RA_time.setBounds(169, 37, 67, 20);
		Rese_Agregar.add(RA_time);
		
		JLabel lblIntegrantes = new JLabel("Correos de los participantes:");
		lblIntegrantes.setBounds(12, 114, 224, 15);
		Rese_Agregar.add(lblIntegrantes);
		
		JButton button_2 = new JButton("-");
		
		button_2.setBounds(183, 255, 53, 25);
		Rese_Agregar.add(button_2);
		
		RA_email = new JTextField();
		RA_email.setBounds(12, 131, 159, 19);
		Rese_Agregar.add(RA_email);
		RA_email.setColumns(10);
		
		JButton button_3 = new JButton("+");
		
		button_3.setBounds(183, 128, 53, 25);
		Rese_Agregar.add(button_3);
		
		JLabel lblCarnetDelEstudiante = new JLabel("Carnet:");
		lblCarnetDelEstudiante.setBounds(12, 66, 67, 15);
		Rese_Agregar.add(lblCarnetDelEstudiante);
		
		RA_idnumber = new JTextField();
		
		
		RA_idnumber.setBounds(80, 64, 156, 19);
		Rese_Agregar.add(RA_idnumber);
		RA_idnumber.setColumns(10);
		
		JLabel lblStudentInfo = new JLabel("");
		lblStudentInfo.setBounds(12, 87, 224, 15);
		Rese_Agregar.add(lblStudentInfo);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setBounds(254, 12, 87, 15);
		Rese_Agregar.add(lblDescripcin);
		
		JLabel lblReservando = new JLabel("Reservando:");
		lblReservando.setBounds(254, 114, 99, 15);
		Rese_Agregar.add(lblReservando);
		
		JTextPane RA_descrip = new JTextPane();
		RA_descrip.setBounds(248, 39, 246, 42);
		Rese_Agregar.add(RA_descrip);
		
		JLabel RA_roomId = new JLabel("");
		RA_roomId.setBounds(377, 114, 117, 15);
		Rese_Agregar.add(RA_roomId);
		
		JButton btnCambiar = new JButton("Cambiar");
		
		btnCambiar.setBounds(254, 157, 99, 25);
		Rese_Agregar.add(btnCambiar);
		
		JButton btnReservar = new JButton("Reservar");
		
		btnReservar.setBounds(377, 157, 117, 25);
		Rese_Agregar.add(btnReservar);
		
		JTextPane RA_result = new JTextPane();
		RA_result.setEditable(false);
		RA_result.setBackground(UIManager.getColor("Button.background"));
		RA_result.setBounds(254, 194, 240, 42);
		Rese_Agregar.add(RA_result);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 162, 159, 118);
		Rese_Agregar.add(scrollPane_4);
		
		JList RA_emails = new JList();
		scrollPane_4.setViewportView(RA_emails);
		RA_emails.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		RA_emails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel Rese_Buscar = new JPanel();
		Cards.add(Rese_Buscar, "Rese_Buscar");
		Rese_Buscar.setLayout(null);
		
		JLabel lblBuscarSala = new JLabel("Buscar sala");
		lblBuscarSala.setBounds(12, 12, 102, 15);
		Rese_Buscar.add(lblBuscarSala);
		
		JLabel lblCapacidadMnima = new JLabel("Capacidad mínima:");
		lblCapacidadMnima.setBounds(12, 28, 148, 15);
		Rese_Buscar.add(lblCapacidadMnima);
		
		JComboBox RB_capacity = new JComboBox();
		
		RB_capacity.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		RB_capacity.setBounds(22, 55, 55, 24);
		Rese_Buscar.add(RB_capacity);
		
		JLabel lblNewLabel = new JLabel("Recursos requeridos:");
		lblNewLabel.setBounds(12, 91, 170, 15);
		Rese_Buscar.add(lblNewLabel);
		
		RB_resource = new JTextField();
		RB_resource.setBounds(12, 118, 182, 19);
		Rese_Buscar.add(RB_resource);
		RB_resource.setColumns(10);
		
		JButton button = new JButton("+");
		
		button.setBounds(206, 115, 45, 25);
		Rese_Buscar.add(button);
		
		JButton button_1 = new JButton("-");
		
		button_1.setBounds(206, 255, 45, 25);
		Rese_Buscar.add(button_1);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(253, 12, 102, 15);
		Rese_Buscar.add(lblResultado);
		
		JButton btnContinuar = new JButton("Continuar");
		
		btnContinuar.setBounds(373, 255, 211, 25);
		Rese_Buscar.add(btnContinuar);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(373, 12, 211, 231);
		Rese_Buscar.add(scrollPane_5);
		
		JTextPane RB_result = new JTextPane();
		scrollPane_5.setViewportView(RB_result);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(263, 28, 98, 252);
		Rese_Buscar.add(scrollPane_6);
		
		JList RB_rooms = new JList();
		scrollPane_6.setViewportView(RB_rooms);
		
		RB_rooms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		RB_rooms.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(12, 149, 184, 131);
		Rese_Buscar.add(scrollPane_7);
		
		JList RB_resources = new JList();
		scrollPane_7.setViewportView(RB_resources);
		RB_resources.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel Rese_Consultar = new JPanel();
		Cards.add(Rese_Consultar, "Rese_Consultar");
		Rese_Consultar.setLayout(null);
		
		JLabel lblReserva = new JLabel("Reserva:");
		lblReserva.setBounds(12, 12, 70, 15);
		Rese_Consultar.add(lblReserva);
		
		JComboBox RC_reservation = new JComboBox();
		
		RC_reservation.setBounds(100, 7, 89, 24);
		Rese_Consultar.add(RC_reservation);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(12, 39, 576, 404);
		Rese_Consultar.add(scrollPane_8);
		
		JTextPane RC_result = new JTextPane();
		RC_result.setEditable(false);
		scrollPane_8.setViewportView(RC_result);
		
		JButton btnCancelar = new JButton("Cancelar reserva");
		
		btnCancelar.setBounds(365, 7, 173, 25);
		Rese_Consultar.add(btnCancelar);
		
		JPanel Otro_Report = new JPanel();
		Cards.add(Otro_Report, "Otro_Report");
		Otro_Report.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setBounds(12, 66, 101, 15);
		Otro_Report.add(lblNewLabel_1);
		
		JTextPane OR_descrip = new JTextPane();
		OR_descrip.setBounds(12, 93, 299, 107);
		Otro_Report.add(OR_descrip);
		
		JLabel lblPenalizacin = new JLabel("Penalización:");
		lblPenalizacin.setBounds(12, 218, 101, 15);
		Otro_Report.add(lblPenalizacin);
		
		JComboBox OR_penalization = new JComboBox();
		OR_penalization.setModel(new DefaultComboBoxModel(new String[] {"7", "10", "15"}));
		OR_penalization.setSelectedIndex(0);
		OR_penalization.setBounds(131, 213, 53, 24);
		Otro_Report.add(OR_penalization);
		
		JButton btnAceptar = new JButton("Aceptar");
		
		btnAceptar.setBounds(12, 255, 117, 25);
		Otro_Report.add(btnAceptar);
		
		JLabel lblEstudiante = new JLabel("Estudiante:");
		lblEstudiante.setBounds(12, 12, 101, 15);
		Otro_Report.add(lblEstudiante);
		
		OR_studentId = new JTextField();
		
		OR_studentId.setBounds(131, 10, 114, 19);
		Otro_Report.add(OR_studentId);
		OR_studentId.setColumns(10);
		
		JLabel OR_student = new JLabel("");
		OR_student.setBounds(12, 39, 299, 15);
		Otro_Report.add(OR_student);
		
		JLabel OR_result = new JLabel("");
		OR_result.setBounds(141, 260, 70, 15);
		Otro_Report.add(OR_result);
		
		JPanel Analisis_datos = new JPanel();
		Cards.add(Analisis_datos, "Analisis_datos");
		CardLayout dataLayout = new CardLayout(0, 0);
		Analisis_datos.setLayout(dataLayout);
		
		JScrollPane AD_topcareers = new JScrollPane();
		Analisis_datos.add(AD_topcareers, "AD_topcareers");
		
		
		JScrollPane AD_topsalas = new JScrollPane();
		Analisis_datos.add(AD_topsalas, "AD_topsalas");
		
		
		
		
		
		
		//ACTIONLISTENERS
		
		RB_rooms.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				RB_result.setText(Salas.getRoomInfo((String)RB_rooms.getSelectedValue()));
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EC_result.setText(Estudiantes.consultStudent(EC_id.getText()) + Reservaciones.getStringFromStID(EC_id.getText()));
			}
		});
		
		
		mntmRegistrarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministracinDeSalas.setBounds(100, 100, 550, 210);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				clayout.show(Cards, "Estu_Agregar");
			}
		});
		
		mntmConsultarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministracinDeSalas.setBounds(100, 100, 700, 550);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				clayout.show(Cards, "Estu_Consultar");
			}
		});
		
		mntmConsultar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				frmAdministracinDeSalas.setBounds(100, 100, 700, 550);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
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
				frmAdministracinDeSalas.setBounds(100, 100, 550, 340);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
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
				frmAdministracinDeSalas.setBounds(100, 100, 700, 380);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
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
		
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministracinDeSalas.setBounds(100, 100, 700, 340);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				SM_room.setModel(new DefaultComboBoxModel(Salas.getRoomList()));
				clayout.show(Cards, "Sala_Modificar");
			}
		});
		
		SM_room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SM_result.setText(Salas.getRoomInfo((String) SM_room.getItemAt(SM_room.getSelectedIndex())).toString());
			}
		});
		
		SM_changePlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Salas.changePlace((String) SM_room.getItemAt(SM_room.getSelectedIndex()), SM_place.getText());
				SM_result.setText(Salas.getRoomInfo((String) SM_room.getItemAt(SM_room.getSelectedIndex())).toString());
				
			}
		});
		
		SM_changeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salas.changeStatus((String) SM_room.getItemAt(SM_room.getSelectedIndex()), SM_status.getSelectedIndex());
				SM_result.setText(Salas.getRoomInfo((String) SM_room.getItemAt(SM_room.getSelectedIndex())).toString());
			}
		});
		
		SM_addResource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salas.addResource((String) SM_room.getItemAt(SM_room.getSelectedIndex()), SM_resource.getText());
				SM_result.setText(Salas.getRoomInfo((String) SM_room.getItemAt(SM_room.getSelectedIndex())).toString());
				SM_resources.setModel(new DefaultComboBoxModel(Salas.getResources((String) SM_room.getItemAt(SM_room.getSelectedIndex()))));
				SM_resource.setText("");
			}
		});
		
		mntmNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdministracinDeSalas.setBounds(100, 100, 596, 340);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				clayout.show(Cards, "Rese_Buscar");
			}
		});
		
		SM_quitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!SM_resources.isSelectionEmpty()) {
					Salas.removeResource((String) SM_room.getItemAt(SM_room.getSelectedIndex()),SM_resources.getSelectedIndex());
				}
				SM_result.setText(Salas.getRoomInfo((String) SM_room.getItemAt(SM_room.getSelectedIndex())).toString());
				SM_resources.setModel(new DefaultComboBoxModel(Salas.getResources((String) SM_room.getItemAt(SM_room.getSelectedIndex()))));
			
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchtmpResources.add(RB_resource.getText());
				tmpArray = new String[searchtmpResources.size()];
				tmpArray = searchtmpResources.toArray(tmpArray);
				RB_resource.setText("");
				RB_resources.setModel(new DefaultComboBoxModel(tmpArray));
				RB_rooms.setModel(new DefaultComboBoxModel(Salas.searchRoom(RB_capacity.getSelectedIndex() + 1, tmpArray)));
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!RB_resources.isSelectionEmpty()) {
					searchtmpResources.remove(RB_resources.getSelectedIndex());
					tmpArray = new String[searchtmpResources.size()];
					tmpArray = searchtmpResources.toArray(tmpArray);
					
					RB_resources.setModel(new DefaultComboBoxModel(tmpArray));
					RB_rooms.setModel(new DefaultComboBoxModel(Salas.searchRoom(RB_capacity.getSelectedIndex() + 1, tmpArray)));
				}
			}
		});
		
		RB_capacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RB_rooms.setModel(new DefaultComboBoxModel(Salas.searchRoom(RB_capacity.getSelectedIndex(), tmpArray)));
			}
		});
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!RB_rooms.isSelectionEmpty()) {
					frmAdministracinDeSalas.setBounds(100, 100, 516, 338);
					frmAdministracinDeSalas.setLocationRelativeTo(null);
					clayout.show(Cards,"Rese_Agregar");
					RA_roomId.setText((String)RB_rooms.getSelectedValue());
				}
				
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(RA_email.getText() != "") {
					tmpEmails.add(RA_email.getText());
					tmpArray = new String[tmpEmails.size()];
					tmpArray = tmpEmails.toArray(tmpArray);
					RA_emails.setModel(new DefaultComboBoxModel(tmpArray));
					RA_email.setText("");
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!RA_emails.isSelectionEmpty()) {
					tmpEmails.remove(RA_emails.getSelectedIndex());
					tmpArray = new String[tmpEmails.size()];
					tmpArray = tmpEmails.toArray(tmpArray);
					RA_emails.setModel(new DefaultComboBoxModel(tmpArray));
				}
			}
		});
		RA_idnumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!Estudiantes.verifyStudentID(RA_idnumber.getText())) {
					lblStudentInfo.setText(Estudiantes.getStudentInfo(RA_idnumber.getText(), Estudiantes.NAME));
				} else {
					lblStudentInfo.setText("Carnet no válido.");
				}
			}
		});
		
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clayout.show(Cards, "Rese_Buscar");
			}
		});
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Estudiantes.verifyStudentID(RA_idnumber.getText())) {
					if(((Date) RA_day.getValue()).getTime()  > date.getTime()) {
						Hora tmpHour1 = new Hora(
								((Date) RA_day.getValue()).getHours(),
								((Date) RA_day.getValue()).getMinutes(),
								((Date) RA_day.getValue()).getHours(),
								((Date) RA_day.getValue()).getMinutes() + (int) RA_time.getValue());
						if(tmpHour1.isInvalidTime()) {
							RA_result.setText("Hora invalida.");
						} else {
							int tmpQuantity = RA_emails.getComponentCount() + 1;
							GregorianCalendar tmpday = new GregorianCalendar();
							tmpday.setTime((Date) RA_day.getValue());
							RA_result.setText(Reservaciones.reserveRoom(Estudiantes.getStudent(RA_idnumber.getText()),Salas.getRoom(RA_roomId.getText()), tmpday, tmpHour1, RA_descrip.getText(), tmpQuantity));
							if(RA_result.getText().equals("Sala reservada.")) {
								String tmpMailMsg = Reservaciones.getLastReservationInfo();
								Mail.sendMail(tmpMailMsg,"Nueva reserva.", Estudiantes.getStudent(RA_idnumber.getText()).getEmail());
								for(String email: tmpEmails) {
									Mail.sendMail(tmpMailMsg,"Invitación.", email);
								}
							}
						}
						
					} else {
						RA_result.setText("Fecha invalida.");
					}
				} else {
					RA_result.setText("No se encuentra el estudiante.");
				}
			}
		});
		
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministracinDeSalas.setBounds(100, 100, 600, 500);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				clayout.show(Cards, "Rese_Consultar");
				RC_reservation.setModel(new DefaultComboBoxModel(Reservaciones.getReservationsList()));
			}
		});
		
		RC_reservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RC_result.setText(Reservaciones.getReservation((String)RC_reservation.getSelectedItem()));
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RC_reservation.getSelectedIndex() != -1) {
					if((Reservaciones.getReservation(Integer.parseInt( (String)RC_reservation.getSelectedItem()) - 1).getDate().getTimeInMillis() - 3600000) > date.getTime()) {
						Reservaciones.getReservation(Integer.parseInt((String)RC_reservation.getSelectedItem())  - 1).cancelReservation();
						RC_result.setText(Reservaciones.getReservation((String)RC_reservation.getSelectedItem()));
					}
					
				}
					
			}
		});
		mntmReportarIncidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdministracinDeSalas.setBounds(100, 100, 550, 340);
				frmAdministracinDeSalas.setLocationRelativeTo(null);
				clayout.show(Cards, "Otro_Report");
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Estudiantes.verifyStudentID(OR_studentId.getText())) {
					if(!OR_descrip.getText().equals("")) {
						Estudiantes.getStudent(OR_studentId.getText()).addIncident(OR_descrip.getText(), Integer.parseInt((String)OR_penalization.getSelectedItem()));
						OR_result.setText("Listo.");
					} else {
						OR_result.setText("Descripción vacía.");
					}
					
				} else {
					OR_result.setText("Carnet inválido.");
				}
			}
		});
		OR_studentId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!Estudiantes.verifyStudentID(OR_studentId.getText())) {
					OR_student.setText(Estudiantes.getStudentInfo(OR_studentId.getText(), Estudiantes.NAME));
				} else {
					OR_student.setText("Carnet no válido.");
				}
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clayout.show(Cards, "Analisis_datos");
				dataLayout.show(Analisis_datos, "AD_topsalas");
				

		        // Creando el Grafico
		        JFreeChart chart = ChartFactory.createPieChart("Top 5 salas",Reservaciones.getTopCareers());

		        // Crear el Panel del Grafico con ChartPanel
		        ChartPanel chartPanel = new ChartPanel(chart);
		        AD_topsalas.setViewportView(chartPanel);
		        
			}
		});
		
		
		
		ActionListener updateClockAction = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  date = new Date();
			      lblHora.setText(new SimpleDateFormat("EEE,d MMM yyyy HH:mm:ss").format(date));
			      if(lastWeek != new GregorianCalendar().get(GregorianCalendar.WEEK_OF_YEAR)) {
			    	  lastWeek = lastWeek = new GregorianCalendar().get(GregorianCalendar.WEEK_OF_YEAR);
			    	  System.out.println("New week :D");
			    	  saveProp();
			    	  Estudiantes.resetWeekReservations();
			      }
			  }
		};
		Timer t = new Timer(1000, updateClockAction);
		t.start();
	}
}
