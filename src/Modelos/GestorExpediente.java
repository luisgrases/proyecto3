package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.commons.lang.Validate;

public class GestorExpediente {
  
	
	
  public Vector<Expediente> listar() throws SQLException, Exception {
    return (new MultiExpediente()).buscarTodos();
  }
  
  public void registrar(String pfechaApertura,String pcedulaPaciente,String
		  pnombrePaciente,String pdireccionPaciente,String ptelefonoPaciente,String pfechaNacimientoPaciente) throws SQLException, Exception {
	  
	 
	  
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
		Expediente ex=null;
		String nombre;
		datos = new TreeMap();
		ex = (new MultiExpediente()).buscarExpedientePaciente(numeroExpediente);
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
  
  public Vector obtenerExpedientes() throws Exception {
		Vector expedientes=null;
		Vector datosExpedientes=null;
		Expediente expediente;
		expedientes = (new MultiExpediente()).buscarTodos();
		datosExpedientes = new Vector();
		for (int i=0; i<expedientes.size(); i++) {
			expediente = ((Expediente) expedientes.get(i));
			TreeMap datosExpediente = new TreeMap();
			datosExpediente.put("nombre", expediente.getNombrePaciente());
			datosExpediente.put("identificacion", expediente.getId());
			datosExpedientes.add(datosExpediente);
		}
		return datosExpedientes;
	}
  
  
}
