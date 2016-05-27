package ec.edu.epn.alarmas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adaptadores.AlarmasAdapter;
import vo.AlarmasVo;

public class AlarmasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmas);

        ListView lvAlarmas = (ListView) findViewById(R.id.lvAlarmas);

        List<AlarmasVo> alarmas = new ArrayList<AlarmasVo>();


        AlarmasVo alarma1 = new AlarmasVo("examen",6, 00, "PM");
        alarmas.add(alarma1);
        AlarmasVo alarma2 = new AlarmasVo("novela",7, 00, "PM");
        alarmas.add(alarma2);

        AlarmasAdapter adaptador = new AlarmasAdapter(this,alarmas);
        lvAlarmas.setAdapter(adaptador);
    }

    public void abrirCrearAlarma(View v) {
        Intent instIntent = new Intent(this, CrearAlarmaActivity.class);
        startActivity(instIntent);
    }
//if(item== null){
    //LayoutInflater inflater = LayoutInflater.from(getBaseContext());
    //item.inflater.inflate(R.layout.listem_discos,null);
//}
}
