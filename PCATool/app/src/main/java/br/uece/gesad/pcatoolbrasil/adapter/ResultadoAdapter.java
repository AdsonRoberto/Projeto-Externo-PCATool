package br.uece.gesad.pcatoolbrasil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.domain.Resultado;

import java.util.ArrayList;

/**
 * Created by Messias on 22/05/2017.
 */

public class ResultadoAdapter extends ArrayAdapter<Resultado> {

    Context context;
    ArrayList<Resultado> elementos;

    public ResultadoAdapter(Context context, ArrayList<Resultado> elementos) {
        super(context, R.layout.linha_list_resultados, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_list_resultados, parent, false);

        TextView txtColuna1 = (TextView) rowView.findViewById(R.id.txtColuna1);
        TextView txtColuna2 = (TextView) rowView.findViewById(R.id.txtColuna2);

        txtColuna1.setText(elementos.get(position).getDescricaoColuna1());
        txtColuna2.setText(elementos.get(position).getMediaColuna2());

        return rowView;
    }
}
