package adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
//            aqui busca al objeto tipo item y le añade al inflador.
            view = inflador.inflate(R.layout.item_alarma, null);
        }
//        ya esta inflado el layout y ahora estamos agregando dos cajas de texto
//        busca dentro del inflador a los objetos de la interfaz
        TextView titulo = (TextView) view.findViewById(R.id.lblTituloAlarma);//esto nos retorna un objeto tipo View
        TextView hora = (TextView) view.findViewById(R.id.lblHora);
        Button botonActiveInactive =(Button) view.findViewById(R.id.btnActiveInactive);
//        ya sabemos que nos envian un objeto tipo AlarmasVo
        AlarmasVo alarma = listadoAlarmas.get(posisicion);
        titulo.setText(alarma.getTitulo());
        hora.setText(alarma.getHora() + alarma.getMinuto() + " " + alarma.getTipoHorario());
        botonActiveInactive.setText("Activo");
        botonActiveInactive.setCompoundDrawablesWithIntrinsicBounds(0 , 0, R.drawable.ic_action_name, 0);
        return (view);
    }
}
