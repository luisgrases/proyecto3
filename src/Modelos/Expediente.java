package Modelos;

import java.util.Vector;

public class Expediente {
  
  private String id;
  private String fechaApertura;
  private String nombrePaciente;
  private String direccionPaciente;
  private String fechaNacimientoPaciente;
  private String telefonoPaciente;
  private String cedulaPaciente;
  private int edadPaciente;
  Vector<Consulta> consultas;
  
  public Expediente(
      String pid,
      String pfechaApertura,
      String pnombrePaciente,
      String pdireccionPaciente,
      String pfechaNacimientoPaciente,
      String ptelefonoPaciente,
      String pcedulaPaciente,
      int pedadPaciente) {
    setId(pid);
    setFechaApertura(pfechaApertura);
    setNombrePaciente(pnombrePaciente);
    setDireccionPaciente(pdireccionPaciente);
    setFechaNacimientoPaciente(pfechaNacimientoPaciente);
    setTelefonoPaciente(ptelefonoPaciente);
    setCedulaPaciente(pcedulaPaciente);
    setEdadPaciente(pedadPaciente);
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getFechaApertura() {
    return fechaApertura;
  }
  
  public void setFechaApertura(String fechaApertura) {
    this.fechaApertura = fechaApertura;
  }
  
  public Vector<Consulta> getConsultas() {
    return consultas;
  }
  
  public void setConsultas(Vector<Consulta> consultas) {
    this.consultas = consultas;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }
  
  public String getNombrePaciente() {
   return nombrePaciente;
  }


  public String getDireccionPaciente() {
    return direccionPaciente;
  }


  public void setDireccionPaciente(String direccionPaciente) {
    this.direccionPaciente = direccionPaciente;
  }


  public String getFechaNacimientoPaciente() {
    return fechaNacimientoPaciente;
  }


  public void setFechaNacimientoPaciente(String fechaNacimientoPaciente) {
    this.fechaNacimientoPaciente = fechaNacimientoPaciente;
  }

  public String getTelefonoPaciente() {
    return telefonoPaciente;
  }


  public void setTelefonoPaciente(String telefonoPaciente) {
    this.telefonoPaciente = telefonoPaciente;
  }


  public String getCedulaPaciente() {
    return cedulaPaciente;
  }


  public void setCedulaPaciente(String cedulaPaciente) {
    this.cedulaPaciente = cedulaPaciente;
  }


  public int getEdadPaciente() {
    return edadPaciente;
  }


  public void setEdadPaciente(int edadPaciente) {
    this.edadPaciente = edadPaciente;
  }

  @Override
  public String toString() {
    return id;
  }
  
  
  
 

}
