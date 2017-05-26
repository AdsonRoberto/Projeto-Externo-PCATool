package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.dao.EntrevistadorDAO;
import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistador;

public class BoasVindasActivity extends AppCompatActivity {

    private FloatingActionButton fltAvancar;
    private EditText edtIdentEntrevistador;
    private AlertDialog alerta;

    private EntrevistadorDAO entrevistadorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        entrevistadorDAO = new EntrevistadorDAO(this);

        fltAvancar = (FloatingActionButton) findViewById(R.id.fltAvancar);
        edtIdentEntrevistador = (EditText) findViewById(R.id.edtIdentEntrevistador);

        fltAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nome = edtIdentEntrevistador.getText().toString();

                if(nome.equals("")){
                    Toast.makeText(BoasVindasActivity.this, "Por favor, digite seu nome", Toast.LENGTH_SHORT).show();
                    return;
                }

                Entrevistador entrevistador = new Entrevistador(nome);
                entrevistadorDAO.insert(entrevistador);

                Toast.makeText(BoasVindasActivity.this, "Olá " + nome+"! Você podera alterar sua informação a qualquer momento", Toast.LENGTH_LONG).show();
                
                onBackPressed();

            }
        });

    }
}
