package br.uece.gesad.pcatoolbrasil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.domain.Questionario;

import java.util.ArrayList;

/**
 * Created by Messias on 22/05/2017.
 */

public class QuestionarioAdapter extends ArrayAdapter<Questionario> {

    Context context;
    ArrayList<Questionario> elementos;

    public QuestionarioAdapter(Context context, ArrayList<Questionario> elementos) {
        super(context, R.layout.linha_list_questionarios, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_list_questionarios, parent, false);

        TextView txtId = (TextView) rowView.findViewById(R.id.txtId);
        TextView txtNome = (TextView) rowView.findViewById(R.id.txtNome);
        TextView txtRegional = (TextView) rowView.findViewById(R.id.txtRegional);
        TextView txtData = (TextView) rowView.findViewById(R.id.txtData);
        TextView txtTipo = (TextView) rowView.findViewById(R.id.txtTipo);
        TextView txtEscoreE = (TextView) rowView.findViewById(R.id.txtEscoreE);
        TextView txtEscoreG = (TextView) rowView.findViewById(R.id.txtEscoreG);

        txtId.setText(elementos.get(position).getId_questionario() + "");
        txtNome.setText(elementos.get(position).getEntrevistado().getNome());
        txtRegional.setText(elementos.get(position).getRegional().getNome());
        txtData.setText(elementos.get(position).getDataRealizacao());
        txtTipo.setText(elementos.get(position).getTipoQuestionario());
        txtEscoreE.setText("E.E = " + elementos.get(position).getEscoreEssencial());
        txtEscoreG.setText("E.G = " + elementos.get(position).getEscoreGeral());

        return rowView;
    }
}
