package Modelos;

public class Consulta {

  private String id;
  private String fechaRealizacion;
  private String problema;
  private String MedicinasRecetadas;
  private Paciente paciente;
  private Doctor doctor;
  
  public Consulta(String pid, String pfechaRealizacion, String pproblema, String pmedicinasRecetadas, Paciente ppaciente, Doctor pdoctor) {
    setId(pid);
    setFechaRealizacion(pfechaRealizacion);
    setProblema(pproblema);
    setMedicinasRecetadas(pmedicinasRecetadas);
    setPaciente(ppaciente);
    setDoctor(pdoctor);
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
  public Paciente getPaciente() {
    return paciente;
  }
  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }
  public Doctor getDoctor() {
    return doctor;
  }
  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }
  
  
  
  
}
