package Modelos;

import java.sql.SQLException;
import java.util.Vector;

public class GestorConsulta {
  
  public static void agregar(Consulta pconsulta) throws SQLException, Exception {
    (new MultiConsulta()).crear(pconsulta);
  }
  
  public static Vector<Consulta> listar() throws SQLException, Exception {
    return (new MultiConsulta()).buscarTodos();
  }

  
}
