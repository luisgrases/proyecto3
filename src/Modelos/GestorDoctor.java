package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;


public class GestorDoctor {



  public void registrarDoctor(String pnombre,String pespecialidad,String ptelefono) throws Exception {

    Doctor doctor = new Doctor(pnombre,pespecialidad,ptelefono);
    (new MultiDoctor()).crear(doctor);
  }

  public Vector<TreeMap> listarDoctores() throws SQLException, Exception {
    Vector<Doctor> doctores = (new MultiDoctor()).buscarTodos();
    Vector<TreeMap> datosDoctores = new Vector<TreeMap>();
    for(Doctor doctor : doctores) {
      TreeMap datosDoctor = new TreeMap();
      datosDoctor.put("id", doctor.getId());
      datosDoctor.put("nombre", doctor.getNombre());
//      datosDoctor.put("especialidad", doctor.getEspecialidad());
//      datosDoctor.put("telefono", doctor.getTelefono());
      datosDoctores.add(datosDoctor);
    }
    return datosDoctores;

  }

  public TreeMap buscarDoctor(String pid) throws SQLException, Exception {
    Doctor doctor = (new MultiDoctor()).buscar(pid);
    TreeMap datosDoctor = new TreeMap();
    datosDoctor.put("id", doctor.getId());
    datosDoctor.put("nombre", doctor.getNombre());
    datosDoctor.put("especialidad", doctor.getEspecialidad());
    datosDoctor.put("telefono", doctor.getTelefono());
    
    return datosDoctor;

  }

}
