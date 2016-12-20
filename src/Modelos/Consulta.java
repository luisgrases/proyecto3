package Modelos;

import java.sql.SQLException;

import org.apache.commons.lang.Validate;

public class Consulta {

  private String id;
  private String fechaRealizacion;
  private String problema;
  private String MedicinasRecetadas;
  private Doctor doctor;
  private Expediente expediente;
  
  public Consulta(
      String pid,
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas
      
      )throws Exception   {
    setId(pid);
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
   
  }
  
 
  
  public Consulta(
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas,
      Doctor pdoctor,
      Expediente pexpediente
      )throws Exception   {
	  
	
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
    setDoctor(pdoctor);
    setExpediente(pexpediente);
  }
  
  
  public String getId() {
    return id;
  }
  
  public void setId(String id){
	  
	  Validate.notEmpty(this.id = id);
	  
  }
  
  public String getFechaRealizacion() {
    return fechaRealizacion;
  }
  
  public void setFechaRealizacion(String fechaRealizacion) {
    Validate.notEmpty(this.fechaRealizacion = fechaRealizacion);
  }
  
  public String getProblema() {
    return problema;
  }
  
  public void setProblema(String problema) {
    Validate.notEmpty(this.problema = problema);
  }
  
  public String getMedicinasRecetadas() {
    return MedicinasRecetadas;
  }
  
  public void setMedicinasRecetadas(String medicinasRecetadas) {
    Validate.notEmpty(MedicinasRecetadas = medicinasRecetadas);
  }
  
  public Doctor getDoctor() throws SQLException, Exception {
	  
	  if (doctor == null) {
		  
	    setDoctor((new MultiConsulta()).DbuscarPorConsulta(id));
	    
	  }
	  return doctor;
  }
  
  public void setDoctor(Doctor pdoctor) {
   
    this.doctor = pdoctor;
  }
  

  public Expediente getExpediente() throws SQLException, Exception {
	  
	  if (expediente == null) {
		  
		  setExpediente((new MultiConsulta()).EbuscarPorConsulta(id));
		    
	  }
	  
	  return expediente;
  }


  public void setExpediente(Expediente pexpediente) {
    
    this.expediente = pexpediente;
  }

  @Override
public String toString() {
	return "Consulta [id=" + id + ", fechaRealizacion=" + fechaRealizacion + ", problema=" + problema
			+ ", MedicinasRecetadas=" + MedicinasRecetadas + ", idDoctor=" + doctor + ", idExpediente=" + expediente
			+ "]";
}
  
  
  
  
  
}
