package com.developer.barbosa.pcatool.activity.profissional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developer.barbosa.pcatool.R;

public class ProfissionalF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_f);

        final Button btn = (Button) findViewById(R.id.proximop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProfissionalG.class);
                startActivity(intent);
            }
        });
    }
}
