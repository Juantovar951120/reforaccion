package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registro2 extends AppCompatActivity {

    Button btn_inicio2;
    Button btn_registrarse2;
    TextView tv_mastarde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        btn_inicio2=(Button) findViewById(R.id.btn_inicio2);

        btn_inicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Bienvenidos", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Registro2.this,Inicio4.class);
                startActivity(i);
            }
        });

        btn_registrarse2=(Button) findViewById(R.id.btn_registrarse2);

        btn_registrarse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Registro2.this,Registro3.class);
                startActivity(i);
            }
        });

        tv_mastarde=(TextView) findViewById(R.id.tv_mastarde);

        tv_mastarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Bienvenidos", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Registro2.this,Inicio4.class);
                startActivity(i);
            }
        });

    }
}