package com.example.reforaccion;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Registro3 extends AppCompatActivity {

    Button btnregistrarse3;
    EditText ingre_nombre, ingre_correo, ingre_contra, confirma_contra;
    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro3);
        btnregistrarse3=(Button) findViewById(R.id.btnregistrarse);

        TextInputLayout nombres = findViewById(R.id.ingre_nombre);
        TextInputLayout correo = findViewById(R.id.ingre_correo);
        TextInputLayout contraseña = findViewById(R.id.ingre_contra);
        TextInputLayout validacion = findViewById(R.id.confirma_contra);

        ingre_nombre = nombres.getEditText();
        ingre_correo = correo.getEditText();
        ingre_contra = contraseña.getEditText();
        confirma_contra = validacion.getEditText();

        check = findViewById(R.id.check);

        Intent Registro3 =new Intent(getApplicationContext(),Registro2.class);

        btnregistrarse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarUsuario()) {
                    user user = crearUsuario();
                    SaveUser(user);
                    Toast.makeText(getApplicationContext(),
                            "Usuario creado con éxito", Toast.LENGTH_LONG).show();

                    try {
                        sleep(500);
                        startActivity(Registro3);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), " Todos los campos deben estar diligenciados", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    // Metodo para validar si el espacio esta vacio o lleno
    public boolean validarUsuario(){
        boolean validarDate=true;

        if (ingre_nombre.getText().toString().isEmpty()){
            ingre_nombre.setBackgroundColor(Color.RED);
            validarDate=false;
        } else {
            ingre_nombre.setBackgroundColor(Color.TRANSPARENT);
        }
        if (ingre_correo.getText().toString().isEmpty()){
            ingre_correo.setBackgroundColor(Color.RED);
            validarDate=false;
        }else {
            ingre_correo.setBackgroundColor(Color.TRANSPARENT);
        }
        if (ingre_contra.getText().toString().isEmpty()){
            ingre_contra.setBackgroundColor(Color.RED);
            validarDate=false;
        }else {
            ingre_contra.setBackgroundColor(Color.TRANSPARENT);
        }
        if (confirma_contra.getText().toString().isEmpty()){
            confirma_contra.setBackgroundColor(Color.RED);
            validarDate=false;
        }else {
            confirma_contra.setBackgroundColor(Color.TRANSPARENT);
        }
        if (!confirma_contra.getText().toString().equals(confirma_contra.getText().toString())){
            confirma_contra.setBackgroundColor(Color.RED);
            confirma_contra.setBackgroundColor(Color.RED);
            validarDate=false;
            Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_LONG).show();
        }else {
            ingre_contra.setBackgroundColor(Color.TRANSPARENT);
            confirma_contra.setBackgroundColor(Color.TRANSPARENT);
        }

        if (!check.isChecked()){
            check.setBackgroundColor(Color.RED);
            validarDate=false;
        } else {
            check.setBackgroundColor(Color.TRANSPARENT);
        }

        return validarDate;

    }

    //Metodo que solicita los datos
    public user crearUsuario(){
        String NombreUser,ApellidosUser, CorreoUser, ContraseñaUser;

        NombreUser=ingre_nombre.getText().toString();
        CorreoUser=ingre_correo.getText().toString();
        ContraseñaUser=ingre_contra.getText().toString();

        user user=new user(NombreUser,CorreoUser,ContraseñaUser);

        return user;
    }


    //Crear el archivo plano para almacenar el usuario
    public void SaveUser(user user){

        File fileUser=new File(getFilesDir(), "user.txt");

        try {
            FileWriter writer=new FileWriter(fileUser,true);

            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write(
                    user.getIngre_nombre()+","+
                            user.getIngre_correo()+","+
                            user.getIngre_contra()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (Exception error){
            error.printStackTrace();
        }

    }
}