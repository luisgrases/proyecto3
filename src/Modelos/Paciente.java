package Modelos;

public class Paciente {
  
  private String id;
  private String cedula;
  private String nombre;
  private String direccion;
  private String telefono;
  private String fechaNacimiento;
  private int edad;
  private Expediente expediente;
  
  public Paciente(String pid, String pcedula, String pnombre, String pdireccion, String ptelefono, String pfechaNacimiento,
      int pedad) {
    setId(pid);
    setCedula(pcedula);
    setNombre(pnombre);
    setDireccion(pdireccion);
    setTelefono(ptelefono);
    setFechaNacimiento(pfechaNacimiento);
    setEdad(pedad);
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCedula() {
    return cedula;
  }
  public void setCedula(String cedula) {
    this.cedula = cedula;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  
  

}
