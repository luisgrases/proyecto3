package Modelos;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
      String pcedulaPaciente,
      String pdireccionPaciente,
      String pfechaNacimientoPaciente,
      String ptelefonoPaciente,
      String pedadPaciente
      ) {
	  
	  
    setId(pid);
    setFechaApertura(pfechaApertura);
    setNombrePaciente(pnombrePaciente);
    setCedulaPaciente(pcedulaPaciente);
    setDireccionPaciente(pdireccionPaciente);
    setFechaNacimientoPaciente(pfechaNacimientoPaciente);
    setTelefonoPaciente(ptelefonoPaciente);
    
  }
  
  public Expediente(
      String pfechaApertura,
      String pnombrePaciente,
      String pdireccionPaciente,
      String pfechaNacimientoPaciente,
      String ptelefonoPaciente,
      String pcedulaPaciente
      ) {
    setFechaApertura(pfechaApertura);
    setNombrePaciente(pnombrePaciente);
    setDireccionPaciente(pdireccionPaciente);
    setFechaNacimientoPaciente(pfechaNacimientoPaciente);
    setTelefonoPaciente(ptelefonoPaciente);
    setCedulaPaciente(pcedulaPaciente);
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
  
  public Vector<Consulta> getConsultas() throws SQLException, Exception {
    if (consultas == null) {
      setConsultas(new MultiConsulta().buscarConsultasPorExpediente(id));
    }
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
    
    
    int edad = calcularEdad(fechaNacimientoPaciente);
    
    setEdadPaciente(edad);
    
  }

  private int calcularEdad(String pfechaNacimientoPaciente) {
	
	  Date fechaNac=null;
	  
	  try {
        
		  fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(pfechaNacimientoPaciente);
      } catch (Exception ex) {
          System.out.println("Error:"+ex);
      }
      Calendar fechaNacimiento = Calendar.getInstance();
     
      Calendar fechaActual = Calendar.getInstance();
      
      fechaNacimiento.setTime(fechaNac);
      
      int ano = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
      int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
      int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
      
      if(mes<0 || (mes==0 && dia<0)){
          ano--;
      }
      
      return ano;
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
    this.edadPaciente=edadPaciente;
  }

  @Override
  public String toString() {
    return getNombrePaciente();
  }
  
  
  
 

}
