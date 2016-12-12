package Modelos;

import java.sql.*;
import java.io.*;
import java.util.*;
import CapaAccesoBD.Conector;

public class MultiDoctor {
  
  


  public void crear(Doctor pdoctor)throws java.sql.SQLException,Exception{

    String sql = "INSERT INTO TDoctor"+"(ID,Nombre,Especialidad,Telefono)" +
        "VALUES ('"+pdoctor.getId()+"', '"+pdoctor.getNombre()+"', '"+pdoctor.getEspecialidad()+"','"+pdoctor.getTelefono()+"');";

    try{
      Conector.getConector().ejecutarSQL(sql);

    }catch(Exception e){
      throw new Exception ("No se ha podido registrar el doctor. "+e);
    }

  }

  public Vector<Doctor> buscarTodos()throws java.sql.SQLException,Exception{

    Vector<Doctor> doctores = new Vector();

    java.sql.ResultSet rs;
    String sql;
    sql = "SELECT * " +
        "FROM TDoctor ; ";
    rs = Conector.getConector().ejecutarSQL(sql,true);

    if(rs.next()){
      do {
        Doctor doctor = new Doctor (rs.getString("ID"), rs.getString("Nombre"), rs.getString("Especialidad"), rs.getString("Telefono") );
        doctores.add(doctor);
      } while (rs.next());
    }else{
      throw new Exception ("No se encuentras doctores registrados");

    }
    rs.close();
    return doctores;

  }


}