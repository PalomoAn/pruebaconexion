package com.example.pruebaconexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtID, txtNombre;
    Button btnIngresar, btnBuscar;

    Personas personas;
    Consulta consulta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtID = (EditText) findViewById(R.id.txtID);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        consulta = new Consulta();
        btnBuscar.setOnClickListener(view -> {
            enviar("Buscar.php");
        });
        btnIngresar.setOnClickListener(view -> {
            enviar("Agregar.php");
        });
    }

    public void enviar(String archivio) {
        personas = new Personas();
        personas.setId(txtID.getText().toString());
        personas.setNombre(txtNombre.getText().toString());
        consulta.peticion("http://192.168.137.214:8080/Personas/" + archivio, personas, this);
    }
}