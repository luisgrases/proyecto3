package Modelos;

import java.sql.SQLException;

public class GestorConsulta {
  
  public static void agregar(Consulta pconsulta) throws SQLException, Exception {
    (new MultiConsulta()).crear(pconsulta);
  }

  
}
