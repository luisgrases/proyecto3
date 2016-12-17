package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

public class GestorExpediente {
  
  public Vector<Expediente> listar() throws SQLException, Exception {
    return (new MultiExpediente()).buscarTodos();
  }
  
  public void registrar(String pfechaApertura,String pcedulaPaciente,String pnombrePaciente,String pdireccionPaciente,String ptelefonoPaciente,String pfechaNacimientoPaciente) throws SQLException, Exception {
	  
	  Expediente ex= new Expediente(pfechaApertura,pnombrePaciente,pdireccionPaciente,pfechaNacimientoPaciente,ptelefonoPaciente,pcedulaPaciente);
	  
	  new MultiExpediente().crear(ex);
  
  }

  public TreeMap buscarCedulaPaciente(String pcedula) throws SQLException, Exception {
	
	  	TreeMap datos = null;
		Expediente ex=null;
		String nombre;
		datos = new TreeMap();
		ex = (new MultiExpediente()).buscarCedulaPaciente(pcedula);
		datos.put("ID", ex.getId());
		datos.put("FechaApertura", ex.getFechaApertura());
		datos.put("NombrePaciente", ex.getNombrePaciente());
		datos.put("DireccionPaciente", ex.getDireccionPaciente());
		datos.put("TelefonoPaciente", ex.getTelefonoPaciente());
		datos.put("FechaNacimiento", ex.getFechaNacimientoPaciente());
		datos.put("Edad", ex.getEdadPaciente());
		
		return datos;

  }

  public TreeMap buscarExpedientePaciente(String numeroExpediente) throws SQLException, Exception {
		
	  
	    TreeMap datos = null;
		Expediente ex=null;
		String nombre;
		datos = new TreeMap();
		ex = (new MultiExpediente()).buscarExpedientePaciente(numeroExpediente);
		datos.put("ID", ex.getId());
		datos.put("FechaApertura", ex.getFechaApertura());
		datos.put("NombrePaciente", ex.getNombrePaciente());
		datos.put("DireccionPaciente", ex.getDireccionPaciente());
		datos.put("TelefonoPaciente", ex.getTelefonoPaciente());
		datos.put("FechaNacimiento", ex.getFechaNacimientoPaciente());
		datos.put("Edad", ex.getEdadPaciente());
		
		return datos;

  }
  
  
}