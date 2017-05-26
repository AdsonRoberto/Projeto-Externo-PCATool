package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.dao.EntrevistadorDAO;
import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistador;

public class EditarEntrevistadorActivity extends AppCompatActivity {

    private TextView txtOlaEntrevistador;
    private EditText edtEditarEntrevistador;
    private FloatingActionButton fltAvancarEditar;

    private EntrevistadorDAO entrevistadorDAO;

    private Entrevistador entrevistador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_entrevistador);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        entrevistadorDAO = new EntrevistadorDAO(this);

        txtOlaEntrevistador = (TextView) findViewById(R.id.txtOlaEntrevistador);
        edtEditarEntrevistador = (EditText) findViewById(R.id.edtEditarEntrevistador);
        fltAvancarEditar = (FloatingActionButton) findViewById(R.id.fltAvancarEditar);

        entrevistador = entrevistadorDAO.getEntrevistador();

        // Setando informações na tela
        txtOlaEntrevistador.setText("Olá " + entrevistador.getNome());
        edtEditarEntrevistador.setText(entrevistador.getNome());

        fltAvancarEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeNovo = edtEditarEntrevistador.getText().toString();

                if(nomeNovo.equals("")){
                    Toast.makeText(EditarEntrevistadorActivity.this, "Por favor, digite seu nome", Toast.LENGTH_SHORT).show();
                    return;
                }

                entrevistador.setNome(nomeNovo);

                entrevistadorDAO.update(entrevistador);

                Toast.makeText(EditarEntrevistadorActivity.this, "Alteração concluída com sucesso", Toast.LENGTH_SHORT).show();

                onBackPressed();

            }
        });

    }
}
