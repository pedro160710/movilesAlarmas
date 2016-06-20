package ec.edu.epn.alarmas;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MenuOpciones extends AppCompatActivity {
    private Button btnCronometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        /*llamada a cronometros*/
        btnCronometro= (Button)findViewById(R.id.btnCronometro);
        btnCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuOpciones.this, CronometroActivity.class);
                startActivity(i);
            }
        });
    }
    public void abrirReloj(View view)
    {
        //llamar a otras ventanas
        Intent i = new Intent(this,RelojActivity.class);
        startActivity(i);
    }
    public void abrirAlarmas(View view)
    {
        //llamar a otras ventanas
        Intent i = new Intent(this,AlarmasActivity.class);
        startActivity(i);
    }



    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
