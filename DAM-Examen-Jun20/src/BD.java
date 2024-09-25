import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class BD {
	// TODO: Cambiar el nombre de la base de datos, usuario y clave
	private static final String BASE_DATOS = "comunidad";
	private static final String USUARIO = "comunidad";
	private static final String CLAVE = "comunidad";

	private static Connection conexion;

	public static void conectar() {
		try {
			Properties props = new Properties();

			props.put("user", USUARIO);
			props.put("password", CLAVE);

			Class.forName("com.mysql.cj.jdbc.Driver");
			BD.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BASE_DATOS
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					props);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	// Ejemplo de operación de SELECT con varios resultados
	public static ArrayList<String> verIdViviendas() throws SQLException {
		ArrayList<String> resultado = new ArrayList<>();
		String sql = "SELECT id_vivienda FROM viviendas ";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		while (rs.next()) { // Usamos while porque esperamos varios resultados
			String idVivienda = rs.getString("id_vivienda");
			resultado.add(idVivienda);
		}
		rs.close();
		return resultado;
	}

	// Ejemplo de operación de SELECT con un único resultado
	public static ArrayList getVivienda(String idViviendaSeleccionado) throws SQLException {
		ArrayList resultado = new ArrayList();
		String sql = "SELECT viviendas.numero, viviendas.id_vivienda, viviendas.direccion, viviendas.poblacion, "
				+ " vecinos.nif, vecinos.nombre, vecinos.direccion, vecinos.poblacion " + " FROM viviendas "
				+ " JOIN vecinos ON viviendas.nif = vecinos.nif " + " WHERE id_vivienda = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		// Asociamos el parámetro de la consulta
		sentencia.setString(1, idViviendaSeleccionado);
		// System.out.println(sentencia); //Nos muestra la sentencia en consola y así
		// podemos probarla en MySQL
		ResultSet rs = sentencia.executeQuery();
		if (rs.next()) { // Usamos if porque solo esperamos UN resultado
			for (int i = 1; i <= 8; i++)
				resultado.add(rs.getObject(i));
		}
		rs.close();
		return resultado;
	}

	// Ejemplo de operación de INSERT, UPDATE o DELETE
	public static void grabarCuota(LocalDate fecha, Double cuota, String concepto, Integer numeroVivienda)
			throws SQLException {
		String sql = "INSERT INTO cuotas (concepto, fecha, importe, numero) " // No está idcuota porque es
																				// AUTO_INCREMENT
				+ " VALUES(?,?,?,?)";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		// Asociamos los valores a la consulta
		sentencia.setString(1, concepto);
		sentencia.setDate(2, Date.valueOf(fecha)); // Hay que convertir el LocalDate en java.sql.Date
		sentencia.setDouble(3, cuota);
		sentencia.setInt(4, numeroVivienda);
		// System.out.println(sentencia); //Nos muestra la sentencia en consola y así
		// podemos probarla en MySQL
		sentencia.executeUpdate(); // Siempre es excuteUpdate aunque sea INSERT o DELETE
	}

	// Ejemplo de operación de SELECT con varios resultados
	public static ArrayList<String> verNombresClientes() throws SQLException {
		ArrayList<String> resultado = new ArrayList<>();
		String sql = "SELECT nombre FROM vecinos ";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		ResultSet rs = sentencia.executeQuery();
		while (rs.next()) { // Usamos while porque esperamos varios resultados
			String nombre = rs.getString("nombre");
			resultado.add(nombre);
		}
		rs.close();
		return resultado;
	}

	// Ejemplo de operación de SELECT con varios resultados
	public static ArrayList<FilaTabla> verListado(LocalDate fechaInicio, String nombreVecino, LocalDate fechaFinal) throws SQLException {
		ArrayList<FilaTabla> resultado = new ArrayList<>();
		//La sentencia es una BURRADA (nivel de examen de Base de Datos).
		//Si no te la sabes, da igual, haz un select de los campos que necesitas y listo.
		String sql = "SELECT viviendas.id_vivienda, viviendas.direccion, viviendas.poblacion, "
				+ " cuotas.fecha, cuotas.importe, cuotas.concepto "
				+ " FROM viviendas "
				+ " JOIN cuotas ON viviendas.numero = cuotas.numero "
				+ " JOIN vecinos ON viviendas.nif = vecinos.nif "
				+ " WHERE vecinos.nombre = ? "
				+ " AND cuotas.fecha BETWEEN ? AND ? "
				+ " ORDER BY viviendas.id_vivienda, cuotas.fecha";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, nombreVecino);
		sentencia.setDate(2, Date.valueOf(fechaInicio));
		sentencia.setDate(3, Date.valueOf(fechaFinal));
		//System.out.println(sentencia); //Nos muestra la sentencia en consola y así
		// podemos probarla en MySQL
		ResultSet rs = sentencia.executeQuery();
		while (rs.next()) { // Usamos while porque esperamos varios resultados
			String idVivienda = rs.getString("id_vivienda");
			String direccion = rs.getString("direccion");
			String localidad = rs.getString("poblacion");
			LocalDate fecha = rs.getDate("fecha").toLocalDate();	//Convertimos de sql.Date a LocalDate
			Double importe = rs.getDouble("importe");
			String concepto = rs.getString("concepto");
			FilaTabla fila = new FilaTabla(idVivienda, direccion, localidad, fecha, importe, concepto);
			resultado.add(fila);
		}
		rs.close();
		return resultado;
	}

}
