package Modelos;

import org.apache.commons.lang.Validate;

public class Doctor {
  
  private String id;
  private String nombre;
  private String especialidad;
  private String telefono;
  
  
  public Doctor(String pid, String pnombre, String pespecialidad, String ptelefono) {
    id = pid;
    nombre = pnombre;
    especialidad = pespecialidad;
    telefono = ptelefono;
  }
  
  public Doctor(String pnombre, String pespecialidad, String ptelefono) {
    nombre = pnombre;
    especialidad = pespecialidad;
    telefono = ptelefono;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    Validate.notEmpty(this.id = id);
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    Validate.notEmpty(this.nombre = nombre);
  }
  public String getEspecialidad() {
    return especialidad;
  }
  public void setEspecialidad(String especialidad) {
    Validate.notEmpty(this.especialidad = especialidad);
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    Validate.notEmpty(this.telefono = telefono);
  }
  
  @Override
  public String toString() {
    return nombre;
  }
  
  

}
