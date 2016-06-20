package ec.edu.epn.alarmas.sqlite;

import android.provider.BaseColumns;

/**
 * Created by Christian on 30/5/2016.
 */
public class TimeControlAppContract {
    public static  abstract class TablaAlarma implements BaseColumns{
        public static  final String NOMBRE_TABLA="ALARMA";
        public static  final String COLUMNA_TITULO="TITULO";
        public static  final String COLUMNA_HORA="HORA";
        public static  final String COLUMNA_MINUTOS="MINUTOS";
        public static  final String COLUMNA_TIPO_HORARIO="TIPO_HORARIO";
        public static  final String COLUMNA_ACTIVADO="ACTIVADO";
    }
    private static final  String TEXT_TYPE="\tTEXT ";
    private static final  String INTEGER_TYPE="\tINTEGER";
    private static final  String COMA_SEPARADOR=",";
    public static final String ELIMINA_TABLAS = "DROP TABLE IF EXISTS " + TablaAlarma.NOMBRE_TABLA;
    public static final String CREAR_TABLA ="CREATE TABLE\t"+ TablaAlarma.NOMBRE_TABLA+"("
            +TablaAlarma._ID+" "+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
            TablaAlarma.COLUMNA_TITULO + TEXT_TYPE+COMA_SEPARADOR+
            TablaAlarma.COLUMNA_HORA+ INTEGER_TYPE+COMA_SEPARADOR+
            TablaAlarma.COLUMNA_MINUTOS+INTEGER_TYPE+COMA_SEPARADOR+
            TablaAlarma.COLUMNA_TIPO_HORARIO+TEXT_TYPE+COMA_SEPARADOR+
            TablaAlarma.COLUMNA_ACTIVADO+TEXT_TYPE+")";

}
