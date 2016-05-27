package ec.edu.epn.alarmas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CrearAlarmaActivity extends AppCompatActivity {
    private String tipoHorario[];
    private Spinner cmbTipoHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_alarma);
        cmbTipoHorario = (Spinner) findViewById(R.id.cmbTipoHorario);
        tipoHorario = new String[]{"AM", "PM"};
        ArrayAdapter<String> adaptador  = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoHorario);
        cmbTipoHorario.setAdapter(adaptador);
    }
    //crear tres elementos
}
