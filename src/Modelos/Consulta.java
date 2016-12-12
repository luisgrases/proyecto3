package Modelos;

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
      String pmedicinasRecetadas,
      Doctor pdoctor,
      Expediente pexpediente
      ) {
    setId(pid);
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
    setDoctor(pdoctor);
    setExpediente(pexpediente);
  }
  
  public Consulta(
      String pfechaRealizacion,
      String pproblema,
      String pmedicinasRecetadas,
      Doctor pdoctor,
      Expediente pexpediente
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
  
  public Doctor getDoctor() {
    return doctor;
  }
  
  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }
  

  public Expediente getExpediente() {
    return expediente;
  }


  public void setExpediente(Expediente expediente) {
    this.expediente = expediente;
  }
  
  
  
  
}
