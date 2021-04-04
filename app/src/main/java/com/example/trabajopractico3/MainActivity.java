package com.example.trabajopractico3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  MainActivityViewModel vm;
    private Button convertir;
    private EditText dolares ,euros,resultado ;
    private RadioButton  euroadolar,dolaraeuro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarVistas();
        validar();

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                resultado.setText(s);
            }
        });

    }

    public void inicializarVistas(){

        dolares = findViewById(R.id.dolares);
        dolares.setEnabled(false);
        euros = findViewById(R.id.euros);
        euros.setEnabled(false);
        resultado= findViewById(R.id.tvresultado);
        convertir = findViewById(R.id.covertir);
        euroadolar = findViewById(R.id.rteurosadolares);
        dolaraeuro = findViewById(R.id.rtdolaresaeuros);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (euros.isEnabled()) {
                    vm.calcular1(euros.getText().toString());
                }else if (dolares.isEnabled()){
                    vm.calcular2(dolares.getText().toString());
                }
            }
        });


    }

    public void validar (){

        euroadolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                euros.setEnabled(true);
                dolares.setEnabled(false);
                dolares.setText("");
            }
        });
        dolaraeuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dolares.setEnabled(true);
                euros.setEnabled(false);
                euros.setText("");
            }

        });


    }
}