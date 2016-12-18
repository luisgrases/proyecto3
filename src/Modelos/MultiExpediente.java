package Modelos;

import java.sql.SQLException;
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
            rs.getString("CedulaPaciente"),
            rs.getString("DireccionPaciente"),
            rs.getString("FechaNacimientoPaciente"),
            rs.getString("TelefonoPaciente"),
            rs.getString("EdadPaciente")
            );
        expedientes.add(expediente);
      } while (rs.next());
    }else{
      throw new Exception ("No se encuentran expedientes registrados");

    }
    rs.close();
    return expedientes;

  }
  
  public void crear(Expediente pexpediente)throws java.sql.SQLException,Exception{

    String sql = "INSERT INTO TExpediente"+"(FechaApertura, FechaNacimientoPaciente, CedulaPaciente, NombrePaciente, TelefonoPaciente, DireccionPaciente, EdadPaciente)" +
        "VALUES ('" +
        pexpediente.getFechaApertura() + "', '" + 
        pexpediente.getFechaNacimientoPaciente()+"','"+
        pexpediente.getCedulaPaciente() + "','" +
        pexpediente.getNombrePaciente()+"','"+
        pexpediente.getTelefonoPaciente()+"','"+
        pexpediente.getDireccionPaciente()+"','"+
        pexpediente.getEdadPaciente()+"');";

    try{
      Conector.getConector().ejecutarSQL(sql);

    }catch(Exception e){
      throw new Exception ("No se ha podido registrar la consulta. "+e);
    }

  }

  public Expediente buscarCedulaPaciente(String pcedula) throws SQLException, Exception {
	 Expediente ex;
	 java.sql.ResultSet rs;
	 String sql;

	    sql = "SELECT ID,FechaApertura,NombrePaciente,DireccionPaciente,TelefonoPaciente,FechaNacimientoPaciente,EdadPaciente "+
	        "FROM TExpediente "+
	        "WHERE CedulaPaciente='"+ pcedula +"';";
	    
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			ex = new Expediente(
				rs.getString("ID"),
				rs.getString("FechaApertura"),
				rs.getString("NombrePaciente"),
				rs.getString("DireccionPaciente"),
				//rs.getString("FechaNacimiento"),
				rs.getString("TelefonoPaciente"),
				rs.getString("EdadPaciente"));
		} else {
			throw new Exception ("El paciente no esta registrado");
		}
		rs.close();

	return ex;
  }

  public Expediente buscarExpedientePaciente(String pnumeroExpediente) throws SQLException, Exception {
	
		Expediente ex;
		 java.sql.ResultSet rs;
		 String sql;
	
		    sql = "SELECT ID,FechaApertura,NombrePaciente,DireccionPaciente,TelefonoPaciente,FechaNacimientoPaciente,EdadPaciente "+
		        "FROM TExpediente "+
		        "WHERE ID='"+ pnumeroExpediente +"';";
		    
			rs = Conector.getConector().ejecutarSQL(sql,true);
			if (rs.next()){
				ex = new Expediente(
					rs.getString("ID"),
					rs.getString("FechaApertura"),
					rs.getString("NombrePaciente"),
					rs.getString("DireccionPaciente"),
					//rs.getString("FechaNacimiento"),
					rs.getString("TelefonoPaciente"),
					rs.getString("EdadPaciente"));
			} else {
				throw new Exception ("El paciente no esta registrado");
			}
			rs.close();
	
		return ex;

  }

}
