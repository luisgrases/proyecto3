package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;

public class GestorConsulta {
  
  public  void agregar(String pfechaRealizacion,String pdescripcionProblema,String pmedicinasRecetadas,TreeMap pdoctorSeleccionado,TreeMap pexpedienteSeleccionado) throws SQLException, Exception {
	 String idDoc = (String) pexpedienteSeleccionado.get("identificacion");
	 String idEx = (String) pdoctorSeleccionado.get("id");
	 
	 
	 Consulta nuevaConsulta = new Consulta(pfechaRealizacion, pdescripcionProblema, pmedicinasRecetadas, idDoc, idEx);
      
    (new MultiConsulta()).crear(nuevaConsulta);
  }
  
  public static Vector<Consulta> listar() throws SQLException, Exception {
    return (new MultiConsulta()).buscarTodos();
  }

  
}
