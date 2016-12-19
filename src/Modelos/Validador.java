package Modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.Validate;

public class Validador {
  public static void ValidarFechaPosterior(String fechaAnterior, String fechaPosterior) throws Exception  {

      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date fecha1 = sdf.parse(fechaAnterior);
      Date fecha2 = sdf.parse(fechaPosterior);

      if(fecha1.after(fecha2)){
        throw new Exception(fechaAnterior + " no puede ser posterior a " + fechaPosterior);
      }
  }


  private static void validarFormatoFecha(String fechaAValidar) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);

    try {

      //if not valid, it will throw ParseException
      Date date = sdf.parse(fechaAValidar);
      System.out.println(date);

    } catch (ParseException e) {

      throw new Exception(fechaAValidar + " tiene un formato invalido.");
    }
  }


  public static void validarFormatoFechas(String[] fechas) throws Exception {
    for (String fecha : fechas) {
      validarFormatoFecha(fecha);
    }
  }

}
