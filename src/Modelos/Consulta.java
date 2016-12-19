package Modelos;

import org.apache.commons.lang.Validate;

public class Consulta {

  private String id;
  private String fechaRealizacion;
  private String problema;
  private String MedicinasRecetadas;
  private String idDoctor;
  private String idExpediente;
  
  public Consulta(
      String pid,
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas,
      String pidDoctor,
      String pidExpediente
      ) {
    setId(pid);
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
    setDoctor(pidDoctor);
    setExpediente(pidExpediente);
  }
  
  public Consulta(
      String pid,
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas
      ) {
    setId(pid);
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
  }
  
  public Consulta(
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas,
      String pdoctor,
      String pexpediente
      ) {
	  
	
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
  
  public String getDoctor() {
    return idDoctor;
  }
  
  public void setDoctor(String pidDoctor) {
    Validate.notEmpty(this.idDoctor = pidDoctor);
  }
  

  public String getExpediente() {
    return idExpediente;
  }


  public void setExpediente(String pexpediente) {
    Validate.notEmpty(this.idExpediente = pexpediente);
  }

  @Override
  public String toString() {
    return getFechaRealizacion();
  }
  
  
  
  
  
}
