package com.developer.barbosa.pcatool.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.activity.adulto.AdultoA;
import com.developer.barbosa.pcatool.activity.profissional.ProfissionalA;

public class ModuloQuestionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_questionario);

        final Button btnAdulto = (Button) findViewById(R.id.btnAdulto);
        final Button btnProfissional = (Button) findViewById(R.id.btnProfissional);

        btnAdulto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdultoA.class);
                startActivity(intent);
            }
        });

        btnProfissional.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfissionalA.class);
                startActivity(intent);
            }
        });
    }

}
