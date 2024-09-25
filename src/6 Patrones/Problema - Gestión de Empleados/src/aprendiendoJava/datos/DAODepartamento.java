package aprendiendoJava.datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.datos.BD;

public class DAODepartamento{
	private static final String SQL_SIGUIENTE_ID = "SELECT MAX(id) FROM departamentos";
	private static final String SQL_GUARDAR = "INSERT INTO departamentos VALUES (?,?,?)";
	private static final String SQL_BUSCAR_POR_ID = "SELECT id, nombre, presupuesto FROM departamentos WHERE id = ?";
	
	private static BD bd = new BD();
	private static PreparedStatement psSiguienteId;
	private static PreparedStatement psGuardar;
	private static PreparedStatement psBuscarPorId;
	
	static {
		try{
			DAODepartamento.psSiguienteId = DAODepartamento.bd.getConexion().prepareStatement(SQL_SIGUIENTE_ID);
			DAODepartamento.psGuardar = DAODepartamento.bd.getConexion().prepareStatement(SQL_GUARDAR);
			DAODepartamento.psBuscarPorId = DAODepartamento.bd.getConexion().prepareStatement(SQL_BUSCAR_POR_ID);
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new RuntimeException("No se ha podido inicializar DAODepartamento.");
		}
	}
	
	public Integer buscarSiguienteId() throws Exception{
		try{
			ResultSet resultado = DAODepartamento.psSiguienteId.executeQuery();
			if (resultado.next())
				return resultado.getInt(1) + 1;
			else
				return 1;
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
	}
	
	public void guardar(Departamento departamento) throws Exception{
		try{
			DAODepartamento.psGuardar.setInt(1, departamento.getId());
			DAODepartamento.psGuardar.setString(2, departamento.getNombre());
			DAODepartamento.psGuardar.setFloat(3, departamento.getPresupuesto());
			DAODepartamento.psGuardar.execute();
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos al guardar Departamento.");
		}
	}
	
	public static Departamento buscarPorId(int id) throws Exception{
		String sql = SQL_BUSCAR_POR_ID + id;
		try{
			DAODepartamento.psBuscarPorId.setInt(1, id);
			ResultSet resultado = DAODepartamento.psBuscarPorId.executeQuery();
			if (resultado.next()){
				int idDepartamento = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				Float presupuesto = resultado.getFloat("presupuesto");
				return new Departamento(idDepartamento, nombre, presupuesto);
			}
			else
				throw new Exception("No existe ningún departamento con id = " + id + ".");
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos al guardar Departamento.");
		}
	}
}
 