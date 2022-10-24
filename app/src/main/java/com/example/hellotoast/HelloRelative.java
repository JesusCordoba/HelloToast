package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloRelative extends AppCompatActivity {

    private Button countbtn;
    private Button toastbtn;
    private TextView texto_contador;
    private int contador = 0;
    private static final String KEY_CONTADOR = "contador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_relative);

        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt(KEY_CONTADOR, 0);
        }

        texto_contador = (TextView) findViewById(R.id.contadorTexto);
        countbtn = (Button) findViewById(R.id.Count);
        countbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                texto_contador.setText(contador + "");
            }
        });

        toastbtn = (Button) findViewById(R.id.ToastBtn);
        toastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Context context = getApplicationContext();
                Toast.makeText(getApplicationContext(), ""+contador, Toast.LENGTH_SHORT).show();
            }
        });

        texto_contador.setText(contador + "");

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_CONTADOR, contador);
    }
}