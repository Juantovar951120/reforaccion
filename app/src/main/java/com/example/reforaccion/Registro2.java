package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Registro2 extends AppCompatActivity {

    Button btn_inicio2;
    Button btn_registrarse2;
    EditText ext_name;
    EditText ext_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        btn_inicio2=(Button) findViewById(R.id.btn_inicio2);

        TextInputLayout name = findViewById(R.id.ext_name);
        TextInputLayout password = findViewById(R.id.ext_password);

        ext_name = name.getEditText();
        ext_password = password.getEditText();

        //ext_name=findViewById(R.id.ext_name);
        //ext_password=findViewById(R.id.ext_password);

        Intent regis=new Intent(getApplicationContext(), Registro2.class);
        Intent logi=new Intent(getApplicationContext(), Inicio.class);

        File fileUser=new File(getFilesDir(),"user.txt");

        ArrayList<user> users= ListUser(fileUser);

        btn_inicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String nameText=ext_name.getText().toString();
                String passwordText=ext_password.getText().toString();
                if (nameText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getBaseContext(),"Ingresa correo electronico y contraseña",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(logi);
                }*/

                boolean state=false;
                if (ext_name.getText().toString().isEmpty() || ext_password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Ingresa correo electronico y contraseña",Toast.LENGTH_LONG).show();
                }else {
                    String userLogin=ext_name.getText().toString();
                    for (user i:users){
                        if(i.getIngre_correo().equals(userLogin) || i.getIngre_nombre().equals(userLogin)){
                            state=true;
                            if (i.getIngre_contra().equals(ext_password.getText().toString())){
                                String nombreUsuario = i.getIngre_nombre();
                                logi.putExtra("nombreUsuario", nombreUsuario);
                                logi.putExtra("username", nombreUsuario);
                                startActivity(logi);
                                break;
                            }else{
                                Toast.makeText(getApplicationContext(), "contraseña incorrecta",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (!state){
                        Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
                    }
                }
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


    }

    public ArrayList<user> ListUser(File data) {
        ArrayList<user> list=new ArrayList<>();

        try {
            FileReader reader=new FileReader(data);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String user;


            while ((user=bufferedReader.readLine())!=null){
                String[] userData=user.split(",");
                String ingre_nombre=userData[0];
                String ingre_correo=userData[1];
                String ingre_contra=userData[2];

                user userObject=new user(ingre_nombre, ingre_correo, ingre_contra);
                list.add(userObject);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;


    }


}