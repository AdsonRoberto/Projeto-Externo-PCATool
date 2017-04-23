package com.developer.barbosa.pcatool.activity.adulto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.developer.barbosa.pcatool.R;

public class AdultoH extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto_h);

        final Button btn = (Button) findViewById(R.id.proximo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdultoI.class);
                startActivity(intent);
            }
        });
    }
}
