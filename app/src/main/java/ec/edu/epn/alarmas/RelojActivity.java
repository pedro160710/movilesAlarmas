package ec.edu.epn.alarmas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RelojActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj);

        String valorStringRecibido= getIntent().getStringExtra("String1");
        Boolean valorBooleanRecibido= getIntent().getBooleanExtra("boolean1",false);//me pide que declare un boolean por defecto
        System.out.println(valorStringRecibido);
        Toast toast = Toast.makeText(this,valorStringRecibido,Toast.LENGTH_SHORT);
        toast.show();
    }
}
//adaptadores son mecanismos para incluir informacion dentro de Spinner o LstView
//existen adaptadores pre existentes o customizaos