import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class BD2 {
	// TODO: Cambiar el nombre de la base de datos, usuario y clave
	private static final String BASE_DATOS = "comunidad";
	private static final String USUARIO = "comunidad";
	private static final String CLAVE = "comunidad";

	private static Connection conexion;

	static {BD2.conectar();}
	
	private static void conectar(){
		try {
			Properties props = new Properties();

			props.put("user", USUARIO);
			props.put("password", CLAVE);

			Class.forName("com.mysql.cj.jdbc.Driver");
			BD2.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BASE_DATOS
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					props);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public Connection getConexion() {
		if (BD2.conexion == null)
			BD2.conectar();
		return BD2.conexion;
	}

}
