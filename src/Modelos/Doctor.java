package Modelos;

import javax.swing.JOptionPane;

import org.apache.commons.lang.Validate;

public class Doctor {
  
  private String id;
  private String nombre;
  private String especialidad;
  private String telefono;
  
  
  public Doctor(String pid, String pnombre, String pespecialidad, String ptelefono)throws Exception  {
    setId(pid);
    setNombre(pnombre);
    setEspecialidad(pespecialidad);
    setTelefono(ptelefono);
  }
  
  public Doctor(String pnombre, String pespecialidad, String ptelefono)throws Exception  {
    setNombre(pnombre);
    setEspecialidad(pespecialidad);
    setTelefono(ptelefono);
  }
  
  public String getId() {
    return id;
  }
  public void setId(String pid)throws Exception {
    Validate.notEmpty(pid);
    this.id = pid;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String pnombre)throws Exception{
	  
    Validate.notEmpty(pnombre);
    this.nombre = pnombre;
  }
  public String getEspecialidad() {
    return especialidad;
  }
  public void setEspecialidad(String pespecialidad)throws Exception {
    Validate.notEmpty(pespecialidad);
    this.especialidad = pespecialidad;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String ptelefono)throws Exception {
    Validate.notEmpty(ptelefono);
    this.telefono = ptelefono;
  }
  
  @Override
  public String toString() {
    return nombre;
  }
  
  

}
