package Modelos;

import java.util.Vector;

import javax.swing.JOptionPane;

import CapaAccesoBD.Conector;

public class MultiConsulta {
  
  public void crear(Consulta pconsulta)throws java.sql.SQLException,Exception{
	  
	Doctor doctor = pconsulta.getDoctor();
	Expediente expediente = pconsulta.getExpediente();

    String sql = "INSERT INTO TConsulta"+"(IDDoctor,IDExpediente,FechaRealizacion, Problema, MedicinasRecetadas)" +
        "VALUES ('" +
    	
		doctor.getId() + "', '"+
		expediente.getId() + "', '" + 
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
  public Doctor DbuscarPorConsulta(String pid) throws java.sql.SQLException,Exception{
	    Doctor doctor;
	    String IdDoctor;
	    java.sql.ResultSet rs;
	    String sql;

	    sql = "SELECT IDDoctor "+
	        "FROM TConsulta "+
	        "WHERE ID='"+ pid +"';";

	    rs = Conector.getConector().ejecutarSQL(sql,true);

	    if (rs.next()) {  
	      IdDoctor = rs.getString("IDDoctor");
	      doctor = (new MultiDoctor()).buscar(IdDoctor);
	    } else {  
	      throw new Exception ("El doctor no está registrado.");
	    }

	    rs.close();

	    return doctor;
	 }
  
  	public Expediente EbuscarPorConsulta(String pid) throws java.sql.SQLException,Exception{
	    Expediente expediente;
	    String IdExpediente;
	    java.sql.ResultSet rs;
	    String sql;

	    sql = "SELECT IDExpediente "+
	        "FROM TConsulta "+
	        "WHERE ID='"+ pid +"';";

	    rs = Conector.getConector().ejecutarSQL(sql,true);

	    if (rs.next()) {  
	      IdExpediente = rs.getString("IDExpediente");
	      expediente = (new MultiExpediente()).buscarExpedientePaciente(IdExpediente);
	    } else {  
	      throw new Exception ("El doctor no está registrado.");
	    }

	    rs.close();

	    return expediente;
	 }
  
}
