package br.uece.gesad.pcatoolbrasil.activity.telas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.uece.gesad.pcatoolbrasil.R;
import br.uece.gesad.pcatoolbrasil.model.domain.Entrevistado;

public class Cadastro extends AppCompatActivity {

    private EditText nome, idade;
    private Spinner sexo;
    private FloatingActionButton fltComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006E70")));

        this.nome = (EditText) findViewById(R.id.txtNome);
        this.idade = (EditText) findViewById(R.id.txtIdade);
        this.sexo = (Spinner) findViewById(R.id.spnSexo);

        this.fltComecar = (FloatingActionButton) findViewById(R.id.fltComecar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_sexo, R.layout.spinner_item_pattern);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sexo.setAdapter(adapter);

        this.fltComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeEntrevistado = nome.getText().toString();
                String sexoEntrevistado = sexo.getSelectedItem().toString();
                String idadeEntrevistadoText = idade.getText().toString();

                if(nomeEntrevistado.equals("") || idadeEntrevistadoText.equals("")){
                    Toast.makeText(Cadastro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                int idadeEntrevistado = 0;
                try {
                    idadeEntrevistado = Integer.parseInt(idadeEntrevistadoText);
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(Cadastro.this, "Informe a idade do entrevistado(a)", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Instanciando um entrevistado e sem questionario. Mas sem cadastrar no banco de dados ainda.
                Entrevistado entrevistado = new Entrevistado();
                entrevistado.setNome(nomeEntrevistado);
                entrevistado.setIdade(idadeEntrevistado);
                entrevistado.setSexo(sexoEntrevistado);

                // Enviando o entrevistado via intent
                Intent intent = new Intent(getApplicationContext(), ModuloQuestionario.class);
                intent.putExtra("entrevistado", entrevistado);

                System.out.println("Enviando Entrevistado para a outra Activity");

                startActivity(intent);
            }
        });

    }

}
