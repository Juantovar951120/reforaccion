package com.example.reforaccion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Registro extends AppCompatActivity {

    ImageView consejos,inicio,estadisticas,informacion;
    TextView tvFecha;
    TextInputLayout etIngreseArbol, etValorArbol;
    Button btnAgregar;
    TableLayout tabla;
    Spinner materialSpinner;

    private double valorTotal = 0.0;

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        consejos=(ImageView) findViewById(R.id.consejos);
        inicio=(ImageView) findViewById(R.id.inicio);
        estadisticas=(ImageView) findViewById(R.id.estadisticas);
        informacion=(ImageView) findViewById(R.id.informacion);

        materialSpinner = findViewById(R.id.choose_item);
        tvFecha = findViewById(R.id.tvFecha);
        etIngreseArbol = findViewById(R.id.etIngreseArbol);
        btnAgregar = findViewById(R.id.btnAgregar);
        etValorArbol = findViewById(R.id.etValorArbol);
        tabla = findViewById(R.id.tlTabla);


        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Consejos.class);
                startActivity(i);
            }
        });


        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Inicio.class);
                startActivity(i);
            }
        });

        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Estadisticas.class);
                startActivity(i);
            }
        });

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Informacion.class);
                startActivity(i);
            }
        });


        // Agregar el encabezado de la tabla
        TableRow headerRow = new TableRow(this);
        headerRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        String[] headers = {"Dia", "Mes", "Arbol", "Cantidad", "Valor"};

        for (String header : headers) {
            headerRow.addView(createTextView(header, true));
        }

        tabla.addView(headerRow);

        // SPINNER
        String[] opcionesMateriales = {"Seleccionar arbol", "Siete cueros", "Caucho sabanero", "Clavenillo", "Borrachero","Cedro","Orquidea"};
        // FECHA
        String fechaActual = obtenerFechaActual();
        tvFecha.setText("Fecha: " + fechaActual);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesMateriales);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        materialSpinner.setAdapter(adapter);

        // SELECCIÓN DEL SPINNER
        materialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Registro.this, "Por favor, selecciona un arbol", Toast.LENGTH_SHORT).show();
                } else {
                    String materialSeleccionado = opcionesMateriales[position];
                    Toast.makeText(Registro.this, "Arbol seleccionado: " + materialSeleccionado, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        // Cargar datos existentes al iniciar la aplicación
        loadDataFromFile();


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String material = materialSpinner.getSelectedItem().toString();
                String cantidadKg = etIngreseArbol.getEditText().getText().toString();
                String valorKG = etValorArbol.getEditText().getText().toString();

                String dia = obtenerDiaActual();
                String mes = obtenerMesActual();

                if (cantidadKg.isEmpty() || valorKG.isEmpty() || material.equals(opcionesMateriales[0])) {
                    Toast.makeText(Registro.this, "Por favor, ingresa todos los datos.", Toast.LENGTH_LONG).show();
                } else {
                    if (checkStoragePermission()) {
                        saveDataToFile(dia, mes, material, cantidadKg, valorKG);
                    } else {
                        requestStoragePermission();
                    }

                    addRow(dia, mes, material, cantidadKg, valorKG);

                    etIngreseArbol.getEditText().getText().clear();
                    etValorArbol.getEditText().getText().clear();
                }
            }
        });

        // Listener para las filas de la tabla
        for (int i = 1; i < tabla.getChildCount(); i++) {
            View rowView = tabla.getChildAt(i);
            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;
                setTableRowClickListener(row);
            }
        }
    }

    private void loadDataFromFile() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            // El archivo existe, procede a leer los datos y agregar las filas a la tabla
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    addRow(datos[0], datos[1], datos[2], datos[3], datos[4]);
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //archivo txt
    private boolean checkStoragePermission() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
    }



    private void saveDataToFile(String dia, String mes, String material, String cantidadKg, String valorKG) {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        try {
            FileWriter writer = new FileWriter(materialsFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    dia + "," +
                            mes + "," +
                            material + "," +
                            cantidadKg + "," +
                            valorKG
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private void addRow(String dia, String mes, String material, String cantidadKg, String valorKG) {
        TableRow newRow = new TableRow(this);
        newRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        newRow.addView(createTextView(dia, false));
        newRow.addView(createTextView(mes, false));
        newRow.addView(createTextView(material, false));
        newRow.addView(createTextView(cantidadKg, false));
        newRow.addView(createTextView(valorKG, false));

        // Añadir imagen de la caneca de basura
        ImageView deleteIcon = createDeleteIcon();
        newRow.addView(deleteIcon);

        // Establecer clic en la fila para resaltarla
        setTableRowClickListener(newRow);

        tabla.addView(newRow);

        double valor = Double.parseDouble(valorKG);
        valorTotal += valor;

        // Actualizar el TextView con el nuevo valor total
        TextView tvValorTotal = findViewById(R.id.valorTotal);
        tvValorTotal.setText("Valor total: " + String.valueOf(valorTotal));

    }

    private ImageView createDeleteIcon() {
        ImageView deleteIcon = new ImageView(this);
        deleteIcon.setImageResource(R.drawable.ic_delete); // Asegúrate de tener esta imagen en res/drawable
        deleteIcon.setClickable(true);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow parentRow = (TableRow) v.getParent();
                tabla.removeView(parentRow);
                Toast.makeText(Registro.this, "Fila eliminada", Toast.LENGTH_SHORT).show();
            }
        });

        return deleteIcon;
    }

    private void setTableRowClickListener(TableRow row) {
        for (int i = 0; i < row.getChildCount(); i++) {
            View childView = row.getChildAt(i);
            childView.setClickable(true);
            childView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Si se hace clic en la imagen de la caneca de basura, eliminar la fila
                    if (v instanceof ImageView) {
                        TableRow parentRow = (TableRow) v.getParent();
                        double valorEliminado = Double.parseDouble(((TextView) parentRow.getChildAt(4)).getText().toString());
                        valorTotal -= valorEliminado;

                        // Actualizar el TextView con el nuevo valor total
                        TextView tvValorTotal = findViewById(R.id.valorTotal);
                        tvValorTotal.setText("Valor total: " + String.valueOf(valorTotal));

                        // Eliminar la fila visualmente
                        tabla.removeView(parentRow);

                        // Eliminar la fila del archivo
                        removeFromFile(parentRow);

                        Toast.makeText(Registro.this, "Fila eliminada", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void removeFromFile(TableRow row) {
        File materialsFile = new File(getFilesDir(), "materials.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (!datos[0].equals(((TextView) row.getChildAt(0)).getText().toString())
                        || !datos[1].equals(((TextView) row.getChildAt(1)).getText().toString())
                        || !datos[2].equals(((TextView) row.getChildAt(2)).getText().toString())
                        || !datos[3].equals(((TextView) row.getChildAt(3)).getText().toString())
                        || !datos[4].equals(((TextView) row.getChildAt(4)).getText().toString())) {
                    lines.add(line);
                }
            }

            reader.close();

            // Sobrescribir el archivo con las líneas restantes
            FileWriter writer = new FileWriter(materialsFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String newLine : lines) {
                bufferedWriter.write(newLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al actualizar el archivo", Toast.LENGTH_SHORT).show();
        }
    }

    private TextView createTextView(String text, boolean isHeader) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(8, 8, 8, 8);

        if (isHeader) {
            textView.setBackgroundColor(Color.TRANSPARENT);
            textView.setTextColor(Color.BLACK);
        } else {
            textView.setBackgroundColor(Color.LTGRAY);
        }

        return textView;
    }

    private String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return formatoFecha.format(calendar.getTime());
    }

    private String obtenerDiaActual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
        SimpleDateFormat formatoDia = new SimpleDateFormat("dd", Locale.getDefault());
        return formatoDia.format(calendar.getTime());
    }

    private String obtenerMesActual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
        SimpleDateFormat formatoMes = new SimpleDateFormat("MM", Locale.getDefault());
        return formatoMes.format(calendar.getTime());
    }


    // Método que se ejecutará cuando se obtengan resultados de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, realiza la acción que requería el permiso.
                // Puedes llamar a la función que realiza la acción después de obtener el permiso aquí.
            } else {
                // Permiso denegado, muestra un mensaje o realiza alguna acción adecuada.
                Toast.makeText(this, "Cargando...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}