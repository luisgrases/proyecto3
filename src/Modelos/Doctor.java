package Modelos;

public class Doctor {
  
  private String id;
  private String nombre;
  private String especialidad;
  private String telefono;
  // Davidsito me la chupa
  
  public Doctor(String pid, String pnombre, String pespecialidad, String ptelefono) {
    id = pid;
    nombre = pnombre;
    especialidad = pespecialidad;
    telefono = ptelefono;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getEspecialidad() {
    return especialidad;
  }
  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  

}
