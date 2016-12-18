package Modelos;

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
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getFechaRealizacion() {
    return fechaRealizacion;
  }
  
  public void setFechaRealizacion(String fechaRealizacion) {
    this.fechaRealizacion = fechaRealizacion;
  }
  
  public String getProblema() {
    return problema;
  }
  
  public void setProblema(String problema) {
    this.problema = problema;
  }
  
  public String getMedicinasRecetadas() {
    return MedicinasRecetadas;
  }
  
  public void setMedicinasRecetadas(String medicinasRecetadas) {
    MedicinasRecetadas = medicinasRecetadas;
  }
  
  public String getDoctor() {
    return idDoctor;
  }
  
  public void setDoctor(String pidDoctor) {
    this.idDoctor = pidDoctor;
  }
  

  public String getExpediente() {
    return idExpediente;
  }


  public void setExpediente(String pexpediente) {
    this.idExpediente = pexpediente;
  }

  @Override
  public String toString() {
    return getFechaRealizacion();
  }
  
  
  
  
  
}
