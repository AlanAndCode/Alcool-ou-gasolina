package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText PrecoAlcool, PrecoGasolina;
    private TextView TextResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrecoAlcool = findViewById(R.id.precoAlcool);
        PrecoGasolina = findViewById(R.id.precoGasolina);
        TextResultado = findViewById(R.id.TextResultado);
    }

    public Boolean validarcampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;

        if (pAlcool.isEmpty() || pAlcool.equals("")) {
            camposValidados = false;

        } else if (pGasolina.isEmpty() || pGasolina.equals("")) {
            camposValidados = false;

        }

        return camposValidados;

    }

    public void calcularPreco(View view) {
        //recuperar valores digitados
        String precoA = Objects.requireNonNull(PrecoAlcool.getText()).toString();
        String precoG = Objects.requireNonNull(PrecoGasolina.getText()).toString();

        //Validar os campos digitados
        Boolean camposValidados = validarcampos(precoA, precoG);
        if (camposValidados) {
// Fazer calculo
            Double valorAlcool = Double.parseDouble(precoA);
            Double valorGasolina = Double.parseDouble(precoG);
            // Calculo menor preço = se alcool divido por gasolina for maior que 0.7 é melhor usar gasolina.
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7) {
                TextResultado.setText("Melhor utilizar Gasolina");
            } else {
                TextResultado.setText("Melhor utilizar Alcool");
            }
        } else {
            TextResultado.setText("Prencha os preços primeiro!");
        }
    }
}