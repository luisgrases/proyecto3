package Modelos;

import java.sql.SQLException;
import java.util.Vector;

public class GestorConsulta {
  
  public static void agregar(String pfechaRealizacion,String pdescripcionProblema,String pmedicinasRecetadas,String pdoctorSeleccionado,String pexpedienteSeleccionado) throws SQLException, Exception {
	  
	 Consulta nuevaConsulta = new Consulta(pfechaRealizacion, pdescripcionProblema, pmedicinasRecetadas, pdoctorSeleccionado, pexpedienteSeleccionado);
      
    (new MultiConsulta()).crear(nuevaConsulta);
  }
  
  public static Vector<Consulta> listar() throws SQLException, Exception {
    return (new MultiConsulta()).buscarTodos();
  }

  
}
