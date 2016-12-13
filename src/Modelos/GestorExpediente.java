package Modelos;

import java.sql.SQLException;
import java.util.Vector;

public class GestorExpediente {
  
  public Vector<Expediente> listar() throws SQLException, Exception {
    return (new MultiExpediente()).buscarTodos();
  }
  
  public void registrar(Expediente pnuevoExpediente) throws SQLException, Exception {
    new MultiExpediente().crear(pnuevoExpediente);
  }
}
