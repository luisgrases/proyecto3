package Modelos;

import java.sql.SQLException;
import java.util.TreeMap;

public class GestorPaciente {

	/*public TreeMap buscar(String pid) throws Exception {

		TreeMap datos = null;
		Cuadro cuadro = null;
		
		datos = new TreeMap();
		cuadro = (new MultiPaciente()).buscar(pid);
		System.out.println(cuadro.getCondicionActual());
		datos.put("nombre", cuadro.getNombre());
		datos.put("id", cuadro.getId());
		datos.put("base", cuadro.getDimensiones()[0]);
		datos.put("altura", cuadro.getDimensiones()[1]);
		datos.put("fechaPintado", cuadro.getFechaCreacion());
		datos.put("fechaRegistro", cuadro.getFechaRegistro());
		datos.put("tecnica", cuadro.getTecnica());
		datos.put("condicionRegistro", cuadro.getCondicionRegistro());
		datos.put("condicionActual", cuadro.getCondicionActual());
		datos.put("costo", cuadro.getCosto());
		datos.put("idPintor", cuadro.getPintor().getId());
		datos.put("idPinacoteca", cuadro.getPinacoteca().getId());

		return datos;
	}*/

	public void agregar(Paciente ppaciente) throws SQLException, Exception {

		(new MultiPaciente()).crear(ppaciente);
	}

	/*public void modificar(Cuadro cuadro, String idPintor, String idPinacoteca) throws Exception {
		(new MultiPintor()).buscar(idPintor);
		(new MultiPinacoteca()).buscar(idPinacoteca);
		(new MultiCuadro()).actualizar(cuadro, idPintor, idPinacoteca);
	}
*/
	public void borrar(String pidPaciente) throws Exception {
		Paciente paciente = (new MultiPaciente()).buscar(pidPaciente);
		(new MultiPaciente()).borrar(paciente);
	}

}
