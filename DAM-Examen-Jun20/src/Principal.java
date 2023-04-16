import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application {

	private Stage ventana;
	private BorderPane panelPrincipal;
	private Scene escena;
	private AnchorPane panel1, panel2;

	// TODO: Conectamos todos los controles de las pantallas fxml.

	// Campos de Pantalla 1
	@FXML
	ComboBox<String> cbViviendas;
	@FXML
	TextField tfNifVecino, tfNombreVecino, tfDireccionVecino, tfPoblacionVecino, tfNumeroVivienda, tfIdVivienda,
			tfDireccionVivienda, tfPoblacionVivienda, tfCuota;
	@FXML
	DatePicker dpFechaCuota;
	@FXML
	TextArea taConcepto;

	// Campos de Pantalla 2
	@FXML
	ComboBox<String> cbClientes;
	@FXML
	DatePicker dpFechaInicio, dpFechaFinal;
	@FXML
	TableView<FilaTabla> tvTabla;
	@FXML
	TableColumn<FilaTabla, String> tcVivienda, tcDireccion, tcLocalidad, tcConcepto;
	@FXML
	TableColumn<FilaTabla, LocalDate> tcFecha;
	@FXML
	TableColumn<FilaTabla, Double> tcImporte;
	
	//Modelo de Datos de la tabla
	ObservableList<FilaTabla> modelo = FXCollections.observableArrayList();
	
	public static void main(String[] args) {
		
		BD2 bd = new BD2();
		System.out.println(bd.getConexion());
		
		Application.launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		this.ventana = ventana;

		BD.conectar(); // Conectamos la base de datos

		// Cargamos la ventana principal (con el menú de pantallas)
		FXMLLoader cargador1 = new FXMLLoader(getClass().getResource("principal.fxml"));
		this.panelPrincipal = new BorderPane();
		cargador1.setRoot(this.panelPrincipal);
		cargador1.setController(this);
		cargador1.load();
		escena = new Scene(this.panelPrincipal);

		// Cargamos la primera pantalla
		FXMLLoader cargador2 = new FXMLLoader(getClass().getResource("pantalla1.fxml"));
		this.panel1 = new AnchorPane();
		cargador2.setRoot(this.panel1);
		cargador2.setController(this);
		cargador2.load();

		// Cargamos la segunda pantalla
		FXMLLoader cargador3 = new FXMLLoader(getClass().getResource("pantalla2.fxml"));
		this.panel2 = new AnchorPane();
		cargador3.setRoot(this.panel2);
		cargador3.setController(this);
		cargador3.load();

		this.panelPrincipal.setCenter(this.panel1);
		ventana.setScene(escena);

		//Asociamos el TableView a su modelo
		tvTabla.setItems(modelo);
		tcVivienda.setCellValueFactory(new PropertyValueFactory<>("idVivienda"));	//idVivienda es el nombre del campo de FilaTabla
		tcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		tcLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
		tcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		tcImporte.setCellValueFactory(new PropertyValueFactory<>("importe"));
		tcConcepto.setCellValueFactory(new PropertyValueFactory<>("concepto"));
		
		//TODO: Carga de Datos iniciales. Adaptar según el enunciado
		cargarViviendas();
		cargarNombresCliente();

		ventana.show();
	}

	// Acciones del menú
	public void verPantalla1() {
		this.panelPrincipal.setCenter(this.panel1);
	}

	public void verPantalla2() {
		this.panelPrincipal.setCenter(this.panel2);
	}

	// Acciones Iniciales
	private void cargarViviendas() throws SQLException {
		// Carga las viviendas en el comboBox de la pantalla 1
		cbViviendas.getItems().clear(); // Borramos las que pudiera haber
		ArrayList<String> idViviendas = BD.verIdViviendas(); // Pedimos a la BD la lista
		cbViviendas.getItems().addAll(idViviendas); // Las añadimos al comboBox
	}

	private void cargarNombresCliente() throws SQLException {
		// Carga los nombres de los clientes en el comboBox de la pantalla2
		cbClientes.getItems().clear(); // Borramos los que pudiera haber
		ArrayList<String> nombresClientes = BD.verNombresClientes(); // Pedimos a la BD la lista
		cbClientes.getItems().addAll(nombresClientes); // Las añadimos al comboBox
	}

	// Acciones de Eventos
	public void cargarDatosVivienda() throws SQLException {
		String idViviendaSeleccionado = cbViviendas.getValue();
		ArrayList datos = BD.getVivienda(idViviendaSeleccionado);
		tfNifVecino.setText(datos.get(4).toString());
		tfNombreVecino.setText(datos.get(5).toString());
		tfDireccionVecino.setText(datos.get(6).toString());
		tfPoblacionVecino.setText(datos.get(7).toString());
		tfNumeroVivienda.setText(datos.get(0).toString());
		tfIdVivienda.setText(datos.get(1).toString());
		tfDireccionVivienda.setText(datos.get(2).toString());
		tfPoblacionVivienda.setText(datos.get(3).toString());
		;
	}

	public void grabarCuota() throws SQLException {
		// Acción del botón GRABAR CUOTA
		// Recojo los datos del interfaz - Miro los tipos de datos en la tabla de la
		// BBDD
		LocalDate fecha = dpFechaCuota.getValue();
		Double cuota = Double.valueOf(tfCuota.getText());
		String concepto = taConcepto.getText();
		Integer numeroVivienda = Integer.valueOf(tfNumeroVivienda.getText());

		// Llamo a la operación de base de datos
		BD.grabarCuota(fecha, cuota, concepto, numeroVivienda);

		// (Opcional) Informo al usuario del resultado de la operación - Si hubiera ido
		// mal, habría saltado una excepción
		// Ejemplos de diálogos en https://code.makery.ch/blog/javafx-dialogs-official/
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Información al Usuario");
		alert.setHeaderText("Operación realizada con éxito");
		alert.setContentText("La cuota se grabó correctamente");
		alert.showAndWait();
	}

	public void mostrarListado() throws SQLException {
	// Acción del botón MOSTRAR LISTADO
		// Recojo los datos del interfaz
		LocalDate fechaInicio = dpFechaInicio.getValue();
		String nombreVecino = cbClientes.getValue();
		LocalDate fechaFinal = dpFechaFinal.getValue();

		// Llamo a la operación de base de datos
		ArrayList<FilaTabla> resultados = BD.verListado(fechaInicio, nombreVecino, fechaFinal);
		
		//Cargamos los datos en el modelo del TableView
		this.modelo.clear();
		for(FilaTabla fila : resultados)
			this.modelo.add(fila);
		tvTabla.refresh();
				
		// No informo al usuario porque ya verá los datos en la tabla
	}
}
