package Modelos;

import java.sql.SQLException;
import java.util.Vector;

public class GestorDoctor {
	
	public void registrarDoctor(String pnombre,String pespecialidad,String ptelefono) throws Exception {
		
		Doctor doctor = new Doctor(pnombre,pespecialidad,ptelefono);
		 	
		  (new MultiDoctor()).crear(doctor);
		
	}

		public Vector<Doctor> listarDoctores() throws SQLException, Exception {
		  Vector<Doctor> doctores = (new MultiDoctor()).buscarTodos();
		  return doctores;
		  
		}
		
		public Doctor buscarDoctor(String pid) throws SQLException, Exception {
	    Doctor doctor = (new MultiDoctor()).buscar(pid);
	    
	    return doctor;
	    
	  }

}
