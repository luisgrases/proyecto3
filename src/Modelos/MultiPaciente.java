package Modelos;

import CapaAccesoBD.Conector;

public class MultiPaciente {
	
	 public void crear(Paciente ppaciente)throws java.sql.SQLException,Exception{

		String sql = "INSERT INTO TPaciente "+
				"(Cedula, Nombre, Direccion, Telefono,FechaNacimiento,Edad) "+
				"VALUES ('"+ppaciente.getCedula()+"', '"+ppaciente.getNombre()+"', '"+ppaciente.getDireccion()+"', '"+ppaciente.getTelefono()+"', '"+ppaciente.getFechaNacimiento()+"', '"+ppaciente.getEdad()+"');";
				    
			try{
				Conector.getConector().ejecutarSQL(sql);
			
			}catch(Exception e){
				throw new Exception ("El paciente ya fue registrado. "+e);
			}

	 }
	 
	 public Paciente buscar(String pcedulaPaciente) throws 
	  java.sql.SQLException,Exception {
	    Paciente paciente = null;
	    java.sql.ResultSet resultSet;
	    String sql;
	    sql = "SELECT ID,Nombre,Direccion ,Telefono ,FechaNacimiento ,Edad "+
	        "FROM TPaciente "+
	        "WHERE Cedula ='"+ pcedulaPaciente +"';";

	    resultSet = Conector.getConector().ejecutarSQL(sql,true);
	    if (resultSet.next()) {
	   
	      paciente = new Paciente (
	      resultSet.getString("ID"),
	      resultSet.getString("Nombre"),
	      resultSet.getString("Direccion"),
	      resultSet.getString("Telefono"),
	      resultSet.getString("FechaNacimiento"),
	      resultSet.getInt("edad")
	      
	      );
	      
	      paciente.setId((resultSet.getString("ID")));
	      
	    } else { throw new Exception ("El paciente no existe.");}

	   
	    resultSet.close();
	    return paciente;

	  }
	 
	 public  void borrar(Paciente ppaciente)throws java.sql.SQLException,Exception{
			String sql;
			sql = "DELETE FROM TPaciente "+
			"WHERE ID='"+ppaciente.getId()+"';";
			try {
				Conector.getConector().ejecutarSQL(sql);
			}
			catch (Exception e) {
				throw new Exception ("El paciente no existe");
			}
		}

}
