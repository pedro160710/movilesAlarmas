package ec.edu.epn.alarmas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpciones extends AppCompatActivity {
    private Intent instIntent;
    private Button btnCronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        btnCronometro = (Button) findViewById(R.id.btnCronometro);
        btnCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instIntent = new Intent(MenuOpciones.this, CronometroActivity.class);
                //              agregar siempre la clase especifica desde donde se envia, cuando estre dentro de una inner class
                startActivity(instIntent);
            }
        });
//        Log.v("CV", "on Create");
        String datos[] = new String[]{"uno", "dos"};
    }

//    IMPLEMENTAR LOS METODOS DEL CICLO DE VIDAD
    public void abrirReloj(View view) {
        instIntent = new Intent(this, RelojActivity.class);
        //muestro a la actividad Reloj
        instIntent.putExtra("boolean1", true);
        instIntent.putExtra("String1", "Esto es un string enviado desde MenuOpciones.java");
        //el primer parametro es el idetificador que se lo colocará en el segundo activity
        startActivity(instIntent);
    }

    public void abrirAlarmas(View v) {
        instIntent = new Intent(this, AlarmasActivity.class);
        startActivity(instIntent);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
//completar las otras dos activities
    //para el cronometro phacer con onClick listener
//        crear otra acividad; dentro de esta listar las alarmas
}
