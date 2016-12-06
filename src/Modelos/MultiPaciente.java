package Modelos;

import CapaAccesoBD.Conector;

public class MultiPaciente {
	
	 public void crear(Paciente ppaciente)throws java.sql.SQLException,Exception{

		String sql = "INSERT INTO TPaciente "+
				"(Cedula, Nombre, Direccion, Telefono,FechaNacimiento,Edad) "+
				"VALUES ('"+ppaciente.getCedula()+"', '"+ppaciente.getDireccion()+"', '"+ppaciente.getTelefono()+"', '"+ppaciente.getFechaNacimiento()+"', '"+ppaciente.getEdad()+"');";
				    
			try{
				Conector.getConector().ejecutarSQL(sql);
			
			}catch(Exception e){
				throw new Exception ("El paciente ya fue registrado. "+e);
			}

	 }

}
