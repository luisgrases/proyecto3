package Modelos;

import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiExpediente {
  
  public Vector<Expediente> buscarTodos()throws java.sql.SQLException,Exception{

    Vector<Expediente> expedientes = new Vector();

    java.sql.ResultSet rs;
    String sql;
    sql = "SELECT * " +
        "FROM TExpediente;";
    rs = Conector.getConector().ejecutarSQL(sql,true);

    if(rs.next()){
      do {
        Expediente expediente = new Expediente (
            rs.getString("ID"),
            rs.getString("FechaApertura"),
            rs.getString("NombrePaciente"),
            rs.getString("DireccionPaciente"),
            rs.getString("FechaNacimientoPaciente"),
            rs.getString("TelefonoPaciente"),
            rs.getString("CedulaPaciente")
            );
        expedientes.add(expediente);
      } while (rs.next());
    }else{
      throw new Exception ("No se encuentras expedientes registrados");

    }
    rs.close();
    return expedientes;

  }
  
  public void crear(Expediente pexpediente)throws java.sql.SQLException,Exception{

    String sql = "INSERT INTO TExpediente"+"(FechaApertura, CedulaPaciente, NombrePaciente, DireccionPaciente, TelefonoPaciente, FechaNacimientoPaciente, EdadPaciente)" +
        "VALUES ('" +
        pexpediente.getFechaApertura() + "', '" + 
        pexpediente.getCedulaPaciente() + "','" +
        pexpediente.getNombrePaciente()+"','"+
        pexpediente.getDireccionPaciente()+"','"+
        pexpediente.getTelefonoPaciente()+"','"+
        pexpediente.getFechaNacimientoPaciente()+"','"+
        pexpediente.getEdadPaciente()+"');";

    try{
      Conector.getConector().ejecutarSQL(sql);

    }catch(Exception e){
      throw new Exception ("No se ha podido registrar la consulta. "+e);
    }

  }

}
