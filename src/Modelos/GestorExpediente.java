package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.commons.lang.Validate;

public class GestorExpediente {
  Expediente expedienteSeleccionado;

  public void registrar(String pfechaApertura,String pcedulaPaciente,String
      pnombrePaciente,String pdireccionPaciente,String ptelefonoPaciente,String pfechaNacimientoPaciente) throws SQLException, Exception {
    Expediente expediente= new Expediente(pfechaApertura,pnombrePaciente,pdireccionPaciente,pfechaNacimientoPaciente,ptelefonoPaciente,pcedulaPaciente);
    new MultiExpediente().crear(expediente);
  }
  
  public Vector<String> listarConsultas(String pnumExpediente) throws SQLException, Exception {
    expedienteSeleccionado = (new MultiExpediente()).buscarExpedientePaciente(pnumExpediente);
    Vector<Consulta> consultas = expedienteSeleccionado.getConsultas();
    Vector<String> fechasConsultas = new Vector<String>();
    for (Consulta consulta : consultas) {
      fechasConsultas.add(consulta.getFechaRealizacion());
    }
    return fechasConsultas;
  }
  
  public TreeMap getConsultaPorFecha(String fecha) throws SQLException, Exception {
    Consulta consulta = expedienteSeleccionado.getConsultaPorFecha(fecha);
    JOptionPane.showMessageDialog(null,consulta.getDoctor());
    TreeMap datosConsulta = new TreeMap();
    datosConsulta.put("id", consulta.getId());
    datosConsulta.put("doctor", consulta.getDoctor());
    datosConsulta.put("fecha", consulta.getFechaRealizacion());
    datosConsulta.put("problema", consulta.getProblema());
    datosConsulta.put("medicinasRecetadas", consulta.getMedicinasRecetadas());
    return datosConsulta;
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
