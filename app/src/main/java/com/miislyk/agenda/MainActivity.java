package com.miislyk.agenda;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {

    private TextInputEditText nombre;
    private DatePicker fecha;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;

    private String n;
    private String f;
    private String t;
    private String e;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (TextInputEditText) findViewById(R.id.textInputNombre);
        telefono = (TextInputEditText) findViewById(R.id.textInputTelefono);
        fecha = (DatePicker) findViewById(R.id.datePicker);
        email = (TextInputEditText) findViewById(R.id.textInputEmail);
        descripcion = (TextInputEditText) findViewById(R.id.textInputDescripcion);

        Button btnSiguiente = (Button) findViewById(R.id.buttonSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                n = nombre.getText().toString();
                t = telefono.getText().toString();
                f = getFecha();
                e = email.getText().toString();
                d = descripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, Confirmar.class);
                intent.putExtra(getResources().getString(R.string.keyCodeNombre), n);
                intent.putExtra(getResources().getString(R.string.keyCodeFecha), f);
                intent.putExtra(getResources().getString(R.string.keyCodeTelefono), t);
                intent.putExtra(getResources().getString(R.string.keyCodeEmail), e);
                intent.putExtra(getResources().getString(R.string.keyCodeDescripcion), d);
                startActivity(intent);
                finish();

            }
        });

      /*  Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString(getResources().getString(R.string.keyCodeNombre));
        //String fecha = parametros.getString(getResources().getString(R.string.keyCodeFecha));
        final String telefono = parametros.getString(getResources().getString(R.string.keyCodeTelefono));*/

        //nombre.replace("",nombre);



    }


    public String getFecha() {

        StringBuilder fechaElegida = new StringBuilder();
        fechaElegida.append("Fecha Nacimiento: " + fecha.getDayOfMonth() + "/" + fecha.getMonth() + "/" + fecha.getYear());
        return fechaElegida.toString();

    }

}
