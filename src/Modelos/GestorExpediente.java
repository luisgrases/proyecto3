package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.commons.lang.Validate;

public class GestorExpediente {


  public void registrar(String pfechaApertura,String pcedulaPaciente,String
      pnombrePaciente,String pdireccionPaciente,String ptelefonoPaciente,String pfechaNacimientoPaciente) throws SQLException, Exception {
    Expediente expediente= new Expediente(pfechaApertura,pnombrePaciente,pdireccionPaciente,pfechaNacimientoPaciente,ptelefonoPaciente,pcedulaPaciente);
    new MultiExpediente().crear(expediente);
  }
  
  public Vector<TreeMap> listarConsultas(String pnumExpediente) throws SQLException, Exception {
    Vector<Consulta> consultas = (new MultiExpediente()).buscarExpedientePaciente(pnumExpediente).getConsultas();
    Vector<TreeMap> datosConsultas = new Vector<TreeMap>();
    for (Consulta consulta : consultas) {
      Vector<TreeMap> datosConsulta = new Vector<TreeMap>();
    }
    return datosConsultas;
  }

  public TreeMap buscarCedulaPaciente(String pcedula) throws SQLException, Exception {
    TreeMap datos = null;
    Expediente ex = null;
    String nombre;
    datos = new TreeMap();
    ex = (new MultiExpediente()).buscarCedulaPaciente(pcedula);
    datos.put("ID", ex.getId());
    datos.put("FechaApertura", ex.getFechaApertura());
    datos.put("Cedula", ex.getCedulaPaciente());
    datos.put("NombrePaciente", ex.getNombrePaciente());
    datos.put("DireccionPaciente", ex.getDireccionPaciente());
    datos.put("TelefonoPaciente", ex.getTelefonoPaciente());
    datos.put("FechaNacimiento", ex.getFechaNacimientoPaciente());
    datos.put("Edad", ex.getEdadPaciente());

    return datos;

  }

  public TreeMap buscarExpedientePaciente(String numeroExpediente) throws SQLException, Exception {
    TreeMap datos = null;
    String nombre;
    datos = new TreeMap();
    Expediente expediente = (new MultiExpediente()).buscarExpedientePaciente(numeroExpediente);
    datos.put("ID", expediente.getId());
    datos.put("FechaApertura", expediente.getFechaApertura());
    datos.put("Cedula", expediente.getCedulaPaciente());
    datos.put("NombrePaciente", expediente.getNombrePaciente());
    datos.put("DireccionPaciente", expediente.getDireccionPaciente());
    datos.put("TelefonoPaciente", expediente.getTelefonoPaciente());
    datos.put("FechaNacimiento", expediente.getFechaNacimientoPaciente());
    datos.put("Edad", expediente.getEdadPaciente());
    return datos;

  }

  public Vector<TreeMap> listar() throws Exception {
    Vector<Expediente> expedientes = null;
    Vector datosExpedientes = null;
    expedientes = (new MultiExpediente()).buscarTodos();
    datosExpedientes = new Vector();
    for (Expediente expediente : expedientes) {
      TreeMap datosExpediente = new TreeMap();
      datosExpediente.put("nombre", expediente.getNombrePaciente());
      datosExpediente.put("identificacion", expediente.getId());
      datosExpedientes.add(datosExpediente);
    }
    return datosExpedientes;
  }


}
