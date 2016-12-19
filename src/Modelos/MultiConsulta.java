package Modelos;

import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiConsulta {
  
  public void crear(Consulta pconsulta)throws java.sql.SQLException,Exception{

    String sql = "INSERT INTO TConsulta"+"(IDDoctor,IDExpediente,FechaRealizacion, Problema, MedicinasRecetadas)" +
        "VALUES ('" +
    	
		pconsulta.getExpediente() + "', '"+
		pconsulta.getDoctor() + "', '" + 
        pconsulta.getFechaRealizacion() + "', '" + 
        pconsulta.getProblema() + "', '" + 
        pconsulta.getMedicinasRecetadas() + "');";
        

    try{
      Conector.getConector().ejecutarSQL(sql);

    }catch(Exception e){
      throw new Exception (e.getMessage());
    }

  }
  
  public Vector<Consulta> buscarConsultasPorExpediente(String pidExpediente) throws java.sql.SQLException,Exception{

    Vector<Consulta> consultas = new Vector();

    java.sql.ResultSet rs;
    String sql;
    sql = "SELECT * "+
        "FROM TConsulta "+
        "WHERE IDExpediente='"+pidExpediente+"';";
    rs = Conector.getConector().ejecutarSQL(sql,true);

    if(rs.next()){
      do {
        
        Consulta consulta = new Consulta (
            rs.getString("ID"),
            rs.getString("FechaRealizacion"),
            rs.getString("Problema"),
            rs.getString("MedicinasRecetadas")
            );
        consultas.add(consulta);
      } while (rs.next());
    }else{
      throw new Exception ("No se encuentras consultas registrados");

    }
    rs.close();
    return consultas;

  }
  
  public Vector<Consulta> buscarTodos()throws java.sql.SQLException,Exception{

    Vector<Consulta> consultas = new Vector();

    java.sql.ResultSet rs;
    String sql;
    sql = "SELECT * " +
        "FROM TConsulta;";
    rs = Conector.getConector().ejecutarSQL(sql,true);

    if(rs.next()){
      do {
        
        Consulta consulta = new Consulta (
            rs.getString("ID"),
            rs.getString("FechaRealizacion"),
            rs.getString("Problema"),
            rs.getString("MedicinasRecetadas")
            );
        consultas.add(consulta);
      } while (rs.next());
    }else{
      throw new Exception ("No se encuentras consultas registrados");

    }
    rs.close();
    return consultas;

  }
  
  
  
  public Vector<Consulta> buscarConsultasPorFechaYId(String pidExpediente,String pFechaConsulta) throws java.sql.SQLException,Exception{

	    Vector<Consulta> consultas = new Vector();

	    java.sql.ResultSet rs;
	    String sql;
	    sql = "SELECT * "+
	        "FROM TConsulta "+
	        "WHERE IDExpediente='"+pidExpediente+"AND FechaRealizacion='"+pFechaConsulta+"';";
	    rs = Conector.getConector().ejecutarSQL(sql,true);

	    if(rs.next()){
	      do {
	        
	        Consulta consulta = new Consulta (
	            rs.getString("ID"),
	            rs.getString("FechaRealizacion"),
	            rs.getString("Problema"),
	            rs.getString("MedicinasRecetadas")
	            );
	        consultas.add(consulta);
	      } while (rs.next());
	    }else{
	      throw new Exception ("No se encuentras consultas registrados");

	    }
	    rs.close();
	    return consultas;

	  }

}
