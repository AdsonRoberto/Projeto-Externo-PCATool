package com.developer.barbosa.pcatool.activity.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.model.Entrevistado;
import com.developer.barbosa.pcatool.model.PostoDAO;
import com.developer.barbosa.pcatool.model.RegionalDAO;

public class Cadastro extends AppCompatActivity {

    private EditText nome, idade;
    private Spinner sexo;
    private Button comecar;

    private RegionalDAO regionalDAO;
    private PostoDAO postoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadastrarRegionaisPostos();

        this.nome = (EditText) findViewById(R.id.txtNome);
        this.idade = (EditText) findViewById(R.id.txtIdade);
        this.sexo = (Spinner) findViewById(R.id.spnSexo);

        this.comecar = (Button) findViewById(R.id.btnComecar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_sexo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sexo.setAdapter(adapter);

        this.comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeEntrevistado = nome.getText().toString();
                String sexoEntrevistado = sexo.getSelectedItem().toString();
                int idadeEntrevistado = Integer.parseInt(idade.getText().toString());

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

    public void cadastrarRegionaisPostos(){
        this.regionalDAO = new RegionalDAO(this);
        this.postoDAO = new PostoDAO(this);
        regionalDAO.createRegionais();
        postoDAO.createPostos();
    }

}
