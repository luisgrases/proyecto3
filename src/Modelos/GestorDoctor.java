package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
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
		
		public Vector obtenerDoctores() throws Exception {
			Vector doctores=null;
			Vector datosDoctores=null;
			Doctor doctor;
			doctores = (new MultiDoctor()).buscarTodos();
			datosDoctores = new Vector();
			for (int i=0; i<doctores.size(); i++) {
				doctor = ((Doctor) doctores.get(i));
				TreeMap datosDoctor = new TreeMap();
				datosDoctor.put("nombre", doctor.getNombre());
				datosDoctor.put("identificacion", doctor.getId());
				datosDoctores.add(datosDoctor);
			}
			return datosDoctores;
		}

}
