package com.example.congreso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnIngresar, btnSalir, btnExpo, btnAsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        //btnExpo = (Button) findViewById(R.id.btnExpo);
        //btnAsis = (Button) findViewById(R.id.btnAsis);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder res = new AlertDialog.Builder(MainActivity.this);
                res.setMessage("Seleccioone Registro");
                View select = getLayoutInflater().inflate(R.layout.roless, null);
                res.setView(select);
                res.setCancelable(false);

                AlertDialog dialog = res.create();
                dialog.show();



            }
        });



    }

}