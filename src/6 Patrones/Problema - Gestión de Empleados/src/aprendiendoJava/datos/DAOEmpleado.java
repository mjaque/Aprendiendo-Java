package aprendiendoJava.datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.negocio.Empleado;
import aprendiendoJava.datos.BD;

public class DAOEmpleado{
	private static final String SQL_SIGUIENTE_ID = "SELECT MAX(id) FROM empleados";
	private static final String SQL_GUARDAR = "INSERT INTO empleados VALUES (?,?,?,?,?)";
	private static final String SQL_LISTAR = "SELECT empleados.id, empleados.nombre, empleados.apellidos, empleados.fecha_nacimiento, " +
		" departamentos.id, departamentos.nombre, departamentos.presupuesto " +
		" FROM empleados JOIN departamentos ON empleados.idDepartamento = departamentos.id " +
		" ORDER BY empleados.apellidos";

	private static BD bd = new BD();
	private static PreparedStatement psSiguienteId;
	private static PreparedStatement psGuardar;
	private static PreparedStatement psListar;
	
	static {
		try{
			DAOEmpleado.psSiguienteId = DAOEmpleado.bd.getConexion().prepareStatement(SQL_SIGUIENTE_ID);
			DAOEmpleado.psGuardar = DAOEmpleado.bd.getConexion().prepareStatement(SQL_GUARDAR);
			DAOEmpleado.psListar = DAOEmpleado.bd.getConexion().prepareStatement(SQL_LISTAR);
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new RuntimeException("No se ha podido inicializar DAOEmpleado.");
		}
	}
	
	public Integer buscarSiguienteId() throws Exception{
		try{
			ResultSet resultado = DAOEmpleado.psSiguienteId.executeQuery();
			if (resultado.next())
				return resultado.getInt(1) + 1;
			else
				return 1;
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
	}

	public void guardar(Empleado empleado) throws Exception{
		try{
			DAOEmpleado.psGuardar.setInt(1, empleado.getId());
			DAOEmpleado.psGuardar.setString(2, empleado.getNombre());
			DAOEmpleado.psGuardar.setString(3, empleado.getApellidos());
			DAOEmpleado.psGuardar.setDate(4, Date.valueOf(empleado.getFechaNacimiento()));
			DAOEmpleado.psGuardar.setInt(5, empleado.getDepartamento().getId());
			DAOEmpleado.psGuardar.execute();
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos al guardar Empleado.");
		}
	}
	
	public List<Empleado> listar() throws Exception{
		List<Empleado> listaEmpleados = new ArrayList<>();
		try{
			ResultSet resultado = DAOEmpleado.psListar.executeQuery();
			while (resultado.next()){
				int idEmpleado = resultado.getInt("empleados.id");
				String nombreEmpleado = resultado.getString("empleados.nombre");
				String apellidos = resultado.getString("empleados.apellidos");
				Date fechaNacimientoSQL = resultado.getDate("empleados.fecha_nacimiento");
				LocalDate fechaNacimiento = fechaNacimientoSQL.toLocalDate();
				int idDepartamento = resultado.getInt("departamentos.id");
				String nombreDepartamento = resultado.getString("departamentos.nombre");
				Float presupuesto = resultado.getFloat("departamentos.presupuesto");
				Departamento departamento = new Departamento(idDepartamento, nombreDepartamento, presupuesto);
				listaEmpleados.add(new Empleado(idEmpleado, nombreEmpleado, apellidos, fechaNacimiento, departamento));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
		return listaEmpleados;
	}

}
 
