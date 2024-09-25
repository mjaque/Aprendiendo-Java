package aprendiendoJava.datos;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.datos.BD;

public class DAODepartamento{
	private static final String SQL_SIGUIENTE_ID = "SELECT MAX(id)+1 FROM departamentos";
	private static final String SQL_GUARDAR = "INSERT INTO departamentos VALUES";
	private static final String SQL_BUSCAR_POR_ID = "SELECT id, nombre, presupuesto FROM departamentos WHERE id = ";
	
	private static BD bd = new BD();
		
	public Integer buscarSiguienteId() throws Exception{
		try{
			ResultSet resultado = DAODepartamento.bd.getSentencia().executeQuery(SQL_SIGUIENTE_ID);
			if (resultado.next())
				return resultado.getInt(1);
			else
				throw new Exception("No ha podido obtenerse el siguiente id de departamento.");
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
	}
	
	public void guardar(Departamento departamento) throws Exception{
		String sql = SQL_GUARDAR + "(" + departamento.getId() + ", '" + departamento.getNombre() + "', " + departamento.getPresupuesto() + ")";
		try{
			DAODepartamento.bd.getSentencia().execute(sql);
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos al guardar Departamento.");
		}
	}
	
	public static Departamento buscarPorId(int id) throws Exception{
		String sql = SQL_BUSCAR_POR_ID + id;
		try{
			ResultSet resultado = DAODepartamento.bd.getSentencia().executeQuery(sql);
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
 