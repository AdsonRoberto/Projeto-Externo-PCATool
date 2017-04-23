package com.developer.barbosa.pcatool.activity.profissional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developer.barbosa.pcatool.R;
import com.developer.barbosa.pcatool.activity.Escore;

public class ProfissionalH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional_h);

        final Button btn = (Button) findViewById(R.id.proximop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Escore.class);
                startActivity(intent);
            }
        });
    }
}
