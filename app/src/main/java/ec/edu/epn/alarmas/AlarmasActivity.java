package ec.edu.epn.alarmas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adaptadores.ArrayAdapterPersonal;
import vo.AlarmasVo;

public class AlarmasActivity extends AppCompatActivity {
    private ListView lvAlarmas;
    private List<AlarmasVo> alarmas;
    private ArrayAdapterPersonal adaptadorPersonalizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmas);

        lvAlarmas = (ListView) findViewById(R.id.lvAlarmas);
        alarmas = new ArrayList<AlarmasVo>();

        AlarmasVo alarma1 = new AlarmasVo("examen",6, 00, "PM");
        alarmas.add(alarma1);
        AlarmasVo alarma2 = new AlarmasVo("novela",7, 00, "PM");
        alarmas.add(alarma2);

        adaptadorPersonalizado = new ArrayAdapterPersonal(this,alarmas);
        lvAlarmas.setAdapter(adaptadorPersonalizado);
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