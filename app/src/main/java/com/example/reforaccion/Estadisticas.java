package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Estadisticas extends AppCompatActivity {

    ImageView consejos,registro,inicio,informacion;
    ImageView imsiete_cueros,imcaucho_sabanero,imclavenillo,imborrachero,imcedro,imorquidea;
    TextView tvsiete_cueros,tvcaucho_sabanero,tvclavenillo,tvborrachero,tvcedro,tvorquidea,tvnombre_arbol,tvflminimo,tvFlmaximo,tvFlArbol,tvFlIngreso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        consejos=(ImageView) findViewById(R.id.consejos);
        registro=(ImageView) findViewById(R.id.registro);
        inicio=(ImageView) findViewById(R.id.inicio);
        informacion=(ImageView) findViewById(R.id.informacion);

        imsiete_cueros=findViewById(R.id.imsiete_cueros);
        imcaucho_sabanero=findViewById(R.id.imcaucho_sabanero);
        imclavenillo=findViewById(R.id.imclavenillo);
        imborrachero=findViewById(R.id.imborrachero);
        imcedro=findViewById(R.id.imcedro);
        imorquidea=findViewById(R.id.imorquidea);

        tvsiete_cueros=findViewById(R.id.tvsiete_cueros);
        tvcaucho_sabanero=findViewById(R.id.tvcaucho_sabanero);
        tvclavenillo=findViewById(R.id.tvclavenillo);
        tvborrachero=findViewById(R.id.tvborrachero);
        tvcedro=findViewById(R.id.tvcedro);
        tvorquidea=findViewById(R.id.tvorquidea);
        tvnombre_arbol=findViewById(R.id.tvnombre_arbol);
        tvFlArbol=findViewById(R.id.tvFlArbol);
        tvFlIngreso=findViewById(R.id.tvFlIngreso);
        tvflminimo=findViewById(R.id.tvflminimo);
        tvFlmaximo=findViewById(R.id.tvFlmaximo);


        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Estadisticas.this, Consejos.class);
                startActivity(i);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Estadisticas.this, Registro.class);
                startActivity(i);
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Estadisticas.this, Inicio.class);
                startActivity(i);
            }
        });


        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Estadisticas.this, Informacion.class);
                startActivity(i);
            }
        });

        imsiete_cueros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Siete_cueros");
                mostrarEstadisticasSiete_cueros();
                mostrarKgMaxMinSiete_cueros();
            }
        });

        imcaucho_sabanero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Caucho_sabanero");
                mostrarEstadisticasCaucho_sabanero();
                mostrarKgMaxMinCaucho_sabanero();
            }
        });

        imclavenillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Clavenillo");
                mostrarEstadisticasClavenillo();
                mostrarKgMaxMinClavenillo();
            }
        });

        imborrachero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Borrachero");
                mostrarEstadisticasBorrachero();
                mostrarKgMaxMinBorrachero();
            }
        });

        imcedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Cedro");
                mostrarEstadisticasCedro();
                mostrarKgMaxMinCedro();
            }
        });

        imorquidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Orquidea");
                mostrarEstadisticasOrquidea();
                mostrarKgMaxMinOrquidea();
            }
        });

        tvsiete_cueros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Siete_cueros");
            }
        });

        tvcaucho_sabanero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Caucho_sabanero");
            }
        });

        tvclavenillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Clavenillo");
            }
        });

        tvborrachero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Borrachero");
            }
        });

        tvcedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Cedro");
            }
        });

        tvorquidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMaterialName("Orquidea");
            }
        });

    }

    private void updateMaterialName(String materialName) {
        tvnombre_arbol.setText(materialName);
    }
    private void mostrarEstadisticasSiete_cueros() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadSiete_cueros = 0.0;
                double totalIngresoSiete_cueros = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Siete_cueros".equals(datos[2].trim())) {
                        totalCantidadSiete_cueros += Double.parseDouble(datos[3].trim());
                        totalIngresoSiete_cueros += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadSiete_cueros);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadSiete_cueros);
                tvFlArbol.setText(totalCantidadSiete_cueros+"");
                tvFlIngreso.setText(totalIngresoSiete_cueros+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasSiete_cueros", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasSiete_cueros", "El archivo no existe en la ubicación esperada.");
        }
    }


    private void mostrarEstadisticasCaucho_sabanero() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadCaucho_sabanero = 0.0;
                double totalIngresoCaucho_sabanero = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Caucho_sabanero".equals(datos[2].trim())) {
                        totalCantidadCaucho_sabanero += Double.parseDouble(datos[3].trim());
                        totalIngresoCaucho_sabanero += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadCaucho_sabanero);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadCaucho_sabanero);
                tvFlArbol.setText(totalCantidadCaucho_sabanero+"");
                tvFlIngreso.setText(totalIngresoCaucho_sabanero+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasCaucho_sabanero", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasCaucho_sabanero", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarEstadisticasClavenillo() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadClavenillo = 0.0;
                double totalIngresoClavenillo = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Clavenillo".equals(datos[2].trim())) {
                        totalCantidadClavenillo += Double.parseDouble(datos[3].trim());
                        totalIngresoClavenillo += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadClavenillo);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadClavenillo);
                tvFlArbol.setText(totalCantidadClavenillo+"");
                tvFlIngreso.setText(totalIngresoClavenillo+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasClavenillo", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasClavenillo", "El archivo no existe en la ubicación esperada.");
        }
    }


    private void mostrarEstadisticasBorrachero() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadBorrachero = 0.0;
                double totalIngresoBorrachero = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Borrachero".equals(datos[2].trim())) {
                        totalCantidadBorrachero += Double.parseDouble(datos[3].trim());
                        totalIngresoBorrachero += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadBorrachero);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadBorrachero);
                tvFlArbol.setText(totalCantidadBorrachero+"");
                tvFlIngreso.setText(totalIngresoBorrachero+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasBorrachero", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasBorrachero", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarEstadisticasCedro() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadCedro = 0.0;
                double totalIngresoCedro = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Cedro".equals(datos[2].trim())) {
                        totalCantidadCedro += Double.parseDouble(datos[3].trim());
                        totalIngresoCedro += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadCedro);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadCedro);
                tvFlArbol.setText(totalCantidadCedro+"");
                tvFlIngreso.setText(totalIngresoCedro+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasCedro", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasCedro", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarEstadisticasOrquidea() {
        File materialsFile = new File(getFilesDir(),"materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double totalCantidadOrquidea = 0.0;
                double totalIngresoOrquidea = 0.0;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Orquidea".equals(datos[2].trim())) {
                        totalCantidadOrquidea += Double.parseDouble(datos[3].trim());
                        totalIngresoOrquidea += Double.parseDouble(datos[4].trim());
                        System.out.println("holalllll que hay en " + totalCantidadOrquidea);
                    }
                }

                reader.close();

                // Muestra el resultado en el TextView
                System.out.println("que hay en" + totalCantidadOrquidea);
                tvFlArbol.setText(totalCantidadOrquidea+"");
                tvFlIngreso.setText(totalIngresoOrquidea+"");

            } catch (IOException e) {
                e.printStackTrace();
                // Log.d("EstadisticasOrquidea", "Error al leer el archivo.", e);
            }
        } else {
            // Log.d("EstadisticasOrquidea", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinSiete_cueros() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Siete_cueros".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinSiete_cueros", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinCaucho_sabanero() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Caucho_sabanero".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinCaucho_sabanero", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinClavenillo() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Clavenillo".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinClavenillo", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinBorrachero() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Borrachero".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinBorrachero", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinCedro() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Cedro".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinCedro", "El archivo no existe en la ubicación esperada.");
        }
    }

    private void mostrarKgMaxMinOrquidea() {
        File materialsFile = new File(getFilesDir(), "materials.txt");

        if (materialsFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(materialsFile));
                String line;
                double maxKg = Double.MIN_VALUE;
                double minKg = Double.MAX_VALUE;

                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if ("Orquidea".equals(datos[2].trim())) {
                        double cantidadKg = Double.parseDouble(datos[3].trim());
                        if (cantidadKg > maxKg) {
                            maxKg = cantidadKg;
                        }
                        if (cantidadKg < minKg) {
                            minKg = cantidadKg;
                        }
                    }
                }

                reader.close();

                // Muestra el resultado en los TextView
                tvFlmaximo.setText(String.format(Locale.getDefault(), "%.2f", maxKg));
                tvflminimo.setText(String.format(Locale.getDefault(), "%.2f", minKg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MostrarKgMaxMinOrquidea", "El archivo no existe en la ubicación esperada.");
        }
    }


}
