package Modelos;

import CapaAccesoBD.Conector;

public class MultiConsulta {
  
  public void crear(Consulta pconsulta)throws java.sql.SQLException,Exception{

    String sql = "INSERT INTO TConsulta"+"(FechaRealizacion, Problema, MedicinasRecetadas, IDDoctor, IDExpediente)" +
        "VALUES ('" +
        pconsulta.getFechaRealizacion() + "', '" + 
        pconsulta.getProblema() + "', '" + 
        pconsulta.getMedicinasRecetadas() + "', '" + 
        pconsulta.getDoctor().getId() + "', '" + 
        pconsulta.getExpediente().getId() + "');";

    try{
      Conector.getConector().ejecutarSQL(sql);

    }catch(Exception e){
      throw new Exception (e.getMessage());
    }

  }

}
