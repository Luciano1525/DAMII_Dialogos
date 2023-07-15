package com.example.congreso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    private Button btnIngresar, btnConferencia, btnSalir, btnExpo, btnAsis;
    private EditText etNombreE, etNumeroE, etCorreoE;
    private Spinner spnConferencia,spnConferencia1;
    private TextView tvConferencia, tvExpositor, tvAsistente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        //Boton para llamar al Dialogo personalizado de registro
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder res = new AlertDialog.Builder(MainActivity.this);
                res.setMessage("Seleccioone Registro");
                View select = getLayoutInflater().inflate(R.layout.roless, null);
                res.setView(select);


                //Boton de Dialogo Personalizado para registrar expositor
                btnExpo = (Button) select.findViewById(R.id.btnExpo);
                btnExpo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder res1 = new AlertDialog.Builder(MainActivity.this);
                        res1.setMessage("Registrar Conferencia");
                        View select1 = getLayoutInflater().inflate(R.layout.custom_dialog_expositor, null);
                        res1.setView(select1);
                        res1.setCancelable(false);
                        etNombreE = (EditText) select1.findViewById(R.id.etNombreE);
                        etNumeroE = (EditText) select1.findViewById(R.id.etNumeroE);
                        etCorreoE = (EditText) select1.findViewById(R.id.etCorreoE);
                        spnConferencia = (Spinner) select1.findViewById(R.id.spnConferencia);

                        ArrayAdapter  <CharSequence>adapter=ArrayAdapter.createFromResource(MainActivity.this, R.array.Conferencias, android.R.layout.simple_spinner_item);
                        spnConferencia.setAdapter(adapter);

                        res1.setPositiveButton("Registrar Conferencia", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Metodo de registro
                                String ItemSelect = spnConferencia.getSelectedItem().toString();
                                int SelectItem = spnConferencia.getSelectedItemPosition();

                                if (SelectItem == 1){
                                    SharedPreferences CON1 = getSharedPreferences("Conferencia1", Context.MODE_PRIVATE);
                                    String NombreC1 = etNombreE.getText().toString();
                                    String NumeroC1 = etNumeroE.getText().toString();
                                    String CorreoC1 = etCorreoE.getText().toString();
                                    String ItemSelectC1 = spnConferencia.getSelectedItem().toString();

                                    SharedPreferences.Editor editCon1 = CON1.edit();
                                    editCon1.putString("Nombre1", NombreC1.toString());
                                    editCon1.putString("Numero1", NumeroC1.toString());
                                    editCon1.putString("Correo1", CorreoC1.toString());
                                    editCon1.putString("ItemSelect1", ItemSelectC1.toString());
                                    editCon1.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                } else if (SelectItem == 2){
                                    SharedPreferences CON2 = getSharedPreferences("Conferencia2", Context.MODE_PRIVATE);
                                    String NombreC2 = etNombreE.getText().toString();
                                    String NumeroC2 = etNumeroE.getText().toString();
                                    String CorreoC2 = etCorreoE.getText().toString();
                                    String ItemSelectC2 = spnConferencia.getSelectedItem().toString();

                                    SharedPreferences.Editor editCon2 = CON2.edit();
                                    editCon2.putString("Nombre2", NombreC2.toString());
                                    editCon2.putString("Numero2", NumeroC2.toString());
                                    editCon2.putString("Correo2", CorreoC2.toString());
                                    editCon2.putString("ItemSelect2", ItemSelectC2.toString());
                                    editCon2.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                } else if (SelectItem == 3){
                                    SharedPreferences CON3 = getSharedPreferences("Conferencia3", Context.MODE_PRIVATE);
                                    String NombreC3 = etNombreE.getText().toString();
                                    String NumeroC3 = etNumeroE.getText().toString();
                                    String CorreoC3 = etCorreoE.getText().toString();
                                    String ItemSelectC3 = spnConferencia.getSelectedItem().toString();

                                    SharedPreferences.Editor editCon3 = CON3.edit();
                                    editCon3.putString("Nombre3", NombreC3.toString());
                                    editCon3.putString("Numero3", NumeroC3.toString());
                                    editCon3.putString("Correo3", CorreoC3.toString());
                                    editCon3.putString("ItemSelect3", ItemSelectC3.toString());
                                    editCon3.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                }

                                //dd
                            }
                        });

                        res1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog1 = res1.create();
                        dialog1.show();
                    }
                });

                //Boton de Dialogo Personalizado para consultar asistente
                btnAsis = (Button) select.findViewById(R.id.btnAsis);
                btnAsis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder res1 = new AlertDialog.Builder(MainActivity.this);
                        res1.setMessage("Consultar Conferencia");
                        View select1 = getLayoutInflater().inflate(R.layout.custom_dialog_asistente, null);
                        res1.setView(select1);
                        res1.setCancelable(false);
                        spnConferencia = (Spinner) select1.findViewById(R.id.spnConferencia1);

                        ArrayAdapter  <CharSequence>adapter=ArrayAdapter.createFromResource(MainActivity.this, R.array.Conferencias, android.R.layout.simple_spinner_item);
                        spnConferencia.setAdapter(adapter);
                        res1.setPositiveButton("Consultar Conferencia", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Metodo de registro
                                String ItemSelect = spnConferencia.getSelectedItem().toString();
                                int SelectItem = spnConferencia.getSelectedItemPosition();

                                if (SelectItem == 1){
                                    SharedPreferences CA1 = getSharedPreferences("Asistente1", Context.MODE_PRIVATE);
                                    String asC1 = "Asistente Roberto";
                                    SharedPreferences.Editor editAS1 = CA1.edit();
                                    editAS1.putString("as1", asC1.toString());
                                    editAS1.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                } else if (SelectItem == 2){
                                    SharedPreferences CA2 = getSharedPreferences("Asistente2", Context.MODE_PRIVATE);
                                    String asC2 = "Asistente Pedro";
                                    SharedPreferences.Editor editAS2 = CA2.edit();
                                    editAS2.putString("as2", asC2.toString());
                                    editAS2.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                } else if (SelectItem == 3){
                                    SharedPreferences CA3 = getSharedPreferences("Asistente3", Context.MODE_PRIVATE);
                                    String asC3 = "Asistente Fernando";
                                    SharedPreferences.Editor editAS3 = CA3.edit();
                                    editAS3.putString("as3", asC3.toString());
                                    editAS3.commit();
                                    Toast.makeText(getApplicationContext(), "Conferencia " + ItemSelect + " Registrada con Exito", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });

                        res1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog dialog1 = res1.create();
                        dialog1.show();
                    }
                });

                AlertDialog dialog = res.create();
                dialog.show();

            }
        });

        //Boton para mostrar las conferencias
        btnConferencia = (Button) findViewById(R.id.btnConferencia);
        btnConferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostarToastPersonalizado();
            }
        });

        //Boton para salir

        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Salir");
                builder.setMessage("Desea Salir de la Aplicacion y Borrar los registros?");
                builder.setCancelable(false);

                builder.setPositiveButton("Salir y Borrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restablecer();
                        Toast.makeText(getApplicationContext(), "Aplicacion Finalizada!", Toast.LENGTH_SHORT).show();
                        Log.i("INFO:", "App Finish");
                        finishAffinity();
                    }
                });

                builder.setNeutralButton("Salir y Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Aplicacion Finalizada!", Toast.LENGTH_SHORT).show();
                        Log.i("INFO:", "App Finish");
                        finishAffinity();
                    }
                });


                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }

    private void mostarToastPersonalizado() {
        SharedPreferences CON1 = getSharedPreferences("Conferencia1", Context.MODE_PRIVATE);
        String CO1 = CON1.getString("ItemSelect1", "Conferencias no Disponibles");

        SharedPreferences CON2 = getSharedPreferences("Conferencia2", Context.MODE_PRIVATE);
        String CO2 = CON2.getString("ItemSelect2", "Conferencias no Disponibles");

        SharedPreferences CON3 = getSharedPreferences("Conferencia3", Context.MODE_PRIVATE);
        String CO3 = CON3.getString("ItemSelect3", "Conferencias no Disponibles");

        SharedPreferences CA1 = getSharedPreferences("Asistente1", Context.MODE_PRIVATE);
        SharedPreferences CA2 = getSharedPreferences("Asistente2", Context.MODE_PRIVATE);
        SharedPreferences CA3 = getSharedPreferences("Asistente3", Context.MODE_PRIVATE);

        if (CO1.equals("IA Para el Mundo")){
            String NCO1 = CON1.getString("Nombre1", "Expositor no registrado");
            String ACO1 = CA1.getString("as1", "Asistente no registrado");

            Toast toast1 = new Toast(this);
            toast1.setDuration(Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100);
            LayoutInflater inflater1 = getLayoutInflater();
            View view1 = inflater1.inflate(R.layout.toast_p,null);

            tvConferencia = (TextView) view1.findViewById(R.id.tvConferencia);
            tvExpositor = (TextView) view1.findViewById(R.id.tvExpositor);
            tvAsistente = (TextView) view1.findViewById(R.id.tvAsistente);

            tvConferencia.setText(CO1);
            tvExpositor.setText(NCO1);
            tvAsistente.setText(ACO1);

            toast1.setView(view1);
            toast1.show();

        }

        if (CO2.equals("El Futuro del Cambio")){
            String NCO2 = CON2.getString("Nombre2", "Expositor no registrado");
            String ACO2 = CA2.getString("as2", "Asistente no registrado");

            Toast toast2 = new Toast(this);
            toast2.setDuration(Toast.LENGTH_LONG);
            toast2.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100);
            LayoutInflater inflater2 = getLayoutInflater();
            View view2 = inflater2.inflate(R.layout.toast_p,null);

            tvConferencia = (TextView) view2.findViewById(R.id.tvConferencia);
            tvExpositor = (TextView) view2.findViewById(R.id.tvExpositor);
            tvAsistente = (TextView) view2.findViewById(R.id.tvAsistente);

            tvConferencia.setText(CO2);
            tvExpositor.setText(NCO2);
            tvAsistente.setText(ACO2);

            toast2.setView(view2);
            toast2.show();

        }

        if (CO3.equals("La Nueva Era: Mundo Virtual")){
            String NCO3 = CON3.getString("Nombre3", "Expositor no registrado");
            String ACO3 = CA3.getString("as3", "Asistente no registrado");

            Toast toast3 = new Toast(this);
            toast3.setDuration(Toast.LENGTH_LONG);
            toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100);
            LayoutInflater inflater3 = getLayoutInflater();
            View view3 = inflater3.inflate(R.layout.toast_p,null);

            tvConferencia = (TextView) view3.findViewById(R.id.tvConferencia);
            tvExpositor = (TextView) view3.findViewById(R.id.tvExpositor);
            tvAsistente = (TextView) view3.findViewById(R.id.tvAsistente);

            tvConferencia.setText(CO3);
            tvExpositor.setText(NCO3);
            tvAsistente.setText(ACO3);

            toast3.setView(view3);
            toast3.show();

        } else {
            Toast.makeText(getApplicationContext(), "Actualmente NO Existen Conferencias", Toast.LENGTH_SHORT).show();
        }

    }


    private void restablecer () {
        SharedPreferences CON1 = getSharedPreferences("Conferencia1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC1 = CON1.edit();
        editC1.clear();
        editC1.apply();

        SharedPreferences CON2 = getSharedPreferences("Conferencia2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC2 = CON2.edit();
        editC2.clear();
        editC2.apply();

        SharedPreferences CON3 = getSharedPreferences("Conferencia3", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC3 = CON3.edit();
        editC3.clear();
        editC3.apply();

        SharedPreferences CA1 = getSharedPreferences("Asistente1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC4 = CA1.edit();
        editC4.clear();
        editC4.apply();

        SharedPreferences CA2 = getSharedPreferences("Asistente2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC5 = CA2.edit();
        editC5.clear();
        editC5.apply();

        SharedPreferences CA3 = getSharedPreferences("Asistente3", Context.MODE_PRIVATE);
        SharedPreferences.Editor editC6 = CA3.edit();
        editC6.clear();
        editC6.apply();
    }

}