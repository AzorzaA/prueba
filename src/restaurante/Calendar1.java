/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Angel A
 */
public class Calendar1 {

    //Calendar fech = new GregorianCalendar();
    //  String anio = Integer.toString(fech.get(Calendar.this));
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatoFecha.format(fecha);
    }

}
