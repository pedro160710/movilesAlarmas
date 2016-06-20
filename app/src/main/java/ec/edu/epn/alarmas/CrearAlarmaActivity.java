package ec.edu.epn.alarmas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import ec.edu.epn.alarmas.sqlite.TimeControlAppContract;
import ec.edu.epn.alarmas.sqlite.TimeControlAppOpenHelper;

import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma.COLUMNA_ACTIVADO;
import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma.COLUMNA_HORA;
import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma.COLUMNA_MINUTOS;
import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma.COLUMNA_TIPO_HORARIO;
import static ec.edu.epn.alarmas.sqlite.TimeControlAppContract.TablaAlarma.COLUMNA_TITULO;

public class CrearAlarmaActivity extends AppCompatActivity {
    //
    private Spinner cmbTipoHorario;
    private EditText txtTitulo;
    private EditText txtHoraMinutos;
    private ToggleButton btnActivado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_alarma);

        cmbTipoHorario=(Spinner)findViewById(R.id.cmbTipoHorario);
        txtTitulo=(EditText)findViewById(R.id.txtTituloAlarma);
        txtHoraMinutos=(EditText)findViewById(R.id.txtHoraMinutos);
        btnActivado=(ToggleButton)findViewById(R.id.btnActivada);

        /*Creacion de los datos*/

        String [] tiposHorarios={"AM","PM"};
        /*Creacion del adaotador*/
        ArrayAdapter<String>adaptadortiposHorarios=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
                tiposHorarios);

        cmbTipoHorario.setAdapter(adaptadortiposHorarios);

    }
    public void crearAlarma(View view){

        //validacion para que el titulo este cargado
        if(txtTitulo.getText().toString().isEmpty())
        {
            String error=getResources().getString(R.string.errorRequerido);
            String campoTitulo=getResources().getString(R.string.tlAlarma);
            txtTitulo.setError(campoTitulo + " "+ error);
            Toast.makeText(this,campoTitulo + " "+ error,Toast.LENGTH_LONG).show();
            return;
        }
        else{
            TimeControlAppOpenHelper op = new TimeControlAppOpenHelper(getApplicationContext());
            //verifica si hay base de datos, si no exsite crea la base de datos.
            SQLiteDatabase db = op.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(COLUMNA_TITULO,txtTitulo.getText().toString());
            String hh= txtHoraMinutos.getText().toString();
            valores.put(COLUMNA_HORA,hh.substring(0,1));
            valores.put(COLUMNA_MINUTOS,hh.substring(3));
            String tipHorario= cmbTipoHorario.getSelectedItem().toString();
            valores.put(COLUMNA_TIPO_HORARIO,tipHorario);
            valores.put(COLUMNA_ACTIVADO,btnActivado.getText().toString());
            db.insert(TimeControlAppContract.TablaAlarma.NOMBRE_TABLA,null,valores);
            db.close();
            Log.v("hola",hh.substring(3));
        }



    }

}
