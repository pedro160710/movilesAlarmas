package adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ec.edu.epn.alarmas.R;
import vo.AlarmasVo;

/**
 * Created by Pedro on 24/05/2016.
 */
public class ArrayAdapterPersonal extends ArrayAdapter {
    private List<AlarmasVo> listadoAlarmas;

    public ArrayAdapterPersonal(Context context, List<AlarmasVo> objects) {
        super(context, 0, objects);
        listadoAlarmas = objects;
    }

    @Override
    public View getView(int posisicion, View view, ViewGroup padre) {
        if (view == null) {
            LayoutInflater inflador = LayoutInflater.from(getContext());
            view = inflador.inflate(R.layout.item_alarma, null);
        }
//        ya esta inflado el layout y ahora estamos agregando dos cajas de texto
        TextView titulo = (TextView) view.findViewById(R.id.lblTituloAlarma);
        TextView hora = (TextView) view.findViewById(R.id.lblHora);
//        ya sabemos que nos envian un objeto tipo AlarmasVo
        AlarmasVo alarma = listadoAlarmas.get(posisicion);
        titulo.setText(alarma.getTitulo());
        String horaConcat = alarma.getHora() + alarma.getMinuto() + " " + alarma.getTipoHorario();
        hora.setText(horaConcat);
        return (view);
    }
}
