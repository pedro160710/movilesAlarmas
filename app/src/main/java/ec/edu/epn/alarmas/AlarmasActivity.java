package ec.edu.epn.alarmas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adaptador.AlarmasAdapter;
import ec.edu.epn.alarmas.sqlite.TimeControlAppContract;
import ec.edu.epn.alarmas.sqlite.TimeControlAppOpenHelper;
import vo.AlarmaVO;
import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma;

public class AlarmasActivity extends AppCompatActivity {
private ListView lvActividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmas);
        List<AlarmaVO> alarmas = new ArrayList<AlarmaVO>();
        //String tipoHorario, int minuto, int hora, String titulo
       /* AlarmaVO alarma = new AlarmaVO("PM",12,1,"Novela",true);
        alarmas.add(alarma);
        AlarmaVO alarma1 = new AlarmaVO("AM",8,1,"Deber",false);
        alarmas.add(alarma1);*/
        TimeControlAppOpenHelper oh = new TimeControlAppOpenHelper(getApplicationContext());

        SQLiteDatabase db = oh.getReadableDatabase();
        String [] columnas ={TablaAlarma.COLUMNA_TITULO,
        TablaAlarma.COLUMNA_HORA,
        TablaAlarma.COLUMNA_MINUTOS,
        TablaAlarma.COLUMNA_TIPO_HORARIO,
        TablaAlarma.COLUMNA_ACTIVADO};
        Cursor cur = db.query(TablaAlarma.NOMBRE_TABLA,
                                columnas,
                                null,
                                null,
                                null,
                                null,
                                null
                                        );
   while (cur.moveToNext()){
       AlarmaVO al = new AlarmaVO();
       String titulo = cur.getString(0);
       al.setTitulo(titulo);
       al.setHora(cur.getInt(1));
       al.setMinuto(cur.getInt(2));
       al.setTipoHorario(cur.getString(3));
       al.setEstado(cur.getString(4));
       alarmas.add(al);


   }

        lvActividades=(ListView)findViewById(R.id.lvAlarmas);
        AlarmasAdapter adaptador = new AlarmasAdapter(this,alarmas);
        lvActividades.setAdapter(adaptador);
    }

    public void abrirCrearAlarmas(View view)
    {
        Intent i = new Intent(this,CrearAlarmaActivity.class);
        startActivity(i);
    }

     public void  cambiarEstado(View view)
    {
        Button btnEstado = (Button)view;

        if(btnEstado.getText().equals("Activo"))
        {

            btnEstado.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.alarma_inactiva,0);
            btnEstado.setText("Inactivo");

        }else {
            btnEstado.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.alarm_active,0);
            btnEstado.setText("Activo");

        }
    }
}
