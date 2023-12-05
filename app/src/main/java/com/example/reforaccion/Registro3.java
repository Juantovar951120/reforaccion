package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registro3 extends AppCompatActivity {

    Button btn_inicio3;
    TextView tv_mastarde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro3);
        btn_inicio3=(Button) findViewById(R.id.btn_inicio3);

        btn_inicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Bienvenidos", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Registro3.this,Inicio4.class);
                startActivity(i);
            }
        });

        tv_mastarde=(TextView) findViewById(R.id.tv_mastarde);

        tv_mastarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Bienvenidos", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Registro3.this,Inicio4.class);
                startActivity(i);
            }
        });

    }
}