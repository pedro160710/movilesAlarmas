package adaptador;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

import ec.edu.epn.alarmas.R;
import vo.AlarmaVO;

/**
 * Created by Christian on 24/5/2016.
 */
public class AlarmasAdapter extends ArrayAdapter {
    private List<AlarmaVO> listadoAlarmas;
    public AlarmasAdapter(Context context, List<AlarmaVO> objects ) {

        super(context,0, objects);
        listadoAlarmas=objects;
    }
  @Override
    public View getView(int posicion, View view, ViewGroup padre){
      if(view==null)
      {
          LayoutInflater inflador = LayoutInflater.from(getContext());
              view= inflador.inflate(R.layout.item_alarma,null);
      }

      TextView titulo = (TextView)view.findViewById(R.id.lblTituloalarma);
      TextView hora = (TextView)view.findViewById(R.id.lblHora);
      TextView estado = (TextView)view.findViewById(R.id.lblEstado);
      Button btnEstado = (Button)view.findViewById(R.id.btbActivo);
      AlarmaVO alarma = listadoAlarmas.get(posicion);
      titulo.setText(alarma.getTitulo());
      String horaConcat = alarma.getHora()+":"+alarma.getMinuto()+" "+alarma.getTipoHorario();
      if(alarma.getEstado().equals("Si"))
      {
          hora.setText(horaConcat);
          btnEstado.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.alarm_active,0);
          btnEstado.setText("Activo");

      }else {
          hora.setText(horaConcat);
          btnEstado.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.alarma_inactiva,0);
          btnEstado.setText("Inactivo");
      }
      return view;
  }
}
