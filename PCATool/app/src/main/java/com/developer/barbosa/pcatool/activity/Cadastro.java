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

import com.developer.barbosa.pcatool.Enum.Sexo;
import com.developer.barbosa.pcatool.R;
import com.facebook.stetho.Stetho;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Stetho.initializeWithDefaults(this);

        EditText nome = (EditText) findViewById(R.id.txtNome);
        final Spinner sexo = (Spinner) findViewById(R.id.spSexo);
        final Button comecar = (Button) findViewById(R.id.btnComecar);

        ArrayAdapter<Sexo> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Sexo.values());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sexo.setAdapter(adapter);

        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(sexo.getSelectedItem().toString());
                sexo.setPrompt(sexo.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ModuloQuestionario.class);
                startActivity(intent);
            }
        });
    }
}
