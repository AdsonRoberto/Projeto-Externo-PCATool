package com.developer.barbosa.pcatool.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.developer.barbosa.pcatool.R;

public class Cadastro extends AppCompatActivity {

    private EditText nome;
    private Spinner sexo;
    private Button comecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.txtNome);
        sexo = (Spinner) findViewById(R.id.spnSexo);
        comecar = (Button) findViewById(R.id.btnComecar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_sexo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexo.setAdapter(adapter);

        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(sexo.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModuloQuestionario.class);
                startActivity(intent);
            }
        });
    }

}
