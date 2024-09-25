package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Usuario;

/**
 * Session Bean implementation class DAOUsuario
 */
@Stateless
public class DAOUsuario implements DAOUsuarioRemote {

	/**
	 * Default constructor.
	 */
	public DAOUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario login(String nombre, String clave) {
		System.out.println("En dao.Usuario.login(" + nombre + ", " + clave + ")");
		Usuario resultado = null;

		System.out.println("0");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		System.out.println("1");
		EntityManager manager = emf.createEntityManager();
		System.out.println("2");
		EntityTransaction transaction = null;
		System.out.println("3");

		try{
			// Get a transaction
			transaction = manager.getTransaction();
			// Begin the transaction
			transaction.begin();

			// Create a new Student object
			Usuario usu = new Usuario();
			usu.setId(3);
			usu.setNombre("prueba");
			usu.setClave("pruebaClave");

			// Save the student object
			manager.persist(usu);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}

		// try {
		// System.out.println("1");
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("manager1");
		// System.out.println("2");
		// EntityManager em = emf.createEntityManager();
		// System.out.println("3");
		// EntityTransaction t = em.getTransaction();
		// System.out.println("4");
		// t.begin();
		// System.out.println("5");
		// Query query = em.createQuery("select usuario AS from Usuario where
		// nombre = :usuario and clave = MD5(:clave) ");
		// System.out.println("6");
		// query.setParameter("usuario", nombre);
		// System.out.println("7");
		// query.setParameter("clave", clave);
		// System.out.println("8");
		// resultado = (Usuario) query.getSingleResult();
		// System.out.println("9");
		// System.out.println("DAOUsuario.login: " + resultado);
		// System.out.println("10");
		// // Close the Entity Manager
		// em.close();
		// emf.close();
		// } catch (Exception e) {
		// System.out.println("El usuario no existe");
		// }
		return resultado;
	}

	@Override
	public Usuario registro(String usuario, String clave, String email) {
		Usuario nuevoUsuario = new Usuario();
		// nuevoUsuario.setNombre(usuario);
		// nuevoUsuario.setClave(clave);
		// nuevoUsuario.setEmail(email);
		// Session sesion = ORM.INSTANCE.openSession();
		// sesion.beginTransaction();
		// sesion.save(nuevoUsuario);
		// sesion.getTransaction().commit();
		return nuevoUsuario;
	}

}
