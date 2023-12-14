package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_inicio;
    Button btn_registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_ReforAccion);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_inicio=(Button) findViewById(R.id.btn_inicio);

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Registro2.class);
                startActivity(i);
            }
        });


        btn_registrarse=(Button) findViewById(R.id.btn_registrarse);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent  i = new Intent(MainActivity.this, Registro3.class);
                startActivity(i);
            }
        });

    }

}